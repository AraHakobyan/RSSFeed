package am.develop.rssfeed.core.di

import com.prof.rssparser.Parser

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
object RssParserModule {
    val rssParser: Parser = Parser.Builder().build()
}