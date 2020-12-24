package am.develop.rssfeed.application.feed

import am.develop.rssfeed.base.BaseActivityViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class FeedActivityViewModel(private val feedRepository: FeedRepository ) : BaseActivityViewModel(){

    fun loadRssData(url: String = "https://news.am/arm/rss/"){
        viewModelScope.launch(Dispatchers.IO) {
            feedRepository.getFeedItems(url)
        }
    }
}