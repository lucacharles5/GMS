package pojos;

import java.io.Serializable;

/**
 * Created by Lucas on 04/08/2017.
 */

public class usuarios implements Serializable {

    private int id;
    private String nome;
    private String email;
    private String np;
    private String cargo;
    private String senha;
    private String login;

     /* public usuarioData(){
           this.nome = nome;
           this.email=email;
           this.np=np;
           this.tipoFunc = tipoFunc;
           this.senha = senha;
           this.id = id;
       }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNp() {
        return np;
    }

    public void setNp(String np) {
        this.np = np;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String tipoFunc) {
        this.cargo = tipoFunc;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Email: " + email + "NP: " + np + "TipoFUnc: " + cargo + "Senha: senha" + senha + "Login:" + login;
    }
}
