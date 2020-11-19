package com.example.appparaclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Saludo extends AppCompatActivity {
    private TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        Toast.makeText(this, "Bienvenido a SALUDO", Toast.LENGTH_LONG).show();
        saludo= (TextView) findViewById(R.id.tv_nomRecibido);

        String datoSaludo=getIntent().getStringExtra("EnvioNombre");
        saludo.setText("Hola: " + datoSaludo);
    }
}