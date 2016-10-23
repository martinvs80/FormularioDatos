package com.example.mvazquez.formulariodatos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextInputEditText tietNombre;
    TextInputEditText tietFecha;
    TextInputEditText tietTelefono;
    TextInputEditText tietEmail;
    TextInputEditText tietDescripcionC;
    DatePickerDialog dpFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asigno mis views
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        tietNombre = (TextInputEditText) findViewById(R.id.tietNombre);
        tietFecha = (TextInputEditText) findViewById(R.id.tietFecha);
        tietTelefono = (TextInputEditText) findViewById(R.id.tietTelefono);
        tietEmail = (TextInputEditText) findViewById(R.id.tietEmail);
        tietDescripcionC = (TextInputEditText) findViewById(R.id.tietDescripcionC);
        //Recibo y asigno los extras en caso de venir de la actividad de confirmar datos
        Bundle recibeEditar = getIntent().getExtras();
        tietNombre.setText(recibeEditar.getString(getResources().getString(R.string.parametroNombre)));
        tietFecha.setText(recibeEditar.getString(getResources().getString(R.string.parametroFecha)));
        tietTelefono.setText(recibeEditar.getString(getResources().getString(R.string.parametroTelefono)));
        tietEmail.setText(recibeEditar.getString(getResources().getString(R.string.parametroEmail)));
        tietDescripcionC.setText(recibeEditar.getString(getResources().getString(R.string.parametroDescripcion)));
        //Asigno a mi boton la rutina para crear los extras y llamar la nueva actividad
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLlama = new Intent(MainActivity.this, ConfirmaDatos.class);
                iLlama.putExtra(getResources().getString(R.string.parametroNombre),tietNombre.getText().toString());
                iLlama.putExtra(getResources().getString(R.string.parametroFecha),tietFecha.getText().toString());
                iLlama.putExtra(getResources().getString(R.string.parametroTelefono),tietTelefono.getText().toString());
                iLlama.putExtra(getResources().getString(R.string.parametroEmail),tietEmail.getText().toString());
                iLlama.putExtra(getResources().getString(R.string.parametroDescripcion),tietDescripcionC.getText().toString());
                startActivity(iLlama);
                finish();
            }
        });
        //inicio el date picker y el boton

        tietFecha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                dpFecha = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tietFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },mYear,mMonth,mDay);
                dpFecha.show();
            }
        });


    }

}
