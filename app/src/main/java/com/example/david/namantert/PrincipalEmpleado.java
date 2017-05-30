package com.example.david.namantert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PrincipalEmpleado extends AppCompatActivity {
    private ListView ls;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_empleado);

        ls=(ListView)findViewById(R.id.listaOpcionesEmp);
        opc=getResources().getStringArray(R.array.opciones_principalemp);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){

                    case 0:
                        in=new Intent(PrincipalEmpleado.this, Listas.class);
                        startActivity(in);
                        break;

                    case 1:
                        in=new Intent(PrincipalEmpleado.this,Compras_Registro_Clientes.class);
                        startActivity(in);
                        break;
                    case 2:
                        in=new Intent(PrincipalEmpleado.this,Login.class);
                        startActivity(in);
                        finish();
                        break;
                }
            }
        });

}


    @Override
    public void onBackPressed() {
        Log.d("PrincipalEmpleado", "onBackPressed()");
        getClass();
    }
}

