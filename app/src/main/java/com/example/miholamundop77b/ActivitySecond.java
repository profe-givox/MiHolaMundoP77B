package com.example.miholamundop77b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond
        extends AppCompatActivity {
    EditText txtTo, txtSub, txtMen;
    Button btn;


    Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_segundo);

        txtTo = findViewById(R.id.txtPara);
        txtSub = findViewById(R.id.txtAsunto);
        txtMen = findViewById(R.id.txtMensaje);

        i = getIntent();

        String cadenamsj="" ;

        txtTo.setText(i.getStringExtra("para"));
        txtSub.setText(i.getStringExtra("asunto"));
        txtMen.setText(i.getStringExtra("mensaje"));

        cadenamsj += i.getStringExtra("para") + "\n";
        cadenamsj += i.getStringExtra("asunto") + "\n";
        cadenamsj += i.getStringExtra("mensaje") + "\n";

        Toast.makeText(this,
                cadenamsj, Toast.LENGTH_LONG).show();

        btn = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });


    }
}
