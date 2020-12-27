package am.develop.rssfeed.application.feed.adapter

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.data.mocked.MockedFeedItemModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
class MockedFeedAdapter(private val items: List<MockedFeedItemModel>) : RecyclerView.Adapter<FeedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.initData(items[position])
    }

    override fun getItemCount(): Int = items.size
}