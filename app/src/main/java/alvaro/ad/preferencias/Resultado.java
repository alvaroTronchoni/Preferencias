package alvaro.ad.preferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    public static final String PREFS = "Mis preferencias";

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        this.resultado = (TextView) findViewById(R.id.respuesta);

        recuperarPreferencias();
    }

    private void recuperarPreferencias(){
        // Recuperamos el objeto de preferencias compartidas
        SharedPreferences misPreferencias = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

        // Recuperamos los valores guardados
        boolean isTrue = misPreferencias.getBoolean("isTrue", false);
        StringBuilder resultado = new StringBuilder();
        if(isTrue){
            resultado.append("Nombre: " + misPreferencias.getString("nombre",""));
            resultado.append("\n");
            resultado.append("DNI: " + misPreferencias.getString("dni",""));
            resultado.append("\n");
            resultado.append("Fechas de nacimiento: " + misPreferencias.getString("fecha",""));
            resultado.append("\n");
            resultado.append("Sexo: " + misPreferencias.getString("sexo",""));
            resultado.append("\n");
        }else{
            resultado.append("La preferencia buscada no existe");
        }
        this.resultado.setText(resultado);
    }
}
