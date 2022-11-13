package com.example.actividad_02;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FrutasAdapter extends ArrayAdapter<Fruta> {
    // El constructor solo recibe dos parámetro, pero le pasa al padre 3
    // El layout que se le pasa es el 0 debido a que se le pasa uno propio más abajo
    public FrutasAdapter(Context context, ArrayList<Fruta> Frutas) { //al realizar el inflate

        super(context, 0, Frutas);
    }

    private static class ViewHolder {
        //Aqui pongamos todos los datos del XML
        //   ImageView foto;
        String nombreFruta;
        //   Button boton1;
        //   int cantidad;
        //   Button boton2;

    }

    // El método getView se llamará tantas veces como registros tengan los datos a visualizar.
    // Si el array usado posee 10 valores el getView se llamará 10 veces
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // En la variable position tenemos la posición del array que estoy pintando.
        // El getItem es un método propio del ArrayAdapter, en este caso el tipo de adaptador usado es el de la clase "User"
        // por lo tanto el getItem nos devolverá un objeto de tipo "User" que está en la posición "position"
        // En los usos básicos de adaptadores en los spinner se usa un ArrayAdapter<string>
        // //, por lo tanto el getItem nos devolvería un String
        Fruta fruta = getItem(position);
        // Validamos si nos pasan por parámetro la vista a visualizar
        // en caso que esté vacía usaremos la vista (el layout) que hemos creado para visualizar los elementes
        // el inflater se encarga de pintarlo.

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_frutas, parent, false);
        }

        // Creamos las variables que apuntan a los TextView definidos en el layout "itemfrutas.xml"

        //5 Crea los Views que se veran en el xml y los enlaza.

        ImageView ivfotofruta = (ImageView) convertView.findViewById(R.id.imageView2);
        TextView tvnombrefruta = (TextView) convertView.findViewById(R.id.textViewNombre);
        TextView tvcantidad = (TextView) convertView.findViewById(R.id.textViewCantidad);

        // Informamos los valores de los TextView
        //Dejemos la imagen para después, no se como va aún fotofruta.setImage(fruta.foto);



       // ivfotofruta.setImageBitmap(fruta.imgFrutas);//Esto no se si esta bien pero enfin
        tvnombrefruta.setText(fruta.nombreFruta);
        tvcantidad.setText(fruta.cantidad);


        //Podemos añadir eventos dentro de los elementos
        // En este caso he añadido un botón y creo el listener para que mustre un mensage con TOAST
        //Aqui haremos los on click Listener
        // Button b1 = (Button) convertView.findViewById(R.id.button1);
        // Button b2 = (Button) convertView.findViewById(R.id.button2);
        /*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lo que hace el botón 1
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Lo que hace el botón 2
            }
        });
        // Devolvemos la vista para que se pinte (render) por la pantalla

    }

         */
        return convertView;
    }
}



