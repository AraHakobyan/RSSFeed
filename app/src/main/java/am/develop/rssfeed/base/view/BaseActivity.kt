package am.develop.rssfeed.base.view

import am.develop.rssfeed.base.BaseActivityViewModel
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

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

    open fun initObservers() = Unit
}