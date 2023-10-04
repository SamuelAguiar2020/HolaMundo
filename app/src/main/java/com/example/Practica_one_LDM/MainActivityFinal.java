package com.example.Practica_one_LDM;

import static com.example.Practica_one_LDM.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main_final);
        PuntuacionManager puntuacionManager = PuntuacionManager.getInstance();
        TextView score_text = findViewById(id.player_points);
        int puntuacion = puntuacionManager.getPuntos();
        score_text.setText(""+puntuacion);
        TextView text = findViewById(id.text_final_message);
        if(puntuacion <= 0){
            text.setText("Me temo que no conces muy bien el tema");
        }else if (puntuacion < 6){
            text.setText("No esta mal, pero puedes hacerlo mucho mejor ");
        }else if (puntuacion < 11){
            text.setText("Muy bien, se nota que conoces del tema, un poco mas y seras un experto");
        }else if (puntuacion == 15){
            text.setText("Eso a sido perfecto, eres sin duda un experto en el tema");
        }
        String name = PuntuacionManager.getInstance().getNombre();
        TextView player_name = findViewById(R.id.player_name);
        player_name.setText(name);
    }

    public void end_game(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        PuntuacionManager puntuacionManager = PuntuacionManager.getInstance();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        puntuacionManager.resetearPuntos();
        puntuacionManager.setNombre("");
        finish();
    }
}