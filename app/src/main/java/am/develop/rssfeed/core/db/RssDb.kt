package am.develop.rssfeed.core.db

import am.develop.rssfeed.application.feed.db.ArticleModelDb
import am.develop.rssfeed.application.feed.db.RssFeedInfoModelDb
import am.develop.rssfeed.application.feed.db.RssInfoDao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
@Database(entities = [RssFeedInfoModelDb::class, ArticleModelDb::class],version = 1,exportSchema = true)
@TypeConverters(Converters::class)
abstract class RssDb: RoomDatabase(){

    abstract fun rssInfoDao(): RssInfoDao

    companion object{
        const val RSS_DB_NAME = "RSS_DB_NAME"
    }
}