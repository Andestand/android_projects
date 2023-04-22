package ru.project.examtest.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import ru.project.examtest.databinding.ActivityMainBinding;
import ru.project.examtest.ui.terms.TermsActivity;
import ru.project.examtest.ui.theorys.TheorysActivity;

public class MainActivity extends AppCompatActivity {
    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navView();
    }

    public void navView() {
        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "Теория":
                        startActivity(
                                new Intent(
                                        getApplicationContext(),
                                        TheorysActivity.class
                                )
                        );
                        break;

                    case "Таблицы и схемы":
                        Toast.makeText(
                                getApplicationContext(),
                                "Таблицы и схемы", Toast.LENGTH_LONG
                        ).show();
                        break;

                    case "Термины":
                        startActivity(
                                new Intent(
                                        getApplicationContext(),
                                        TermsActivity.class
                                )
                        );
                        break;

                    case "Основные формулы":
                        Toast.makeText(
                                getApplicationContext(),
                                "Основные формулы", Toast.LENGTH_LONG
                        ).show();
                        break;

                    case "Задания по темам":
                        Toast.makeText(
                                getApplicationContext(),
                                "Задания по темам", Toast.LENGTH_LONG
                        ).show();
                        break;

                    case "Блиц тест":
                        Toast.makeText(
                                getApplicationContext(),
                                "Блиц тест", Toast.LENGTH_LONG
                        ).show();
                        break;

                    case "Тест ОГЭ #Б":
                        Toast.makeText(
                                getApplicationContext(),
                                "Тест ОГЭ #Б", Toast.LENGTH_LONG
                        ).show();
                        break;

                    case "Тест ОГЭ #П":
                        Toast.makeText(
                                getApplicationContext(),
                                "Тест ОГЭ #П", Toast.LENGTH_LONG
                        ).show();
                        break;

                    case "Калькулятор баллов":
                        Toast.makeText(
                                getApplicationContext(),
                                "Калькулятор баллов", Toast.LENGTH_LONG
                        ).show();
                        break;

                }
                return false;
            }
        });
    }
}