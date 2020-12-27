package am.develop.rssfeed.application.feed.data.mocked

import am.develop.rssfeed.core.utils.EMPTY
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
/**
"url": "https://news.ycombinator.com/rss",
"title": "Hacker News",
"link": "https://news.ycombinator.com/",
"author": "",
"description": "Links for the intellectually curious, ranked by readers.",
"image": ""
 */
@Keep
@Parcelize
data class MockedFeedInfoModel(
    val url: String,
    val title: String,
    val link: String,
    val author: String,
    val description: String,
    val image: String = EMPTY
): Parcelable