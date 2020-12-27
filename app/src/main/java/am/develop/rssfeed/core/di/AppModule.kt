package am.develop.rssfeed.core.di

import am.develop.rssfeed.R
import am.develop.rssfeed.application.feed.activity.FeedActivityViewModel
import am.develop.rssfeed.application.feed.data.mocked.MockedRssDataModel
import am.develop.rssfeed.application.feed.repository.FeedRepository
import am.develop.rssfeed.application.feed.repository.MockedFeedRepository
import am.develop.rssfeed.core.db.RssDb
import androidx.room.Room
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.io.InputStream

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

    private val gsonModule = module {
        single {
            Gson()
        }
    }

    private val feedModule = module {

        viewModel {
            FeedActivityViewModel(get(), get())
        }

        single {
            FeedRepository(get(), get(), androidContext().resources.getString(R.string.default_url))
        }


        single {
            MockedFeedRepository(get())
        }

        fun provideMockedData(mockedDataStream: InputStream, gson: Gson) : MockedRssDataModel{
            val mockedJson = mockedDataStream.bufferedReader().use { it.readText() }
            return gson.fromJson(mockedJson, MockedRssDataModel::class.java)
        }

        single {
            provideMockedData(androidContext().resources.assets.open("RSSMockedData.json"), get())
        }
    }

    var modules = listOf(feedModule, parserModule, dbModule, httpClientModule, gsonModule)
}