package am.develop.rssfeed.application.feed.data.mocked

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */

/**
"title": "Introduction to Reinforcement Learning with David Silver",
"pubDate": "2020-12-27 09:33:25",
"link": "https://deepmind.com/learning-resources/-introduction-reinforcement-learning-david-silver",
"guid": "07c5d0cda55d0ee571312b8b41d25fbf",
"author": "",
"thumbnail": "",
"description": "",
"content": "",
"enclosure": {},
"categories": []
 */
@Keep
@Parcelize
data class MockedFeedItemModel(
    val title: String,
    val pubDate: String,
    val link: String
) : Parcelable