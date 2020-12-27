package am.develop.rssfeed.application.feed.activity

import am.develop.rssfeed.application.feed.data.db.ArticleModelDb
import am.develop.rssfeed.application.feed.data.db.RssFeedInfoModelDb
import am.develop.rssfeed.application.feed.data.mocked.MockedRssDataModel
import am.develop.rssfeed.application.feed.repository.FeedRepository
import am.develop.rssfeed.application.feed.repository.MockedFeedRepository
import am.develop.rssfeed.base.view_model.BaseActivityViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import kotlinx.coroutines.*

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class FeedActivityViewModel(
    private val feedRepository: FeedRepository,
    private val mockedFeedRepository: MockedFeedRepository
) : BaseActivityViewModel() {

    val toggleCheckedLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = true
    }
    val mockedFeedModelLiveData: MutableLiveData<MockedRssDataModel> = MutableLiveData<MockedRssDataModel>().apply {
        value =  mockedFeedRepository.loadMockedData()
    }
    val articlesLiveData: LiveData<PagedList<ArticleModelDb>> =
        feedRepository.getArticles().toLiveData(pageSize = FEED_LOADING_PAGE_SIZE)

    val articlesInfoLiveData: LiveData<List<RssFeedInfoModelDb>> = feedRepository.getArticlesInfo()

    private val loadRssJob: Job by lazy {
        initLoadRssJob()
    }

    private fun initLoadRssJob(): Job = viewModelScope.launch {
        while (isActive) {
            feedRepository.getFeedItems(errorLiveData)
            delay(REQUEST_DELAY)
        }
    }

    fun loadRssData() {
        loadRssJob.start()
    }

    companion object {
        /** Delay for make request to get rss info every minute*/
        private const val REQUEST_DELAY = 1000L * 60
        private const val FEED_LOADING_PAGE_SIZE = 10
    }
}