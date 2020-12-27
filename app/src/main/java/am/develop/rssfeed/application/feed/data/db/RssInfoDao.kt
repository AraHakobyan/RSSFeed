package am.develop.rssfeed.application.feed.data.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

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

    @Query("select *from RssFeedInfoModelDb")
    fun getRssInfoModel(): LiveData<List<RssFeedInfoModelDb>>

    @Query("select *from ArticleModelDb")
    fun getArticles(): DataSource.Factory<Int, ArticleModelDb>
}