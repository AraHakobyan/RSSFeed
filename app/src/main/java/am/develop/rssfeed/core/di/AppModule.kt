package am.develop.rssfeed.core.di

import am.develop.rssfeed.R
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
            RssParserModule.getRssParserInstance(get())
        }
    }

    private val httpClientModule = module {
        single {
            HttpClientModule.getHttpClient(get())
        }
    }

    private val feedModule = module {

        viewModel {
            FeedActivityViewModel(get())
        }

        single {
            FeedRepository(get(), get(), androidContext().resources.getString(R.string.default_url))
        }
    }

    var modules = listOf(feedModule, parserModule, dbModule, httpClientModule)
}