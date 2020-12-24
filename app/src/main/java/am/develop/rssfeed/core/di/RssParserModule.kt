package am.develop.rssfeed.core.di

import com.prof.rssparser.Parser

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
object RssParserModule {

    private var rssParser: Parser? = null

    val rssParserInstance: Parser
        get() {
            if (rssParser == null) {
                rssParser = Parser.Builder().build()
            }
            return rssParser!!
        }
}