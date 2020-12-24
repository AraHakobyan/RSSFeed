package am.develop.rssfeed.application.feed

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.db.ArticleModelDb
import am.develop.rssfeed.base.view.BaseActivity
import android.widget.Toast
import androidx.lifecycle.Observer
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

    override fun initObservers() {
        super.initObservers()
        viewModel.articlesLiveData.observe(this, Observer (::onArticlesFetched))
    }

    override fun setupView() {
        viewModel.loadRssData()
    }

    private fun onArticlesFetched(items: List<ArticleModelDb>?){
        Toast.makeText(this, "${items?.size}", Toast.LENGTH_LONG).show()
    }
}