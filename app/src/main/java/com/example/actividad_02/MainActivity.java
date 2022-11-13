package com.example.actividad_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //A
    //1o hemos creado los botones
    private Button propio, simple1, simple2, frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LlamadaAdaptadorSimpleSpinner();

        //A
        //Los hemos enlazado con las vistas del activity_main.xml
        propio = findViewById(R.id.propio);
        simple2 = findViewById(R.id.simple2);
        simple1 = findViewById(R.id.simple1);
        frutas = findViewById(R.id.frutas);
        //Hemos hecho un setOnClickListener para cada botón
        //Con su metodo correspondiente
        propio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamadaAdaptadorPropioListView();
            }
        });
        simple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LLamadaAdaptadorSimple2();
            }
        });
        simple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LLamadaAdaptadorSimple1();
            }
        });


    }
    //A
    //He modificado el nombre del metodo, de esta manera
    //En el set onclick listener del botón simple 1 llamará
    //a este metodo llamado LlamadaAdaptador Simple1 y pasa
    //Lo mismo con el botón simple2
    private void LLamadaAdaptadorSimple1() {
        // Este es el array en donde están los datos a visualizar
        String[] jmh_opciones = {"hola","adios","Viernes"};
        //Crea el adaptador
        //Lo inicializa con el array de arriba jmh_opciones y en este contexto le da el formato de
        // "support_simple_spinner_dropdown_item" gracias a la clase R
        ArrayAdapter<String> jmh_adapter1 = new ArrayAdapter <String>
                //Para que sirve getApplication Context()?
                (getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,jmh_opciones);
        //Creamos variable que apunte al ListView del Layout
        ListView jmh_origen = (ListView) findViewById(R.id.listviewjmh);
        //Metemos los valores del adaptador en el listview
        jmh_origen.setAdapter(jmh_adapter1);
    }

    private void LLamadaAdaptadorSimple2() {
        // Este es el array en donde están los datos a visualizar
        String[] jmh_opciones = {"hola","adios"};
        //Definimos el adaptador
        ArrayAdapter<String>adapter_jmh=new ArrayAdapter<String>
                //En este contexto le da el formato "simple_list_item_2 del directorio layout
                //text 1 es un identificador que te permite cambiar el diseño del layout con el directorio
                //android.R.id
                //por ultimo lo inicializa con el array creado arriba
                (this, android.R.layout.simple_list_item_2,android.R.id.text1, jmh_opciones);
        //Creamos variable que apunte al ListView del Layout
        ListView jmh_origen = (ListView) findViewById(R.id.listviewjmh);
        //Inflamos los valores del ListView usando el adaptador
        jmh_origen.setAdapter(adapter_jmh);
    }

    //Crea un spinner simple
    private void LlamadaAdaptadorSimpleSpinner() {
        // Este es el array en donde están los datos a visualizar
        String[] jmh_opciones = {"hola","adios"};
        //Definimos el adaptador
        ArrayAdapter<String> jmh_adapter1 = new ArrayAdapter <String> (MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,jmh_opciones);
        //Creamos variable que apunte al spinner del Layout
        Spinner jmh_origen = (Spinner) findViewById(R.id.spinnerjmh);
        //Inflamos los valores del spinner usando el adaptador
        jmh_origen.setAdapter(jmh_adapter1);


    }

    //A
    //Para hacer un objeto de User ha creado una clase nueva en un nuevo
    //java donde estan los users en la misma carpeta que este
    // archivo java, por lo tanto crea un nuevo arraylist de tipo
    //User y le pasa 2 Strings por parametro que son nombre y ciudad
    private void LlamadaAdaptadorPropioListView() {
        // Creamos los datos

        //1 Crea un array de tipo user
        ArrayList<User> arrayOfUsers_jmh = new ArrayList<User>();

        //2 Añade los datos al array
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        arrayOfUsers_jmh.add(new User("Nathan", "San Diego"));
        // Definimos el adaptador propio. En este caso no posee layout.
        //Aqui a creado un adaptador propio llamado adapter_jmh que inicializa
        //Con los valores del array de Users creado anteriormente

        //3 Crea un adaptador
        UsersAdapter adapter_jmh = new UsersAdapter(this, arrayOfUsers_jmh);

        //4 Crea un listView y lo enlaza con una vista de tipo listView del xml
        ListView listView_jmh = (ListView) findViewById(R.id.listviewjmh);

        //5 Con el adaptador nuevo y un set, mete los valores del adaptador en el listView XML
        listView_jmh.setAdapter(adapter_jmh);

        // Limpiar el adaptador NO SE COMO LO LIMPIA Xd (APRENDER)
        //adapter_jmh.clear();
    }
    public void abreFrutas(View view){ //Esta clase nos servirá para abrir el activity Frutas
        //Es muy importante poner el parametro view ya que después
        //Hemos puesto el Onclick listener seleccionando el botón desde el apartado diseño
        //Y escogiendo este metodo
        Intent intent = new Intent(this, FrutasActivity.class); //El intent nos ayuda a enviar
        startActivity(intent); //Esto hace un start de la actividad que hemos marcado arriba en el intent
    }
}









