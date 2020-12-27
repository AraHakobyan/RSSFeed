package am.develop.rssfeed.application

import am.develop.rssfeed.core.di.AppModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Ara Hakobyan on 12/23/2020.
 * Company IDT
 */
class RssFeedApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@RssFeedApplication)
            modules(AppModule.modules)
        }
    }
}