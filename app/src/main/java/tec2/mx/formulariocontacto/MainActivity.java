package tec2.mx.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button sig;
    EditText nombre,telefono,email,descripcion;
    DatePicker fecha;
    String nombreEditado,telefonoEditado,emailEditado,descripcionEditado,fechaEditado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sig = findViewById(R.id.btnSiguiente);
        nombre = findViewById(R.id.txtNombre1);
        telefono = findViewById(R.id.txtTelefono1);
        email = findViewById(R.id.txtEmail1);
        descripcion = findViewById(R.id.txtDescripcion1);
        fecha = findViewById(R.id.datePicker);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            nombreEditado = bundle.getString("nombre");
            telefonoEditado = bundle.getString("telefono");
            emailEditado = bundle.getString("email");
            descripcionEditado = bundle.getString("descripcion");
            fechaEditado = bundle.getString("fecha");

            nombre.setText(nombreEditado);
            telefono.setText(telefonoEditado);
            email.setText(emailEditado);
            descripcion.setText(descripcionEditado);

        }


        sig.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                        intent.putExtra("nombre",nombre.getText().toString());
                        intent.putExtra("telefono",telefono.getText().toString());
                        intent.putExtra("email",email.getText().toString());
                        intent.putExtra("descripcion",descripcion.getText().toString());
                        intent.putExtra("fecha", (fecha.getDayOfMonth()+"/"+fecha.getMonth()+"/"+fecha.getYear()));
                        startActivity(intent);
                    }
                });
    }
}
