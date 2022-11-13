package com.example.actividad_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsersAdapter extends ArrayAdapter<User> {
    // El constructor solo recibe dos parámetro, pero le pasa al padre 3
    // El layout que se le pasa es el 0 debido a que se le pasa uno propio más abajo

    // Esta palabra super se utiliza en el lenguaje Java para invocar al método constructor de una
    // clase superior (clase padre) de la cual queremos utilizar el mismo
    // tipo de parametrización, entonces esta palabrita sube de categoría y pasa a ser el método super().

    //Aqui entendemos que pasamos por parametro el contexto de la app
    //Osea donde se va a ejecutar y una variable de tipo array users

    //1 El adaptador recibe el contexto y el array
    public UsersAdapter(Context context, ArrayList<User> users) { //al realizar el inflate
        super(context, 0, users);
    }
    private static class ViewHolder {
        TextView name;
        TextView home;
    }
    // El método getView se llamará tantas veces como registros tengan los datos a visualizar.
    // Si el array usado posee 10 valores el getView se llamará 10 veces
    @Override

    //2 el metodo getView retorna un view
    public View getView(int position, View convertView, ViewGroup parent) {
        // En la variable position tenemos la posición del array que estoy pintando.
        // El getItem es un método propio del ArrayAdapter, en este caso el tipo de adaptador usado es el de la clase "User"
        // por lo tanto el getItem nos devolverá un objeto de tipo "User" que está en la posición "position"
        // En los usos básicos de adaptadores en los spinner se usa un ArrayAdapter<string>
        // //, por lo tanto el getItem nos devolvería un String

        //Nos devuelve un String con la posición del array de users, lo guarda en una
        //variable tipo User

        //3 Coge la posición del array al que estamos haciendo referencia
        User user = getItem(position);
        // Validamos si nos pasan por parámetro la vista a visualizar
        // en caso que esté vacía usaremos la vista (el layout) que hemos creado para visualizar los elementes
        // el inflater se encarga de pintarlo.

        // View. Es una estructura de datos cuyas propiedades contienen los datos de la capa,
        // la información específica del área rectangular de la pantalla y permite establecer el layout.

        //4 En caso de no pasarle una vista coge la vista del xml item_user
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Creamos las variables que apuntan a los TextView definidos en el layout "item_user.xml"

        //5 Crea los textView que se veran en el xml y los enlaza.
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Informamos los valores de los TextView

        //6 Hace un set
        tvName.setText(user.name);
        tvHome.setText(user.hometown);
        //Podemos añadir eventos dentro de los elementos
        // En este caso he añadido un botón y creo el listener para que mustre un mensage con TOAST

        //Lo mismo con el botón //OSEA DEBES HACERLO CON TODAS
        //LAS VISTAS DEL XML item_frutas

        Button button_jmh = (Button)  convertView.findViewById(R.id.buttonjmh);
        // Defino una varieble para poder saber el contexto

        //7 Guarda toda la info en una variable view
        View finalConvertView_jmh = convertView;
        button_jmh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast notificacion=Toast.makeText(finalConvertView_jmh.getContext(),"hola",Toast.LENGTH_LONG);
                notificacion.show();

            }
        });
        // Devolvemos la vista para que se pinte (render) por la pantalla

        //8 Devuelve una variable view con un return
        return convertView;
    }
}
