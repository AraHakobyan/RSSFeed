package am.develop.rssfeed.application.feed.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prof.rssparser.Channel
import com.prof.rssparser.Image

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
@Entity
data class RssFeedInfoModelDb(
    @PrimaryKey
    val url: String,
    val title: String? = null,
    val link: String? = null,
    val description: String? = null,
    val image: Image? = null,
    val lastBuildDate: String? = null,
    val updatePeriod: String? = null
) {
    constructor(url: String, channel: Channel) : this(
        url = url,
        title = channel.title,
        link = channel.link,
        description = channel.description,
        image = channel.image,
        lastBuildDate = channel.lastBuildDate,
        updatePeriod = channel.updatePeriod
    )
}