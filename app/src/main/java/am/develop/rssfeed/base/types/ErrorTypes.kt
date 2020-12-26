package am.develop.rssfeed.base.types

import am.develop.rssfeed.base.types.ErrorTypes.Companion.ERROR_TYPE_NO_INTERNET_AVAILABLE
import am.develop.rssfeed.base.types.ErrorTypes.Companion.ERROR_TYPE_NO_NETWORK_AVAILABLE
import androidx.annotation.StringDef

/**
 * Created by Ara Hakobyan on 12/25/2020.
 * Company IDT
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@StringDef(ERROR_TYPE_NO_NETWORK_AVAILABLE, ERROR_TYPE_NO_INTERNET_AVAILABLE)
annotation class ErrorTypes {
    companion object{
        const val ERROR_TYPE_UNKNOWN = "UNKNOWN"
        const val ERROR_TYPE_NO_NETWORK_AVAILABLE = "NO_NETWORK_AVAILABLE"
        const val ERROR_TYPE_NO_INTERNET_AVAILABLE = "NO_INTERNET_AVAILABLE"
    }
}