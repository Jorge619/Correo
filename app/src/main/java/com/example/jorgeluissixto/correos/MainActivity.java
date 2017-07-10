package com.example.jorgeluissixto.correos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    EditText correo_para,correo_de,asunto,direccion,telefono;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo_de=(EditText) findViewById(R.id.correo_de);
        correo_para=(EditText) findViewById(R.id.correo_para);
        asunto=(EditText) findViewById(R.id.asunto);
        direccion=(EditText) findViewById(R.id.direccion);
        telefono=(EditText) findViewById(R.id.telefono);
        boton=(Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandarmail();
            }
        });
    }
    private void mandarmail(){
        String direcciones=correo_para.getText().toString();
        StringTokenizer token=new StringTokenizer(direcciones);
        int n = token.countTokens();
        String [] para= new String[n];

        for (int i=0; i<n;i++) para[i] =token.nextToken();

        String tit=asunto.getText().toString();
        String text="Correo de la empresa: "+correo_de.getText().toString()+"\nDireccion: "+direccion.getText().toString()+"\nTelefono: "+telefono.getText().toString();

        Intent email= new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,para);
        email.putExtra(Intent.EXTRA_SUBJECT,tit);
        email.putExtra(Intent.EXTRA_TEXT,text);
        email.setType("plain/text");
        startActivity(Intent.createChooser(email,"send email"));



    }
}
