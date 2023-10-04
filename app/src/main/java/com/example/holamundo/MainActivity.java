package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity<view> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar_seleccion(View view) {
        EditText nombre = findViewById(R.id.user_Name);
        String name = nombre.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "Intorduce tu nombre", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Que empiece el juego, "+name, Toast.LENGTH_SHORT).show();
            PuntuacionManager puntuacionManager = PuntuacionManager.getInstance();
            puntuacionManager.setNombre(name);
            Intent intent = new Intent(this, MainActivity1.class);
            startActivity(intent);
        }

    }
}