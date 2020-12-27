package am.develop.rssfeed.core.di

import com.prof.rssparser.Parser
import okhttp3.OkHttpClient

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
object RssParserModule {

    private var rssParser: Parser? = null

    fun getRssParserInstance(okHttpClient: OkHttpClient): Parser{
            if (rssParser == null) {
                rssParser = Parser.Builder(okHttpClient = okHttpClient).build()
            }
            return rssParser!!
        }
}