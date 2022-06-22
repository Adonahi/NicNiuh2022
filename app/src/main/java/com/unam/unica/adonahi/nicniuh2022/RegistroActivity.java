package com.unam.unica.adonahi.nicniuh2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    EditText edtNombreUsuario, edtCorreo, edtTelefono, edtContrasenha, edtConfirmarContrasenha;
    Button btnRegistrar, btnIngreso;
    String nombre, correo, telefono, contrasenha, confirmarContrasenha;
    Pattern correoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        correoP = Patterns.EMAIL_ADDRESS;

        edtNombreUsuario = findViewById(R.id.edt_nombre_usuario_registro);
        edtCorreo = findViewById(R.id.edt_correo);
        edtTelefono = findViewById(R.id.edt_telefono);
        edtContrasenha = findViewById(R.id.edt_contrasenha_registro);
        edtConfirmarContrasenha = findViewById(R.id.edt_confirmar_contrasenha);
        btnRegistrar = findViewById(R.id.btn_registrar);
        btnIngreso = findViewById(R.id.btn_ingreso);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = edtNombreUsuario.getText().toString();
                correo = edtCorreo.getText().toString();
                telefono = edtTelefono.getText().toString();
                contrasenha = edtContrasenha.getText().toString();
                confirmarContrasenha = edtConfirmarContrasenha.getText().toString();

                if(nombre.length() == 0){
                    edtNombreUsuario.setError(getString(R.string.err_nombre_usuario));
                }
                else if(correo.length() == 0){
                    edtCorreo.setError("Falta Correo");
                }
                else if(!correoP.matcher(correo).matches()){
                    edtCorreo.setError("No es un correo");
                }
            }
        });

    }
}