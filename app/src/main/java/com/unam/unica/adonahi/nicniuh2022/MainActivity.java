package com.unam.unica.adonahi.nicniuh2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNombreUsuario, edtContrasenha;
    Button btnIngresar, btnRegistro;

    String nombre, contrasenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombreUsuario = findViewById(R.id.edt_nombre_usuario);
        edtContrasenha = findViewById(R.id.edt_contrasenha);
        btnIngresar = findViewById(R.id.btn_ingresar);
        btnRegistro = findViewById(R.id.btn_registro);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = edtNombreUsuario.getText().toString();
                contrasenha = edtContrasenha.getText().toString();

                if(nombre.length() == 0){
                    edtNombreUsuario.setError(getString(R.string.err_nombre_usuario));
                }
                else if(contrasenha.length() == 0){
                    edtContrasenha.setError(getString(R.string.err_contrasenha));
                }
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(registro);
            }
        });
    }
}