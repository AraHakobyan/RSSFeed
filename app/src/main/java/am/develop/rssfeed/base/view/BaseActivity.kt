package am.develop.rssfeed.base.view

import am.develop.rssfeed.R
import am.develop.rssfeed.base.types.ErrorTypes
import am.develop.rssfeed.base.view_model.BaseActivityViewModel
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
abstract class BaseActivity<VIEW_MODEL : BaseActivityViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VIEW_MODEL

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel()
        initObservers()
        super.onCreate(savedInstanceState)
        setContentView(onCreateView())
        setupView()
    }

    @LayoutRes
    abstract fun onCreateView(): Int

    abstract fun initViewModel()

    abstract fun setupView()

    open fun initObservers() {
        viewModel.errorLiveData.observe(this, Observer(::onError))
    }

    private fun showInfoMessage(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

    private fun onError(@ErrorTypes errorTypes: String?){
        when(errorTypes){
            ErrorTypes.ERROR_TYPE_NO_NETWORK_AVAILABLE -> {
                showInfoMessage(message = getString(R.string.error_message_no_network))
            }
            ErrorTypes.ERROR_TYPE_NO_INTERNET_AVAILABLE -> {
                showInfoMessage(message = getString(R.string.error_message_no_internet))
            }
            ErrorTypes.ERROR_TYPE_UNKNOWN -> {
                showInfoMessage(message = getString(R.string.error_message_unknown))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearErrorInfo()
    }
}