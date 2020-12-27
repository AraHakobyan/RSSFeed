package am.develop.rssfeed.application.feed.repository

import am.develop.rssfeed.application.feed.data.db.RssFeedInfoModelDb
import am.develop.rssfeed.application.feed.data.db.RssInfoDao
import am.develop.rssfeed.base.types.ErrorTypes
import am.develop.rssfeed.core.extensions.asDbModel
import am.develop.rssfeed.core.extensions.toErrorType
import androidx.lifecycle.MutableLiveData
import com.prof.rssparser.Article
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
class FeedRepository(private val rssParser: Parser, private val rssInfoDao: RssInfoDao, private val defaultUrl: String) {

    /**
     * get feed items
     * save into local db
     */
    suspend fun getFeedItems(errorLiveData: MutableLiveData<@ErrorTypes String>)  {
        try {
            val channel: Channel = rssParser.getChannel(defaultUrl)
            updateFeedInfoModel(RssFeedInfoModelDb(defaultUrl, channel))
            updateArticles(channel.articles)
        }catch (ex: Exception){
            errorLiveData.postValue(ex.toErrorType())
        }
    }

    private suspend fun updateFeedInfoModel(data: RssFeedInfoModelDb) {
        rssInfoDao.insertRssInfoModel(data)
    }

    private suspend fun updateArticles(articles: List<Article>) {
        rssInfoDao.insertArticlesModel(*articles.asDbModel().toTypedArray())
    }

    fun getArticles() = rssInfoDao.getArticles()
}