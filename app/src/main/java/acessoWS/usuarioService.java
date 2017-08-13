package acessoWS;

import com.example.gerdaumanagement.gerdaumanagement.usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import pojos.amc;
import pojos.usuarios;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Lucas on 08/08/2017.
 */

public interface usuarioService {

     String BASE_URL = "http://192.168.1.8:8080/gms/webresources/usuario/";
     Gson g = new GsonBuilder().registerTypeAdapter(usuario.class, new dec()).create();

    @GET("get/usuarios")
    Call<List<usuarios>> getUsuarios();

    @GET("get/usuarios/{id}")
    Call<usuarios> excluirUsuario(@Path("id") int id);

    @POST("atualizar")
    Call<Boolean> atualizarUsuario(@Body usuarios user);

    @POST("inserir")
    Call<Boolean> inserirUsuario(@Body usuarios user);

    @POST("inserirAmc")
    Call<Boolean> inserirAmc(@Body amc amc);

    @GET("verificarUsuario")
    Call<String> verificarUsuario(@Query("login") String login, @Query("senha") String senha);

    @GET("verificarLogin")
    Call<String> verificarLogin(@Query("login") String login);

    @GET("verificarCargoENome/{login}")
    Call<List<String>> verificarCargoENome(@Path("login") String login);


}

