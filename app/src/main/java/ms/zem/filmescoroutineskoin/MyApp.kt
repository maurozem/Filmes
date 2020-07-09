package ms.zem.filmescoroutineskoin

import android.app.Application
import ms.zem.filmescoroutineskoin.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MyApp)

            modules(mainModule)
        }
    }

}