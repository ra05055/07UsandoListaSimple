package com.example.eliseo.usandolistasimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] paises = {"el salvador", "guatemala", "honduras", "chile", "colombia", "argentina"};
    ListView lista;
    Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView);
        //lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, paises);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView item = (CheckedTextView) view;
                String mensaje = paises[position] + " seleccionado: " + String.valueOf(item.isChecked());

                // Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void btnMostrarClic(View v){
        String seleccion = "";

        try{
            for(int i=0; i < lista.getChildCount(); i++){
                CheckedTextView item = (CheckedTextView) lista.getChildAt(i);
                if(item.isChecked())
                    seleccion += item.getText().toString() + " ";
            }

            Toast.makeText(getApplicationContext(), seleccion, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.d("--", e.getLocalizedMessage());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
