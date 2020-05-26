package tec2.mx.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EditActivity extends AppCompatActivity {

    MainActivity main = new MainActivity();
    Button edit;
    TextView nombrePer,telePer,emailPer,descPer,fechaPer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final String nombre,telefono,email,descripcion,fecha;
        edit = findViewById(R.id.btnEditar);
        nombrePer = findViewById(R.id.txtNombreCreado);
        telePer = findViewById(R.id.txtTelefonoCreado);
        emailPer = findViewById(R.id.txtEmailCreado);
        descPer = findViewById(R.id.txtDescripcionCreado);
        fechaPer = findViewById(R.id.txtFechaNacimiento);

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("nombre");
        telefono = bundle.getString("telefono");
        email = bundle.getString("email");
        descripcion = bundle.getString("descripcion");
        fecha = bundle.getString("fecha");

        nombrePer.setText("Nombre: "+nombre);
        telePer.setText("Teléfono: "+telefono);
        emailPer.setText("Email: "+email);
        descPer.setText("Descripción: "+descripcion);
        fechaPer.setText("Fecha: "+fecha);

        edit.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("nombre",nombre);
                        intent.putExtra("telefono",telefono);
                        intent.putExtra("email",email);
                        intent.putExtra("descripcion",descripcion);
                        intent.putExtra("fecha",fecha);

                        startActivity(intent);
                        finish();
                    }
                });
    }
}
