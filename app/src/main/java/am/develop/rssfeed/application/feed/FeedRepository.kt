package am.develop.rssfeed.application.feed

import com.prof.rssparser.Channel
import com.prof.rssparser.Parser

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
class FeedRepository(private val rssParser: Parser) {

    suspend fun getFeedItems(url: String){
        val channel: Channel = rssParser.getChannel(url)
    }
}