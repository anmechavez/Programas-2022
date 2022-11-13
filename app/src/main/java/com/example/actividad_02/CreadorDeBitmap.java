package com.example.actividad_02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CreadorDeBitmap extends AppCompatActivity {
    public Bitmap bff(int x, int y){
        Bitmap imgFrutas= BitmapFactory.decodeResource(getResources(),R.drawable.bitmapfrutas);

        //FALTA APRENDER COMO PONER LA POSICIÓN DE UN BITMAP
        //HAGAMOS UN BOTON Y DOS EDIT TEXT DE TIPO NUMBER PARA HACER PRUEBAS CON LAS POSICIONES

        //EN CASO DE NO APRENDER PREGUNTAR AL PROFE ENVIANDO UN CORREO CON EL CODIGO
        //Y DIRECTORIO MAIN
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

        return imgFrutas;
    }
}
