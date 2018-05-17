package com.example.reddy.desarrollo20;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    Button siguiente;
    private int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)findViewById(R.id.calendar);
        siguiente = (Button) findViewById(R.id.siguiente);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
<<<<<<< HEAD
                año = i;
=======
                año = i ;
>>>>>>> e6f63d2d43323fa6aa2e3cc1241cb1d6e530304d
                mes = i1+1;
                dia = i2;
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

<<<<<<< HEAD
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("año", String.valueOf(año));
                intent.putExtra("mes", String.valueOf(mes));
                intent.putExtra("dia", String.valueOf(dia));
                startActivity(intent);

=======
                action();
>>>>>>> e6f63d2d43323fa6aa2e3cc1241cb1d6e530304d
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void action(){

        int edadEnMeses;
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

        edadEnMeses = mesDesdeNac(año, mes, dia);
        if((edadEnMeses>0)&&(edadEnMeses <=84)) {
            intent.putExtra("edadMeses", String.valueOf(edadEnMeses));
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "El niño debe ser menor a 7 años u 84 meses", Toast.LENGTH_LONG).show();
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int mesDesdeNac(int año, int mes, int dia)
    {
        GregorianCalendar fechaNac = new GregorianCalendar(año, mes, dia);
        GregorianCalendar hoy = new GregorianCalendar();
        hoy.set(Calendar.MONTH, hoy.get(Calendar.MONTH)+1);
        int paño = hoy.get(Calendar.YEAR)-fechaNac.get(Calendar.YEAR);
        int pmes = hoy.get(Calendar.MONTH)-fechaNac.get(Calendar.MONTH);
        if(pmes < 0)
        {
            paño = paño -1;
            pmes = 12 + pmes;
        }
        if(fechaNac.get(Calendar.DAY_OF_MONTH) > hoy.get(Calendar.DAY_OF_MONTH))
        {
            pmes--;
        }

        String message = "Fecha Ingresada: " + año+"/"+mes+"/"+dia;
        String messageHoy = "Fecha de Hoy: " + hoy.get(Calendar.YEAR)+"/"+hoy.get(Calendar.MONTH)+"/"+hoy.get(Calendar.DAY_OF_MONTH);
        Log.d("myTag", message);
        Log.d("fecha Hoy",  messageHoy);
        return (pmes+(paño*12));
    }

}