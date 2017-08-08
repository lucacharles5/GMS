package com.example.gerdaumanagement.gerdaumanagement;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import SQLITE.db_funcao;
import pojos.amc;


/**
 * A simple {@link Fragment} subclass.
 */
public class tecAmc extends Fragment {



    public tecAmc() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Alterar nome da actionbar
        ((MenuDrawer) getActivity()).setActionBarTitle("AMC");
        View rootView = inflater.inflate(R.layout.fragment_tec_amc, container, false);

        ListView showAmc = (ListView) rootView.findViewById(R.id.listaAmc);

        db_funcao bd = new db_funcao(getContext());

        List<amc> amcData = bd.buscarAmc();

        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(amcData, getActivity());

        showAmc.setAdapter(adapter);

        return rootView;

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tec_amc, container, false);


    }



    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<amc> amc;
        private final Activity act;


        public AdapterAmcPersonalizada(List<amc> amc, Activity act) {
            this.amc = amc;
            this.act = act;
        }


        @Override
        public int getCount() {
            return amc.size();
        }

        @Override
        public Object getItem(int position) {
            return amc.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_lista_apresentar_amc, parent, false);

            final amc showAmc = amc.get(position);

            //pegando as referências das Views
            TextView contNome = (TextView) view.findViewById(R.id.contNome);
            TextView contTipo = (TextView) view.findViewById(R.id.contTipo);
            TextView contContradada = (TextView) view.findViewById(R.id.contratada);
            TextView contData = (TextView) view.findViewById(R.id.contData);
            TextView contResultado = (TextView) view.findViewById(R.id.contResultado);
            TextView contIndicador = (TextView) view.findViewById(R.id.indicador);

            DecimalFormat decimal = new DecimalFormat( "0.00" );
            String resultadoFinal = decimal.format(showAmc.getResultado());

            //populando as Views
            contNome.setText(String.valueOf(showAmc.getNome()));
            contTipo.setText(String.valueOf(showAmc.getTipo()));
            contContradada.setText(String.valueOf(showAmc.getContratada()));
            contData.setText(String.valueOf(showAmc.getData()));
            contResultado.setText(resultadoFinal);

            View indicador = view.findViewById(R.id.linearLayout3);

            if(showAmc.getResultado()>= 90){

                contIndicador.setText("Ótimo");
                indicador.setBackgroundColor(getResources().getColor(R.color.verde));
            }else{
                if(showAmc.getResultado()>= 80 && showAmc.getResultado()<90 ){
                    contIndicador.setText("Bom");
                    indicador.setBackgroundColor(getResources().getColor(R.color.azul));

                }else{
                    if(showAmc.getResultado()>= 70 && showAmc.getResultado()<80 ){
                        contIndicador.setText("Regular");
                        indicador.setBackgroundColor(getResources().getColor(R.color.amarelo));
                    }else{
                        contIndicador.setText("Insatisfatório");
                        indicador.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    }
                }
            }





            return view;
        }


    }



}








