package am.develop.rssfeed.core.di

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.FeedActivity
import am.develop.rssfeed.application.feed.FeedActivityViewModel
import am.develop.rssfeed.application.feed.FeedRepository
import am.develop.rssfeed.core.db.RssDb
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
object AppModule {

    private val dbModule = module {
        single {
            Room.databaseBuilder(get(), RssDb::class.java, RssDb.RSS_DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
        single { get<RssDb>().rssInfoDao() }
    }

    private val parserModule = module {
        single {
            RssParserModule.rssParserInstance
        }
    }

    private val feedModule = module {

        viewModel {
            FeedActivityViewModel(get(), androidContext().resources.getString(R.string.default_url))
        }

        single {
            FeedRepository(get(), get())
        }
    }

    var modules = listOf(feedModule, parserModule, dbModule)
}