package com.example.lr12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<Employee> adapter;
    private EditText nameText, positionText;
    private List<Employee> employees;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        positionText = findViewById(R.id.positionText);
        listView = findViewById(R.id.list);
        employees = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        listView.setAdapter(adapter);
    }

    public void addEmployee(View view) {
        String name = nameText.getText().toString();
        String position = positionText.getText().toString();
        Employee employee = new Employee(name, position);
        employees.add(employee);
        adapter.notifyDataSetChanged();
    }

    public void save(View view) {
        boolean result = JSONHelper.exportToJSON(this, employees);
        if (result){
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
    }

    public void open(View view) {
        employees = JSONHelper.importFromJSON(this);
        if (employees != null){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
            listView.setAdapter(adapter);
            Toast.makeText(this, "Данные восстановлены", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Не удалось открыть данные", Toast.LENGTH_LONG).show();
        }
    }
}