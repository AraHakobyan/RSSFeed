package am.develop.rssfeed.base.view

import am.develop.rssfeed.R
import am.develop.rssfeed.base.types.ErrorTypes
import am.develop.rssfeed.base.view_model.BaseActivityViewModel
import am.develop.rssfeed.core.utils.EMPTY
import android.content.DialogInterface
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
abstract class BaseActivity<VIEW_MODEL : BaseActivityViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VIEW_MODEL
    private lateinit var dialogBuilder: AlertDialog.Builder
    private var alertDialog: AlertDialog? = null

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

    private fun showInfoDialog(
        onPosBtnClicked: (() -> Unit)? = null,
        onNegButtonClicked: (() -> Unit)? = null,
        title: String = EMPTY,
        message: String = EMPTY,
        posBtnText: String = resources.getString(R.string.text_ok),
        negBtnText: String = EMPTY,
        isCancelable: Boolean = false
    ) {
        dialogBuilder = AlertDialog.Builder(this)
        alertDialog = dialogBuilder.create()
        dialogBuilder
            .setTitle(title)
            .setMessage(message)
            .setCancelable(isCancelable)
        onNegButtonClicked?.let {
            dialogBuilder.setNegativeButton(negBtnText) { _: DialogInterface?, _: Int ->
                onNegButtonClicked.invoke()
                alertDialog?.dismiss()
            }
        }
        dialogBuilder.setPositiveButton(posBtnText) { _: DialogInterface?, _: Int ->
            onPosBtnClicked?.invoke()
            alertDialog?.dismiss()
        }
        dialogBuilder?.show()
    }


    private fun onError(@ErrorTypes errorTypes: String){
        when(errorTypes){
            ErrorTypes.ERROR_TYPE_NO_NETWORK_AVAILABLE -> {
                showInfoDialog(message = getString(R.string.error_message_no_network))
            }
            ErrorTypes.ERROR_TYPE_NO_INTERNET_AVAILABLE -> {
                showInfoDialog(message = getString(R.string.error_message_no_internet))
            }
            ErrorTypes.ERROR_TYPE_UNKNOWN -> {
                showInfoDialog(message = getString(R.string.error_message_unknown))
            }
        }
    }
}