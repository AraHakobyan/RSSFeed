package am.develop.rssfeed.core.di

import am.develop.rssfeed.BuildConfig
import android.content.Context
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by Ara Hakobyan on 12/25/2020.
 * Company IDT
 */
object HttpClientModule {
    private var TIMEOUT_MINUTES: Long = 2
    private var httpClient: OkHttpClient? = null
    private val lock = Any()

    fun getHttpClient(context: Context): OkHttpClient {
        if (httpClient == null) {
            synchronized(lock) {
                if (httpClient == null) {
                    httpClient = OkHttpClient.Builder()
                        .readTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
                        .connectTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
                        .writeTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
                        .addInterceptor(NoConnectionInterceptor(context))
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level =
                                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                        }).build()
                }
                return httpClient!!
            }
        }
        return httpClient!!
    }
}
