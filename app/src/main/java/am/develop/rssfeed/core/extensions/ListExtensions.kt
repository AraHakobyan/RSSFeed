package am.develop.rssfeed.core.extensions

import am.develop.rssfeed.application.feed.data.db.ArticleModelDb
import com.prof.rssparser.Article

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
fun List<Article>.asDbModel(): List<ArticleModelDb> = map { ArticleModelDb(it) }