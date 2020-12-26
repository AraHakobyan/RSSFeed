package am.develop.rssfeed.core.di

import am.develop.rssfeed.base.types.ErrorTypes
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

/**
 * Created by Ara Hakobyan on 12/25/2020.
 * Company IDT
 */
class NoConnectionInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return if (!isConnectionOn()) {
            throw NoConnectivityException()
        } else if(!isInternetAvailable()) {
            throw NoInternetException()
        } else {
            chain.proceed(chain.request())
        }
    }

    private fun isConnectionOn(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val connection = connectivityManager.getNetworkCapabilities(network)
            return connection != null && (
                    connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
        } else {
            val activeNetwork = connectivityManager.activeNetworkInfo
            if (activeNetwork != null) {
                return (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                        activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
            }
            return false
        }
    }

    private fun isInternetAvailable(): Boolean {
        return try {
            val timeoutMs = 1500
            val sock = Socket()
            val socketAddress = InetSocketAddress(GOOGLE_OPEN_API_HOST_NAME, SOCKET_CONNECTION_PORT)

            sock.connect(socketAddress, timeoutMs)
            sock.close()

            true
        } catch (e: IOException) {
            false
        }

    }

    companion object{
        private const val GOOGLE_OPEN_API_HOST_NAME = "8.8.8.8"
        private const val SOCKET_CONNECTION_PORT = 53
    }

    class NoConnectivityException : IOException() {
        override val message: String
            get() = ErrorTypes.ERROR_TYPE_NO_NETWORK_AVAILABLE
    }

    class NoInternetException : IOException() {
        override val message: String
            get() = ErrorTypes.ERROR_TYPE_NO_INTERNET_AVAILABLE
    }
}