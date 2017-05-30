package com.example.david.namantert;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView cajaCedula,contraseña;
    private Resources res;
    private Intent i;
    private Intent in;
    private Bundle b;
    private Bundle b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        i = new Intent(this,PrincipalAdmin.class);
        in = new Intent(this,PrincipalEmpleado.class);
        b = new Bundle();
        b1 = new Bundle();




        res=this.getResources();
        cajaCedula=(EditText)findViewById(R.id.txtUsuario);
        contraseña=(EditText)findViewById(R.id.txtContraseñalogin);




    }

    public boolean validar() {
        if (cajaCedula.getText().toString().isEmpty()) {
            cajaCedula.setError(res.getString(R.string.error_cajanombre));
            cajaCedula.requestFocus();
            return false;
        }
        if (contraseña.getText().toString().isEmpty()) {
            contraseña.setError(res.getString(R.string.error_cajacontraseña));
            contraseña.requestFocus();
            return false;
        }
        return true;
    }
    public void login(View v) {
        Empleado e, e1;
        String user = "admin";
        String contra = "admin123";
        if (validar()) {
            if (cajaCedula.getText().toString().equals(user) &&contraseña.getText().toString().equals(contra)) {
                i.putExtras(b);
                startActivity(i);
                Toast.makeText(getApplicationContext(), res.getString(R.string.registroexitoso),
                        Toast.LENGTH_SHORT).show();
                finish();
            }else{
                e = DatosEmpleados.buscarEmpleados(getApplicationContext(), cajaCedula.getText().toString());
                e1 = DatosEmpleados.buscarEmpleadosLogin(getApplicationContext(), contraseña.getText().toString());
                if (e != null && e1 != null) {
                    in.putExtras(b1);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(), res.getString(R.string.registroexitoso),
                            Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), res.getString(R.string.registronoexitoso),
                            Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

}
