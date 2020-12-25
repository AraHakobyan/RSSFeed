package am.develop.rssfeed.core.extensions

import am.develop.rssfeed.base.types.ErrorTypes
import java.lang.Exception

/**
 * Created by Ara Hakobyan on 12/25/2020.
 * Company IDT
 */

fun Exception.toErrorType(): @ErrorTypes String = when(message){
    ErrorTypes.ERROR_TYPE_NO_INTERNET_AVAILABLE -> {
        ErrorTypes.ERROR_TYPE_NO_INTERNET_AVAILABLE
    }
    ErrorTypes.ERROR_TYPE_NO_NETWORK_AVAILABLE -> {
        ErrorTypes.ERROR_TYPE_NO_NETWORK_AVAILABLE
    }
    else -> {
        ErrorTypes.ERROR_TYPE_UNKNOWN
    }
}