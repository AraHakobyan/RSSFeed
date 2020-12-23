package am.develop.rssfeed.core.di

import am.develop.rssfeed.application.feed.FeedActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
object AppModule {

    private val feedModule = module {
        viewModel {
            FeedActivityViewModel()
        }
    }

    var modules = listOf(feedModule)
}