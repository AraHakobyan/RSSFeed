package am.develop.rssfeed.application.feed.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prof.rssparser.Article

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
@Entity
data class ArticleModelDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val url: String,
    var guid: String? = null,
    var title: String? = null,
    var author: String? = null,
    var link: String? = null,
    var pubDate: String? = null,
    var description: String? = null,
    var content: String? = null,
    var image: String? = null,
    var audio: String? = null,
    var video: String? = null,
    var sourceName: String? = null,
    var sourceUrl: String? = null,
    var categories: List<String>
) {
    constructor(url: String, data: Article) : this(
        url = url,
        guid = data.guid,
        title = data.title,
        author = data.author,
        link = data.link,
        pubDate = data.pubDate,
        description = data.description,
        content = data.content,
        image = data.image,
        audio = data.audio,
        video = data.video,
        sourceName = data.sourceName,
        sourceUrl = data.sourceUrl,
        categories = data.categories
    )
}