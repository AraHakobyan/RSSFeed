package am.develop.rssfeed.application.feed.adapter

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.data.mocked.MockedFeedItemModel
import am.develop.rssfeed.application.feed.data.db.ArticleModelDb
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<AppCompatTextView>(R.id.feed_item_title)
    private val date = itemView.findViewById<AppCompatTextView>(R.id.feed_item_date)

    fun initData(data: ArticleModelDb?) {
        data?.let {
            title.text = it.title
            date.text = it.pubDate
        }
    }

    fun initData(data: MockedFeedItemModel?) {
        title.text = data?.title
        date.text = data?.pubDate
    }
}