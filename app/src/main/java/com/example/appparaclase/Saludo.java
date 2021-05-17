package com.example.appparaclase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private ListView lv1;
    private String nombres[]={"Samuel", "Amaya", "Ana", "Jose", "Luisa", "Maider","Samuel", "Amaya", "Ana", "Jose", "Luisa", "Maider"};
    private String edades[]={"18", "25", "36","18", "25", "36","18", "25", "36","18", "25", "36"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        Toast.makeText(this, "Bienvenido a SALUDO", Toast.LENGTH_LONG).show();
        saludo= (TextView) findViewById(R.id.tv_nomRecibido);
        String datoSaludo=getIntent().getStringExtra("EnvioNombre");
        saludo.setText("Hola: " + datoSaludo);
        saludo = (TextView)findViewById(R.id.tv_nomRecibido);
        lv1=(ListView)findViewById(R.id.lv1);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_amaya, nombres);
        lv1.setAdapter(adapter);
        //registrar los controloes para los menus contextuales
        //detecta el toque largo en los controles
        registerForContextMenu(saludo);
        registerForContextMenu(lv1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                saludo.setText("La edad de "+ lv1.getItemAtPosition(position)+ " es "+ edades[position] + " años");
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id=v.getId();
        MenuInflater menuinflater=getMenuInflater();
        switch (id){
            case R.id.tv_nomRecibido:
                menuinflater.inflate(R.menu.menu_contextual_textview, menu);
                break;
            case R.id.lv1:
                menuinflater.inflate(R.menu.menu_contextual_listview, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

}