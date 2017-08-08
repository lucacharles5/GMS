package acessoWS;

import android.util.Log;

import com.example.gerdaumanagement.gerdaumanagement.usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

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

    private static final String BASE_URL = "http://192.168.1.2:8080/gms/webresources/usuario/";
    private static final Gson g = new GsonBuilder().registerTypeAdapter(usuario.class,new dec()).create();


        public void inserirUsuario(usuarios usuario){
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


        public void excluirUsuario(int id){

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

        public void buscarTodosUsuarios(){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(g)).build();
            usuarioService service = retrofit.create(usuarioService.class);
            retrofit2.Call<List<usuarios>> usuarios = service.getUsuarios();

            usuarios.enqueue(new Callback<List<pojos.usuarios>>() {

                @Override
                public void onResponse(retrofit2.Call<List<usuarios>> call, Response<List<usuarios>> response) {
                    if(response.isSuccessful()){

                         List<usuarios> users = response.body();

                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).getNome().equals("admin")) {
                                users.remove(i);
                            }
                        }

                        for(usuarios u : users){
                            Log.i("USER",u.getNome());
                            Log.i("USER", "----------------------------------------------------------");
                        }



                    }else{
                        Log.i("USER", String.valueOf(response.code()));
                        Log.i("USER", "----------------------------------------------------------");

                    }
                }

                @Override
                public void onFailure(retrofit2.Call<List<usuarios>> call, Throwable t) {
                    Log.i("USER",t.getMessage());
                    Log.i("USER", "----------------------------------------------------------");

                }
            });


        }


        public usuarios buscarUsuarioPorID(int id){
            final usuarios user = null;



            return user;
        }

        public boolean atualizarUsuario(usuarios usuario){


            return true;
        }


    }


