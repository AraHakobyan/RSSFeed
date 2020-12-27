package am.develop.rssfeed.application.feed.data.mocked

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
@Keep
@Parcelize
data class MockedRssDataModel(
    val status: String,
    val feed: MockedFeedInfoModel,
    val items: List<MockedFeedItemModel>
) : Parcelable