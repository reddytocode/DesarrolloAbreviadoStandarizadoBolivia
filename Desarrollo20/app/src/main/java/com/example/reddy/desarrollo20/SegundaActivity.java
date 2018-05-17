package com.example.reddy.desarrollo20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SegundaActivity extends AppCompatActivity {

    private TextView edad;
    private Button about, materiales, test;
    private int edadMeses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        edad = (TextView) findViewById(R.id.edad);
        materiales = (Button) findViewById(R.id.materiales);
        test = (Button)findViewById(R.id.test);
        about = (Button)findViewById(R.id.about);


        Bundle bundle = getIntent().getExtras();


        this.edadMeses = Integer.parseInt(bundle.getString("edadMeses", ""));
        edad.setText(bundle.getString("edadMeses", ""));


        materiales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paso_Materiales();
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paso_Test();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paso_About();
            }
        });
    }

    public void paso_Materiales()
    {
        Intent intent = new Intent(SegundaActivity.this, MaterialesActivity.class);
        intent.putExtra("meses", edadMeses);
        startActivity(intent);
    }

    public void paso_Test()
    {
        Intent intent = new Intent(SegundaActivity.this, TestActivity.class);
        intent.putExtra("meses", edadMeses);
        startActivity(intent);
    }
    public void paso_About()
    {
        Intent intent = new Intent(SegundaActivity.this, AboutActivity.class);
        startActivity(intent);
    }


}