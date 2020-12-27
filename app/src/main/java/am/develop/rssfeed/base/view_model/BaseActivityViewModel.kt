package am.develop.rssfeed.base.view_model

import am.develop.rssfeed.base.types.ErrorTypes
import androidx.lifecycle.MutableLiveData

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
open class BaseActivityViewModel : BaseViewModel() {
    val errorLiveData: MutableLiveData<@ErrorTypes String?> = MutableLiveData()

    fun clearErrorInfo() {
        errorLiveData.value = null
    }
}