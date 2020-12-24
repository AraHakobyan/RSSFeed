package am.develop.rssfeed.core.extensions

import am.develop.rssfeed.application.feed.db.ArticleModelDb
import com.prof.rssparser.Article

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
fun List<Article>.asDbModel(url: String): List<ArticleModelDb> = map { ArticleModelDb(url, it) }