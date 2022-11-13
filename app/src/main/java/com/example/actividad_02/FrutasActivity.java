package com.example.actividad_02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FrutasActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);

        // POR LO VISTO
        //EN EL OBJETO FRUTA SOLO SE PONEN
        //LOS STRINGS NI BOTONES NI NINGUNA VIEW
        //SOLO LOS DATOS DEL OBJETO EN STRING

        //LOS OBJETOS LOS CREAS TU EN EL XML
        //Y APARECERAN

        //LE DAMOS FUNCIONALIDAD A LOS BOTONES
        //DESDE EL ADAPTADOR

        //LE DAMOS VALOR A EL TEXT VIEW
        //PASANDO POR PARAMETRO EL VALOR Y CON
        //EL ADAPTADOR Y LA CLASE FRUTA


        LlamadaAdaptadorPRUEBA();
        //llamadaAListaDeFrutas();
    }



    private void LlamadaAdaptadorPRUEBA() {
        // Creamos los datos

        //1 Crea un array de tipo user
        ArrayList<Fruta> arrayOfFruta = new ArrayList<Fruta>();

        //2 Añade los datos al array
        CreadorDeBitmap c = new CreadorDeBitmap();

     // antes  arrayOfFruta.add(new Fruta("Naranja",0,c.bff(1,1)));
        arrayOfFruta.add(new Fruta("Naranja",0));
        // Definimos el adaptador propio. En este caso no posee layout.
        //Aqui a creado un adaptador propio llamado adapter_jmh que inicializa
        //Con los valores del array de Users creado anteriormente

        //3 Crea un adaptador
        FrutasAdapter adapter = new FrutasAdapter(this, arrayOfFruta);

        //4 Crea un listView y lo enlaza con una vista de tipo listView del xml
        ListView listView_jmh = (ListView) findViewById(R.id.listview_frutas);

        //5 Con el adaptador nuevo y un set, mete los valores del adaptador en el listView XML
        listView_jmh.setAdapter(adapter);

    }




/*
    private void llamadaAListaDeFrutas(){
        //1 Creamos un array de tipo ListaDeFrutas llamado "fruta"
        ArrayList<Fruta> ArrayDeFrutas = new ArrayList<Fruta>();

        //Igualmente el metodo retorna una variable de tipo imageview
        //hacemos una variable tipo imageview en el otro lado en ViewHolder
        //y ya esta

        //2 Creamos un dato del array
       // ArrayDeFrutas.add(new Fruta(bff(0,0),"Naranja"));
        ArrayDeFrutas.add(new Fruta("Naranja",0));

        //3 Creamos el adaptador y lo inicializamos
        FrutasAdapter adapterfrutas = new FrutasAdapter(this, ArrayDeFrutas);

        //4 Luego crea un listView y lo enlaza con una vista de tipo listView del xml
        ListView listView_frutas = (ListView) findViewById(R.id.listview_frutas);

        //5 Con el adaptador nuevo y un set, mete los valores del adaptador en el listView XML
        listView_frutas.setAdapter(adapterfrutas);
    }

 */

    //Metodo que devuelve un ImageView, apartir de un bitmap de una foto de fruta
    //pasando las coordenadas x y y para seleccionar la fruta indicada
    //Se llama Bitmap Foto fruta "BFF"


    public ImageView bff(int x, int y){
        //Aqui creamos una variable bitmap y le damos el valor de la imagen que tenemos
        //en el directorio drawable
        Bitmap imgFrutas= BitmapFactory.decodeResource(getResources(),R.drawable.bitmapfrutas);
        int w = imgFrutas.getWidth()/4;
        int h = imgFrutas.getHeight()/4;
        //Aqui trozeamos el bitmap y lo metemos en la variable imgFrutas
        imgFrutas=Bitmap.createBitmap
                //Estos dos primeros entiendo que es la posición del bitmap a la que haces referencia
                //Primero escribimos el nombre de la variable y luego el punto que queremos.
                //Height = altura, Width = Ancho
                        (imgFrutas,x*w, //Fila Posición 0 de 4
                                y*h, // Columna 2 de 4
                                //Esto es el trozeado del bitmap
                                //Significa que cogemos su altura y su anchura y la dividimos en 4 y 4
                                imgFrutas.getWidth()/4,
                                imgFrutas.getHeight()/4);

        ImageView foto = null;
        foto.setImageBitmap(imgFrutas);
        return foto;
    }
}