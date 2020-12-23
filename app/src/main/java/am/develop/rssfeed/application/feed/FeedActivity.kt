package am.develop.rssfeed.application.feed

import am.develop.rssfeed.R
import am.develop.rssfeed.base.view.BaseActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class FeedActivity : BaseActivity<FeedActivityViewModel>(){
    override fun onCreateView(): Int = R.layout.activity_feed

    override fun initViewModel() {
        viewModel = getViewModel()
    }

    override fun setupView() {

    }
}