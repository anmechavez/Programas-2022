package com.example.actividad_02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Fruta {
    public String nombreFruta;
    public String cantidad;
    public Bitmap imgFrutas;

    Fruta(String nombreFruta, int cantidad){
   //antes Fruta(String nombreFruta, int cantidad,Bitmap brecibido){
            this.nombreFruta = nombreFruta;
            String cantparseada = cantidad+"";
            this.cantidad = cantparseada;
    }

}
