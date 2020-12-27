package am.develop.rssfeed.application.feed.activity

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.adapter.FeedAdapter
import am.develop.rssfeed.application.feed.adapter.MockedFeedAdapter
import am.develop.rssfeed.application.feed.data.db.ArticleModelDb
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
    private val mockedFeedAdapter: MockedFeedAdapter by lazy { MockedFeedAdapter(items = viewModel.mockedFeedModelLiveData.value?.items) }

    override fun onCreateView(): Int = R.layout.activity_feed

    override fun initViewModel() {
        viewModel = getViewModel()
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.articlesLiveData.observe(this, Observer(::onArticlesFetched))
        viewModel.toggleCheckedLiveData.observe(this, Observer(::onToggleStateChanged))
    }

    override fun setupView() {
        viewModel.loadRssData()
        initSourceToggleButton()
        initFeedRecyclerView()
    }

    private fun initSourceToggleButton() {
        sourceSwitcher.setOnCheckedChangeListener { _, isChecked ->
            viewModel.toggleCheckedLiveData.value = isChecked
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
        if (viewModel.toggleCheckedLiveData.value == true) {
            feedAdapter.submitList(items)
        }
    }

    private fun onToggleStateChanged(isChecked: Boolean) {
        if (isChecked) {
            feedRv.adapter = feedAdapter
            viewModel.articlesLiveData.value?.let(::onArticlesFetched)
        } else {
            feedRv.adapter = mockedFeedAdapter
        }
    }
}