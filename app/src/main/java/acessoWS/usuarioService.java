package acessoWS;

import java.util.List;

import pojos.usuarios;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Lucas on 08/08/2017.
 */

public interface usuarioService {

    @GET("get/usuarios")
    Call<List<usuarios>> getUsuarios();

    @GET("get/usuarios/{id}")
    Call<usuarios> excluirUsuario(@Path("id") int id);


    @POST("inserir")
    Call<Boolean> inserirUsuario(@Body usuarios user);
}
