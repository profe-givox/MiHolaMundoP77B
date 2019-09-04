package com.example.miholamundop77b;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.miLbl);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 txt.setText("Se presiono el boton");
                Toast.makeText(getApplicationContext(),
                        "Se presiono el boton",
                        Toast.LENGTH_LONG
                        ).show();


                Intent intent = new Intent(MainActivity.this ,
                        ActivitySecond.class);

                intent.putExtra("para", "4451234564");
                intent.putExtra("asunto", "Cita Importante");
                intent.putExtra("mensaje", "Acuda a recibir resultados " +
                        "lo mas pronto posible");

                //startActivity(intent);
                startActivityForResult(intent, 1000);

            }
        });

        txt.setText("Texto desde ejecucion");

        Log.i("BITACORA", "Paso por el metodo onCreate()");

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,
                        "Mensaje enviado exitoso",
                        Toast.LENGTH_LONG).show();
            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this,
                        "Mensaje NO enviado. \n"+
                                "Error: "
                                +data.getStringExtra("error"),
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("BITACORA", "Paso por el metodo onSatrt()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BITACORA", "Paso por el metodo onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BITACORA", "Paso por el metodo onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("BITACORA", "Paso por el metodo onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("BITACORA",
                "Paso por el metodo onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("BITACORA", "Paso por el metodo onRestart()");
    }
}
