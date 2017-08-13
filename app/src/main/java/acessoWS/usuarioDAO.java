package acessoWS;

import android.util.Log;

import com.example.gerdaumanagement.gerdaumanagement.usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import pojos.amc;
import pojos.usuarios;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Lucas on 02/08/2017.
 */

public class usuarioDAO {

    private static final String BASE_URL = "http://192.168.1.8:8080/gms/webresources/usuario/";
    private static final Gson g = new GsonBuilder().registerTypeAdapter(usuario.class, new dec()).create();


    public void inserirUsuario(usuarios usuario) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
        usuarioService service = retrofit.create(usuarioService.class);
        retrofit2.Call<Boolean> user = service.inserirUsuario(usuario);
        user.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }

        });
    }


    public void excluirUsuario(int id) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
        usuarioService service = retrofit.create(usuarioService.class);
        retrofit2.Call<usuarios> user = service.excluirUsuario(id);
        user.enqueue(new Callback<usuarios>() {
            @Override
            public void onResponse(Call<usuarios> call, Response<usuarios> response) {

            }

            @Override
            public void onFailure(Call<usuarios> call, Throwable t) {

            }
        });

    }

    public void buscarTodosUsuarios() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
        usuarioService service = retrofit.create(usuarioService.class);
        retrofit2.Call<List<usuarios>> usuarios = service.getUsuarios();

        usuarios.enqueue(new Callback<List<pojos.usuarios>>() {

            @Override
            public void onResponse(retrofit2.Call<List<usuarios>> call, Response<List<usuarios>> response) {
                if (response.isSuccessful()) {

                    List<usuarios> users = response.body();

                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getNome().equals("admin")) {
                            users.remove(i);
                        }
                    }

                    for (usuarios u : users) {
                        Log.i("USER", u.getNome());
                        Log.i("USER", "----------------------------------------------------------");
                    }


                } else {
                    Log.i("USER", String.valueOf(response.code()));
                    Log.i("USER", "----------------------------------------------------------");

                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<usuarios>> call, Throwable t) {
                Log.i("USER", t.getMessage());
                Log.i("USER", "----------------------------------------------------------");

            }
        });


    }


    public void atualizarUsuario(usuarios usuario) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
        usuarioService service = retrofit.create(usuarioService.class);
        retrofit2.Call<Boolean> user = service.atualizarUsuario(usuario);
        user.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {


            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }

        });


    }

    public void inserirAmc(amc amc) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
        usuarioService service = retrofit.create(usuarioService.class);
        retrofit2.Call<Boolean> user = service.inserirAmc(amc);
        user.enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                System.out.println("-----------------------RESPOSTA AQUIII---------------"+ response);
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });


    }


  /*  public void verificarUsuarioECargo (String Login){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
        usuarioService service = retrofit.create(usuarioService.class);
        retrofit2.Call<List<String>> dados = service.verificarCargoENome(login);
        dados.enqueue(new Callback<List<String>>() {

            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> dados = response.body();
                String nome, cargo;

                nome = dados.get(0);
                cargo = dados.get(1);

                Intent intent = new Intent(MainActivity.class, MenuDrawer.class);

                intent.putExtra("chave1", nome);
                intent.putExtra("chave2", cargo);


                startActivity(intent);

                finish();


            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

    }*/

}



