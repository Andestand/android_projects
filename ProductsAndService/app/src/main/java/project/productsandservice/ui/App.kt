package project.productsandservice.ui

import org.koin.core.context.startKoin
import project.productsandservice.di.*
import org.koin.android.ext.koin.*
import org.koin.core.logger.Level
import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }

        /*val db = Room.databaseBuilder(
            applicationContext,
            MyRoomManager::class.java, "db_sessions"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        db.sessionDAO().getSessionAll().forEach {
            if (it.isStatus == StatusSession.Active) {

            } else {
                startActivity(
                    Intent(
                        this@App,
                        StartActivity::class.java
                    )
                )
            }
        }*/
    }

}
