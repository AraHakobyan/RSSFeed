package am.develop.rssfeed.application.feed

import am.develop.rssfeed.application.feed.db.ArticleModelDb
import am.develop.rssfeed.base.view_model.BaseActivityViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class FeedActivityViewModel(
    private val feedRepository: FeedRepository
) : BaseActivityViewModel() {

    var articlesLiveData: LiveData<PagedList<ArticleModelDb>> = feedRepository.getArticles().toLiveData(pageSize = 10)

    fun loadRssData() {
        viewModelScope.launch(Dispatchers.IO) {
            while (isActive){
                feedRepository.getFeedItems(errorLiveData)
                delay(REQUEST_DELAY)
            }
        }
    }

    companion object{
        /** Delay for make request to get rss info every minute*/
        private const val REQUEST_DELAY = 1000L
    }
}