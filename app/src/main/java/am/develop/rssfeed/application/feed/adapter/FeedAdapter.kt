package am.develop.rssfeed.application.feed.adapter

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.db.ArticleModelDb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ara Hakobyan on 12/27/2020.
 * Company IDT
 */
class FeedAdapter : PagedListAdapter<ArticleModelDb, FeedAdapter.ViewHolder>(DIFF_UTIL){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun initData(data: ArticleModelDb?){
            data?.let {

            }
        }
    }

    companion object {
        val DIFF_UTIL = object :DiffUtil.ItemCallback<ArticleModelDb>(){
            override fun areItemsTheSame(
                oldItem: ArticleModelDb,
                newItem: ArticleModelDb
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ArticleModelDb,
                newItem: ArticleModelDb
            ): Boolean = oldItem.title == newItem.title && oldItem.author == newItem.author && oldItem.description == newItem.description && oldItem.guid == newItem.guid

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initData(getItem(position))
    }
}