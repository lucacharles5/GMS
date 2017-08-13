package com.example.gerdaumanagement.gerdaumanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import SQLITE.db_funcao;
import acessoWS.usuarioDAO;
import acessoWS.usuarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        final db_funcao bd = new db_funcao(this);
        usuarioDAO dao = new usuarioDAO();


        final EditText login = (EditText) findViewById(R.id.usuario);
        EditText senha = (EditText) findViewById(R.id.senha);


        //VERIFICA SE OS EDITTEXT SÃO VAZIOS
        if (login.getText().length() == 0) {

            login.setError("Campo vazio");

        } else {
            if (senha.getText().length() == 0) {
                senha.setError("Campo vazio");
            } else {
                if (senha.getText().length() < 6) {
                    senha.setError("Senha incorreta");
                } else {

                    Retrofit retrofit = new Retrofit.Builder().baseUrl(usuarioService.BASE_URL).addConverterFactory(GsonConverterFactory.create(usuarioService.g)).build();
                    usuarioService service = retrofit.create(usuarioService.class);
                    Call<String> user = service.verificarUsuario(login.getText().toString(), senha.getText().toString());
                    user.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String resultado = response.body();

                            if (resultado.equals("false")) {
                                Toast toast = Toast.makeText(MainActivity.this, "Senha ou usuário não existente", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP | Gravity.CENTER_VERTICAL, 0, 0);
                                toast.show();
                            } else {
                                if (resultado.equals("true")) {
                                    Toast toast = Toast.makeText(MainActivity.this, "ACESSO PERMITIDO", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                                    toast.show();

                                    Intent intent = new Intent(MainActivity.this, MenuDrawer.class);

                                   intent.putExtra("chave1", login.getText().toString());

                                    startActivity(intent);

                                    finish();



                            }
                        }


                    }
                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }

                });
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







