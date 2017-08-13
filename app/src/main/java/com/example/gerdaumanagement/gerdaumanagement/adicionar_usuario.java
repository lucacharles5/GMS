package com.example.gerdaumanagement.gerdaumanagement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import SQLITE.db_funcao;
import acessoWS.usuarioDAO;
import pojos.usuarios;

import static com.example.gerdaumanagement.gerdaumanagement.R.id.editarUser;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.email;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.login;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.nome;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.np;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.salvar;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.senha;

/**
 * A simple {@link Fragment} subclass.
 */
public class adicionar_usuario extends usuario {
    private usuarios usuario = new usuarios();

    private EditText nomeEt;
    private EditText emailEt;
    private EditText npEt;
    private EditText senhaEt;
    private EditText loginEt;
    // private EditText confirmarSenhaEt;
    private String cargo;
    private Button salvarBt;
    private Button editarUserBt;


    public adicionar_usuario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String TAG = "myApp";

        View rootView = inflater.inflate(R.layout.fragment_adicionar_usuario, container, false);


        Button botao = (Button) rootView.findViewById(salvar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarUsuario(v);
            }
        });


        //Alterar nome da actionbar
        ((MenuDrawer) getActivity()).setActionBarTitle("Adicionar Usuário");


        //TiPOS
        Spinner spinner = (Spinner) rootView.findViewById(R.id.tipoFunc);
        ArrayAdapter<CharSequence> adapterTiposFunc = ArrayAdapter.createFromResource(getActivity(), R.array.tipoFunc, android.R.layout.select_dialog_item);
        adapterTiposFunc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterTiposFunc);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                String tipoF = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado
                cargo = tipoF;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        // Inflate the layout for this fragment
        nomeEt = (EditText) rootView.findViewById(nome);
        emailEt = (EditText) rootView.findViewById(email);
        npEt = (EditText) rootView.findViewById(np);
        salvarBt = (Button) rootView.findViewById(salvar);
        senhaEt = (EditText) rootView.findViewById(senha);
        loginEt = (EditText) rootView.findViewById(login);
        editarUserBt = (Button) rootView.findViewById(editarUser);


        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (getArguments() != null) {
                ((MenuDrawer) getActivity()).setActionBarTitle("Editar Usuário");

                getArguments().getString("nome", "");
                getArguments().getString("email", "");
                getArguments().getString("senha", "");
                getArguments().getString("login", "");
                getArguments().getString("np", "");
                getArguments().getString("tipoFunc", "");
                getArguments().getInt("id", 0);

                int id = getArguments().getInt("id");
                String nome = getArguments().getString("nome");
                String email = getArguments().getString("email");
                String senha = getArguments().getString("senha");
                String np = getArguments().getString("np");
                String login = getArguments().getString("login");
                String cargo = getArguments().getString("tipoFunc");


                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setCargo(cargo);
                usuario.setNp(np);
                usuario.setLogin(login);
                nomeEt.setText(nome);
                emailEt.setText(email);
                npEt.setText(np);
                //tipoFuncSp.toString();
                senhaEt.setText(senha);
                loginEt.setText(login);

                //senhaEt.setVisibility(View.GONE);
                salvarBt.setVisibility(View.GONE);
                editarUserBt.setVisibility(View.VISIBLE);


            }
        }

        // confirmarSenhaEt = (EditText) rootView.findViewById(confirmarSenha);

        getActivity().getFragmentManager().popBackStack();


        Button botaoeditar = (Button) rootView.findViewById(editarUser);
        botaoeditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarUsuario(v);
            }
        });

        return rootView;

    }

    public void verificarUsuario(View view) {


        if (nomeEt.getText().length() == 0) {

            nomeEt.setError("Campo vazio");

        } else {
            if (emailEt.getText().length() == 0) {
                emailEt.setError("Campo vazio");
            } else {
                if (npEt.getText().length() == 0) {
                    npEt.setError("Campo vazio");
                } else {
                    if (loginEt.getText().length() == 0) {
                        loginEt.setError("Campo Vazio");
                    } else {
                        if (senhaEt.getText().length() == 0) {
                            senhaEt.setError("Campo Vazio");
                        } else {
                            salvarUsuario(view);
                        }


                    }

                }

            }

        }
    }


    public void salvarUsuario(View view) {

        usuario.setNome(nomeEt.getText().toString());
        usuario.setEmail(emailEt.getText().toString());
        usuario.setCargo(cargo.toString());
        usuario.setNp(npEt.getText().toString());
        usuario.setSenha(senhaEt.getText().toString());
        usuario.setLogin(loginEt.getText().toString());

        db_funcao bd = new db_funcao(getContext());
        bd.inserir(usuario);

        usuarioDAO dao = new usuarioDAO();
        dao.inserirUsuario(usuario);

        Toast.makeText(getActivity(), "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();

    }

    public void editarUsuario(View view) {

        usuario.setNome(nomeEt.getText().toString());
        usuario.setEmail(emailEt.getText().toString());
        usuario.setNp(npEt.getText().toString());
        usuario.setCargo(cargo.toString());
        usuario.setSenha(senhaEt.getText().toString());
        usuario.setLogin(loginEt.getText().toString());


        db_funcao bd = new db_funcao(getContext());
        bd.atualizar(usuario);


        Toast.makeText(getActivity(), "Usuário \"" + usuario.getNome() + "\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }


}
