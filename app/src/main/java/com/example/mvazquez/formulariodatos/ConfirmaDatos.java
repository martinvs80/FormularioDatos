package com.example.mvazquez.formulariodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaDatos extends AppCompatActivity {
    TextView tvNombreC;
    TextView tvFechaC;
    TextView tvTelefonoC;
    TextView tvEmailC;
    TextView tvDescripcionConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button   btnEditar;
        setContentView(R.layout.activity_confirma_datos);
        //asigno mis views
        tvNombreC = (TextView) findViewById(R.id.tvNombreC);
        tvFechaC = (TextView) findViewById(R.id.tvFechaC);
        tvTelefonoC = (TextView) findViewById(R.id.tvTelefonoC);
        tvEmailC = (TextView) findViewById(R.id.tvEmailC);
        tvDescripcionConf = (TextView) findViewById(R.id.tvDescripcionConf);
        //Reviso los extras que vienen de la pantalla aterior y los asigno
        Bundle recibeExtras = getIntent().getExtras();
        tvNombreC.setText(recibeExtras.getString(getResources().getString(R.string.parametroNombre)));
        tvFechaC.setText(recibeExtras.getString(getResources().getString(R.string.parametroFecha)));
        tvTelefonoC.setText(recibeExtras.getString(getResources().getString(R.string.parametroTelefono)));
        tvEmailC.setText(recibeExtras.getString(getResources().getString(R.string.parametroEmail)));
        tvDescripcionConf.setText(recibeExtras.getString(getResources().getString(R.string.parametroDescripcion)));
        btnEditar = (Button) findViewById(R.id.btnEditar);
        //Genero rutina para regresar los valores a la vista anterior
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEdita = new Intent(ConfirmaDatos.this,MainActivity.class);
                iEdita.putExtra(getResources().getString(R.string.parametroNombre),tvNombreC.getText().toString());
                iEdita.putExtra(getResources().getString(R.string.parametroFecha),tvFechaC.getText().toString());
                iEdita.putExtra(getResources().getString(R.string.parametroTelefono),tvTelefonoC.getText().toString());
                iEdita.putExtra(getResources().getString(R.string.parametroEmail),tvEmailC.getText().toString());
                iEdita.putExtra(getResources().getString(R.string.parametroDescripcion),tvDescripcionConf.getText().toString());
                startActivity(iEdita);
                finish();
            }
        });

    }
}
