package am.develop.rssfeed.application.feed

import am.develop.rssfeed.application.feed.db.ArticleModelDb
import am.develop.rssfeed.base.view_model.BaseActivityViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class FeedActivityViewModel(
    private val feedRepository: FeedRepository,
    private val defaultUrl: String
) : BaseActivityViewModel() {
    private val rssUrlLiveData: MutableLiveData<String> = MutableLiveData()
    var articlesLiveData: LiveData<List<ArticleModelDb>?> = getArticles()

    fun loadRssData(url: String = defaultUrl) {
        rssUrlLiveData.value = url
        articlesLiveData = getArticles()
        viewModelScope.launch(Dispatchers.IO) {
            feedRepository.getFeedItems(url)
        }
    }

    private fun getArticles() =
        feedRepository.getArticlesLiveData(url = rssUrlLiveData.value ?: defaultUrl)
}