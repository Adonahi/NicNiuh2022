package com.unam.unica.adonahi.nicniuh2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        edtCorreo = findViewById(R.id.edtCorreo);
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
                    edtCorreo.setError(getString(R.string.err_correo));
                }
                else if(!correoP.matcher(correo).matches()){
                    edtCorreo.setError(getString(R.string.err_correo_no_valido));
                }
                else if(telefono.length() == 0){
                    edtTelefono.setError(getString(R.string.err_telefono));
                }
                else if(contrasenha.length() == 0){
                    edtContrasenha.setError(getString(R.string.err_contrasenha));
                }
                else if(confirmarContrasenha.length() == 0){
                    edtConfirmarContrasenha.setError(getString(R.string.err_contrasenha));
                }
                else if(!contrasenha.equals(confirmarContrasenha)){
                    edtContrasenha.setError(getString(R.string.err_confirmar_contrasenha));
                    edtConfirmarContrasenha.setError(getString(R.string.err_confirmar_contrasenha));
                }
                else{
                    Intent inicio = new Intent(RegistroActivity.this, InicioActivity.class);
                    startActivity(inicio);
                }
            }
        });

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}