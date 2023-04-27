package ru.project.examtest.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import ru.project.examtest.databinding.ActivityAdminBinding;
import ru.project.examtest.ui.blitz_test.BlitzTestActivity;
import ru.project.examtest.ui.point_calculator.PointCalculatorActivity;
import ru.project.examtest.ui.tables_and_diagrams.CreateTAD_Activity;
import ru.project.examtest.ui.tables_and_diagrams.TablesAndDiagramsActivity;
import ru.project.examtest.ui.tasks_by_topic.TasksByTopicActivity;
import ru.project.examtest.ui.theorys.CreateTheorysActivity;
import ru.project.examtest.ui.theorys.TheorysActivity;

public class AdminActivity extends AppCompatActivity {
    ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarAdmin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                                        CreateTheorysActivity.class
                                )
                        );
                        break;

                    case "Таблицы и схемы":
                        startActivity(
                                new Intent(
                                        getApplicationContext(),
                                        CreateTAD_Activity.class
                                )
                        );
                        break;

                    case "Задания по темам":
                        startActivity(
                                new Intent(
                                        getApplicationContext(),
                                        TasksByTopicActivity.class
                                )
                        );
                        break;

                    case "Блиц тест":
                        startActivity(
                                new Intent(
                                        getApplicationContext(),
                                        BlitzTestActivity.class
                                )
                        );
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
                        startActivity(
                                new Intent(
                                        getApplicationContext(),
                                        PointCalculatorActivity.class
                                )
                        );
                        break;

                }
                return false;
            }
        });
    }
}