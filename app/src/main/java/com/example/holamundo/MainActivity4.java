package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void siguiente(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_p4);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        PuntuacionManager puntuacionManager = PuntuacionManager.getInstance();
        if (checkedId == -1) {
            Toast.makeText(this, "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.opcion_a_p4) {
            RadioButton radioButton = (RadioButton) findViewById(checkedId);
            puntuacionManager.restarPuntos(2);
            Toast.makeText(this, "Error, pierdes 2 puntos", Toast.LENGTH_SHORT).show();
        } else if(checkedId == R.id.opcion_b_p4) {
            RadioButton radioButton = (RadioButton) findViewById(checkedId);
            puntuacionManager.restarPuntos(2);
            Toast.makeText(this, "Error, pierdes 2 puntos", Toast.LENGTH_SHORT).show();
        } else if(checkedId == R.id.opcion_c_p4) {
            RadioButton radioButton = (RadioButton) findViewById(checkedId);
            puntuacionManager.sumarPuntos(3);
            Toast.makeText(this, "Correcto, suma 3 puntos", Toast.LENGTH_SHORT).show();
        }
        Button button_enviar = (Button) findViewById(R.id.enviar_btm);
        button_enviar.setEnabled(false);
        Button button_siguiente = (Button) findViewById(R.id.next_btm);
        button_siguiente.setEnabled(true);
    }

    public void reiniciar_game(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        PuntuacionManager puntuacionManager = PuntuacionManager.getInstance();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        puntuacionManager.resetearPuntos();
        puntuacionManager.setNombre("");
        finish();
    }

    public void siguiente_pregunta(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}