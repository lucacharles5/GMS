package com.example.gerdaumanagement.gerdaumanagement;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import SQLITE.db_funcao;
import acessoWS.usuarioDAO;
import pojos.usuarios;


/**
 * A simple {@link Fragment} subclass.
 */
public class usuario extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usuario, container, false);
        //Alterar nome da actionbar
        ((MenuDrawer) getActivity()).setActionBarTitle("Usuário");

        ListView listaUsuario = (ListView) rootView.findViewById(R.id.listaUsuario);

        Button botao = (Button) rootView.findViewById(R.id.addUser);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarUsuario(v);
            }
        });

        db_funcao bd = new db_funcao(getContext());
        usuarioDAO dao = new usuarioDAO();

        List<usuarios> list = bd.buscar();

        Iterator<usuarios> it = list.iterator();

        while (it.hasNext()) {

            if (it.next().getNome().equals("admin")) {
                it.remove();
            }
        }

        UsuarioAdapter adapter = new UsuarioAdapter(list, getActivity());
        listaUsuario.setAdapter(adapter);


        //List<usuarios> list = bd.buscar();
        //ArrayAdapter<usuarioData> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);

        // Inflate the layout for this fragment
        return rootView;

    }

    public void adicionarUsuario(View view) {


        adicionar_usuario adduser = new adicionar_usuario();

        FragmentManager manager = getFragmentManager();

        manager.beginTransaction().replace(R.id.content, adduser, adduser.getTag()).addToBackStack(null).commit();

    }


    class UsuarioAdapter extends BaseAdapter {

        private final List<usuarios> listaUser;
        private final Activity act;

        public UsuarioAdapter(List<usuarios> teste, Activity act) {
            this.listaUser = teste;
            this.act = act;
        }

        @Override
        public int getCount() {
            return listaUser.size();
        }

        @Override
        public Object getItem(int position) {
            return listaUser.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final int auxPosition = position;

            final View view = act.getLayoutInflater().inflate(R.layout.activity_layout_usuario, parent, false);
            usuarios testeUser = listaUser.get(position);


            //pegando as referências das Views
            TextView nome = (TextView) view.findViewById(R.id.nome);
            TextView email = (TextView) view.findViewById(R.id.email);
            TextView np = (TextView) view.findViewById(R.id.np);
            TextView tipoFunc = (TextView) view.findViewById(R.id.cargo);
            TextView senha = (TextView) view.findViewById(R.id.senha);
            TextView login = (TextView) view.findViewById(R.id.login);


            //populando as Views
            nome.setText(String.valueOf(testeUser.getNome()));
            email.setText(String.valueOf(testeUser.getEmail()));
            np.setText(String.valueOf(testeUser.getNp()));
            tipoFunc.setText(String.valueOf(testeUser.getCargo()));
            senha.setText(String.valueOf(testeUser.getSenha()));
            login.setText(String.valueOf(testeUser.getLogin()));


            ImageView deletarBt = (ImageView) view.findViewById(R.id.deletar);
            deletarBt.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    db_funcao bd = new db_funcao(getContext());
                    bd.deletar(listaUser.get(auxPosition));

                    view.setVisibility(View.GONE);
                }
            });


            ImageView editarBt = (ImageView) view.findViewById(R.id.editar);
            editarBt.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bundle data = new Bundle();
                    data.putString("nome", listaUser.get(auxPosition).getNome());
                    data.putString("email", listaUser.get(auxPosition).getEmail());
                    data.putString("senha", listaUser.get(auxPosition).getSenha());
                    data.putString("np", listaUser.get(auxPosition).getNp());
                    data.putString("login", listaUser.get(auxPosition).getLogin());
                    data.putString("tipoFunc", listaUser.get(auxPosition).getCargo());
                    data.putInt("id", listaUser.get(auxPosition).getId());
                    Fragment fragment = new adicionar_usuario();
                    fragment.setArguments(data);

                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content, fragment, fragment.getTag()).addToBackStack(null).commit();

                    /*Intent intent = new Intent(getActivity(), adicionar_usuario.class);
                    manager.putFragment(bundle,"nome", listaUser.get(auxPosition).getNome());
                    intent.putExtra("email", listaUser.get(auxPosition).getEmail());
                    intent.putExtra("np", listaUser.get(auxPosition).getNp());
                    intent.putExtra("tipoFunc", listaUser.get(auxPosition).getTipoFunc());
                    intent.putExtra("id", listaUser.get(auxPosition).getId());
                    getContext().startActivity(intent);*/
                }
            });

            return view;
        }
    }


}








