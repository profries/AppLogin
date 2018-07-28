package com.example.iossenac.applogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iossenac.applogin.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciaListaUsuarios();
        setContentView(R.layout.activity_login);
    }

    private void iniciaListaUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("usuario1","senha1"));
        listaUsuarios.add(new Usuario("usuario2","senha2"));
        listaUsuarios.add(new Usuario("usuario3","senha3"));
    }

    public void realizaLogin(View view){
        EditText editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);

        String nome = editTextUsuario.getText().toString();
        String senha = editTextSenha.getText().toString();

        if(listaUsuarios.contains(new Usuario(nome,senha))){
            //msg de sucesso
            Toast.makeText(this, this.getString(R.string.msg_ok),Toast.LENGTH_SHORT)
                    .show();
        }
        else {
            //msg de insucesso
            Toast.makeText(this, this.getString(R.string.msg_error), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
