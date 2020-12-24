package am.develop.rssfeed.core.di

import am.develop.rssfeed.application.feed.FeedActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
object AppModule {

    private val parserModule = module {
        single {
            RssParserModule.rssParser
        }
    }

    private val feedModule = module {
        viewModel {
            FeedActivityViewModel(get())
        }
    }

    var modules = listOf(feedModule, parserModule)
}