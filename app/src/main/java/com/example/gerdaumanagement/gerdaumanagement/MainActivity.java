package com.example.gerdaumanagement.gerdaumanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*List<usuario.usuarioData> list = bd.buscar();
        for(int i = 0; i < list.size(); i++){
            System.out.println("AQUI" + list.get(i));
        }*/

    }

    public void entrarSistema(View view) {
        db_funcao bd = new db_funcao(this);
        EditText login = (EditText) findViewById(R.id.usuario);
        EditText senha = (EditText) findViewById(R.id.senha);


        //VERIFICA SE OS EDITTEXT SÃO VAZIOS
        if (login.getText().length() == 0) {

            login.setError("Campo vazio");

        } else {
            if (senha.getText().length() == 0) {
                senha.setError("Campo vazio");
            } else {
                if (senha.getText().length() < 6 ) {
                    senha.setError("Senha incorreta");
                } else {

                    if (bd.login(login.getText().toString(),senha.getText().toString()) != 1 ){



                        Toast toast = Toast.makeText(MainActivity.this, "Senha ou usuário não existente", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();

                    }
                    else{


                        //TOAST LOGIN
                        Toast toast = Toast.makeText(MainActivity.this, "ACESSO PERMITIDO", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();

                       /* MenuDrawer menuDrawer = new MenuDrawer();
                        menuDrawer.AlterarPerfil(bd.verificarUsuario(login.getText().toString()),bd.verificarCargo(login.getText().toString()));*/
                        String nome =  bd.verificarUsuario(login.getText().toString());
                        String cargo = bd.verificarCargo(login.getText().toString());


                        Intent intent = new Intent(this, MenuDrawer.class);

                        intent.putExtra("chave1", nome);
                        intent.putExtra("chave2", cargo);


                        startActivity(intent);

                        finish();

                    }




                }

            }

        }
    }

    //CHAMA UMA ACTIVITY (TELA)
    void recuperarSenha(View view) {
        Intent intent = new Intent(this, recuperarSenha.class);
        startActivity(intent);
    }

}







