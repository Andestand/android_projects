package ru.project.monumentsOfBrazil.ui.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ru.project.monumentsOfBrazil.R
import ru.project.monumentsOfBrazil.databinding.ActivitySplashScreenBinding
import ru.project.monumentsOfBrazil.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Устанавливаемъ SplashScreen черезъ методъ installSplashScreen
        installSplashScreen()

        // Задаёмъ задержку передъ переходомъ
        // Вместо задержки здесь можно выполнить любую нужную для вашего SplashScreen логику
        // напримеръ, загрузку данныхъ или анимацiю
        // После окончанiя активности SplashScreen можно будетъ закрыть
        // либо автоматически, либо после выполненiя заданной логики
        Thread {
            Thread.sleep(1000)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }.start()
    }
}