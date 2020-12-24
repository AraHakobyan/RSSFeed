package am.develop.rssfeed.application.feed.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
@Dao
interface RssInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRssInfoModel(infoModelDb: RssFeedInfoModelDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticlesModel(vararg articles: ArticleModelDb)

    @Query("select *from RssFeedInfoModelDb where url = :url")
    fun getRssInfoModel(url: String): LiveData<RssFeedInfoModelDb?>

    @Query("select *from ArticleModelDb where url = :url")
    fun getArticles(url: String): LiveData<List<ArticleModelDb>?>
}