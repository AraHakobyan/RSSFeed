package am.develop.rssfeed.application.feed

import am.develop.rssfeed.application.feed.db.RssFeedInfoModelDb
import am.develop.rssfeed.application.feed.db.RssInfoDao
import am.develop.rssfeed.core.extensions.asDbModel
import com.prof.rssparser.Article
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
class FeedRepository(private val rssParser: Parser, private val rssInfoDao: RssInfoDao) {

    suspend fun getFeedItems(url: String) {
        val channel: Channel = rssParser.getChannel(url)
        updateFeedInfoModel(RssFeedInfoModelDb(url, channel))
        updateArticles(url, channel.articles)
    }

    private suspend fun updateFeedInfoModel(data: RssFeedInfoModelDb) {
        rssInfoDao.insertRssInfoModel(data)
    }

    private suspend fun updateArticles(url: String, articles: List<Article>) {
        rssInfoDao.insertArticlesModel(*articles.asDbModel(url).toTypedArray())
    }

    fun getArticlesLiveData(url: String) = rssInfoDao.getArticles(url)
}