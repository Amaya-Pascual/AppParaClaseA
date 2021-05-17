package com.example.appparaclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombreIntroducido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Bienvenido al MAIN", Toast.LENGTH_LONG).show();
        nombreIntroducido= (EditText)findViewById(R.id.et_nombre);
    }

    public void Entrar(View view)
    {
        Intent main_saludo = new Intent(this, Saludo.class);
        main_saludo.putExtra("EnvioNombre", nombreIntroducido.getText().toString());
        startActivity(main_saludo);
    }

    public void Llamar(View view)
    {
        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        try {
            startActivity(callIntent);
        } catch (ActivityNotFoundException e)
        {
            Toast.makeText(this, "Ha habido un error", Toast.LENGTH_LONG).show();
        }

    }
}