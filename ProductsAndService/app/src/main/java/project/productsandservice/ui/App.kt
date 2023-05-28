package project.productsandservice.ui

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import project.productsandservice.di.AppComponent
import project.productsandservice.domain.models.StatusSession
import project.productsandservice.ui.start.StartActivity

class App: Application() {
    //lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        //appComponent = DaggerAppComponent.create()
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
