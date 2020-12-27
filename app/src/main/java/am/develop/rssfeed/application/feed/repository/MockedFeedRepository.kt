package am.develop.rssfeed.application.feed.repository

import am.develop.rssfeed.application.feed.data.db.ArticleModelDb
import am.develop.rssfeed.application.feed.data.mocked.MockedFeedItemModel
import am.develop.rssfeed.application.feed.data.mocked.MockedRssDataModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.google.gson.Gson
import java.io.InputStream

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
class MockedFeedRepository(private val mockedDataStream: InputStream, private val gson: Gson) {

    fun loadMockedData(articlesLiveData: LiveData<PagedList<ArticleModelDb>>): List<MockedFeedItemModel> {
        val mockedJson = mockedDataStream.bufferedReader().use{it.readText()}
        val mockedRssDataModel = gson.fromJson(mockedJson, MockedRssDataModel::class.java)
        return mockedRssDataModel.items
    }
}