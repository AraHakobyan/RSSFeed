package am.develop.rssfeed.application.feed

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.adapter.FeedAdapter
import am.develop.rssfeed.application.feed.db.ArticleModelDb
import am.develop.rssfeed.base.view.BaseActivity
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_feed.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class FeedActivity : BaseActivity<FeedActivityViewModel>() {

    private val feedAdapter: FeedAdapter by lazy { FeedAdapter() }

    override fun onCreateView(): Int = R.layout.activity_feed

    override fun initViewModel() {
        viewModel = getViewModel()
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.articlesLiveData.observe(this, Observer(::onArticlesFetched))
    }

    override fun setupView() {
        viewModel.loadRssData()
        initSourceToggleButton()
        initFeedRecyclerView()
    }

    private fun initSourceToggleButton() {
        sourceSwitcher.run {

        }
    }

    private fun initFeedRecyclerView() {
        feedRv.run {
            layoutManager = LinearLayoutManager(this@FeedActivity)
            setHasFixedSize(true)
            adapter = feedAdapter
        }
    }

    private fun onArticlesFetched(items: PagedList<ArticleModelDb>) {
        feedAdapter.submitList(items)
    }
}