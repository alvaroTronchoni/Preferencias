package alvaro.ad.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class preferencias extends AppCompatActivity {

    public static final String PREFS = "Mis preferencias";

    EditText nombre;
    EditText dni;
    EditText fecha;
    RadioButton hombre;
    RadioButton mujer;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        this.nombre = (EditText) findViewById(R.id.nombre);
        this.dni = (EditText) findViewById(R.id.dni);
        this.fecha = (EditText) findViewById(R.id.fecha);
        this.hombre = (RadioButton) findViewById(R.id.radioHombre);
        this.mujer = (RadioButton) findViewById(R.id.radioMujer);

        this.guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crearPreferencia();
                segundoActi();
            }
        });

    }

    private void segundoActi(){
        Intent i = new Intent(this,Resultado.class);
        startActivity(i);
    }

    private void crearPreferencia(){
        // Creamos o recuperamos el objeto de preferencias compartidas
        SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

        // Obtenemos un editor para modificar las preferencias
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        // Guardamos nuevos valores
        editor.putBoolean("isTrue", true);
        editor.putString("nombre",nombre.getText().toString());
        editor.putString("dni",dni.getText().toString());
        editor.putString("fecha",fecha.getText().toString());
        if(hombre.isChecked()){
            editor.putString("sexo","Hombre");
        }
        if(mujer.isChecked()){
            editor.putString("sexo","Mujer");
        }

        // Guardamos los cambios
        editor.commit();
    }
}
