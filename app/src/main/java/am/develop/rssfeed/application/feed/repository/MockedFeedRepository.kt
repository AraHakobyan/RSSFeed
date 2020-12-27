package am.develop.rssfeed.application.feed.repository

import am.develop.rssfeed.application.feed.db.ArticleModelDb
import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
class MockedFeedRepository {

    fun loadMockedData(articlesLiveData: LiveData<PagedList<ArticleModelDb>>): PagedList<ArticleModelDb>? {
        return null
    }
}