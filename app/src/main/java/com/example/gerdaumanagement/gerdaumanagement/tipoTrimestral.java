package com.example.gerdaumanagement.gerdaumanagement;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.gerdaumanagement.gerdaumanagement.R.id.na;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.nao;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.sim;


/**
 * A simple {@link Fragment} subclass.
 */
public class tipoTrimestral extends Fragment {

    public tipoTrimestral() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tipo_trimestral, container, false);
        ListView listaTrimestral = (ListView) rootView.findViewById(R.id.listaTrimestre);

        Button btnFooter = new Button(getActivity());
        btnFooter.setText("ENVIAR");
        btnFooter.setBackgroundResource(R.drawable.gradiente_azul_semconor);
        btnFooter.setTextColor(getResources().getColor(R.color.cinza));

        btnFooter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
        /*[...]*/
            }
        });


        List<AvaliacaoTrimestral> trimestral = todosTrimestral();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(trimestral, getActivity());

        listaTrimestral.addFooterView(btnFooter);
        listaTrimestral.setAdapter(adapter);

        return rootView;
    }

    public List<AvaliacaoTrimestral> todosTrimestral() {
        List<AvaliacaoTrimestral> dadosTrimestral = new ArrayList<AvaliacaoTrimestral>();
        dadosTrimestral.add(new AvaliacaoTrimestral("Existe uma lista de todos produtos químicos utilizados?", 'A', "Produto Químico"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Existe inflamavel? Se sim, possuem extintor de incendio no local?", 'A', "Produto Químico"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Proibido uso de fogão a lenha, deve ser a gas e o botijão ficando na parte externa (fora) ter boa ventilação.", 'A', "Cozinha / Refeitorio "));
        dadosTrimestral.add(new AvaliacaoTrimestral("Ter local próprio para guardar os mantimentos e utensílios (prateleiras e ou armários), não pode guardar alimentos no chão.", 'B', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Refrigerador para a guarda de alimentos perecíveis, quando tiver diponibilidade de energia elétrica no local.", 'C', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Não deverá ter louças sujas e panelas pretas e encardidas e mal acondicionadas (espalhadas).", 'C', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Deve ter mesa e bancos em número suficiente para que todos  possam, ao mesmo tempo, fazer as refeições sentados.", 'B', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Deve ter cardápios elaborados por nutricionistas (cozinheiras), fixados nas cozinhas.", 'C', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new AvaliacaoTrimestral("É proibido guardar ferramentas/combustíveis/produtos químicos neste local.", 'A', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Devem estar sempre limpos e ter um vaso sanitário para cada 20 colaboradores", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Deve ter 01 chuveiro para cada 10 colaboradores", 'A', "Sanitários / Vestiários    "));
        dadosTrimestral.add(new AvaliacaoTrimestral("Devem ter acento com tampa.", 'B', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Estão instalados em compartimentos individuais separados masculino e feminino?", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Instalação hidráulicas, elétricas, equipamentos, pias perfeitas e conservadas.", 'B', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Deve ter sabão, papel toalha e  Papel Higiênico disponível", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Porta para preservar o resguardo conveniente.", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("É proibido guardar ferramentas/combustíveis e produtos químicos neste local.", 'B', "Sanitários / Vestiários"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Devem estar sempre limpos e arrumados", 'B', "Dormitórios"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Devem ter uma cama para cada alojado, tamanho mínimo 1,90m x 0,70 m = 1,33 m², com colchão de espessura mínima 14cm, densidade mínima = 28, e roupa de cama limpa.", 'A', "Dormitórios"));
        dadosTrimestral.add(new AvaliacaoTrimestral("A altura livre entre uma cama e outra, e entre a última e o teto deve ser de no mínimo 1,10m (no caso de beliche).", 'B', "Dormitórios"));
        dadosTrimestral.add(new AvaliacaoTrimestral("Armário ou baú (caixa) com chave para cada alojado guardar seus pertences individualmente (tamanho mínimo de  0,60 m frente x 0,45 m de fundos e x 0,90 m de altura) ", 'A', "Dormitórios"));

        // Continuação do código
        return dadosTrimestral;
    }

    class AvaliacaoTrimestral {
        private String questao;
        private char potencial;
        private String titulo;
        boolean[] radioButtonValues = new boolean[3];

        public AvaliacaoTrimestral(String questao, char potencial, String titulo) {
            this.questao = questao;
            this.potencial = potencial;
            this.titulo = titulo;

        }

        public String getQuestao() {

            return questao;
        }

        public void setQuestao(String questao) {

            this.questao = questao;
        }

        public char getPotencial() {

            return potencial;
        }

        public void setPotencial(char potencial) {

            this.potencial = potencial;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public boolean[] getRadioButtonValues() {
            return radioButtonValues;
        }

        public void setRadioButtonValues(boolean[] radioButtonValues) {
            this.radioButtonValues = radioButtonValues;
        }

        @Override
        public String toString() {
            return "Questao: " + questao + " Potencial: " +
                    potencial + "Titulo:" + titulo;
        }

    }

    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<AvaliacaoTrimestral> trimestral;
        private final Activity act;

        public AdapterAmcPersonalizada(List<AvaliacaoTrimestral> trimestral, Activity act) {
            this.trimestral = trimestral;
            this.act = act;
        }

        @Override
        public int getCount() {
            return trimestral.size();
        }

        @Override
        public Object getItem(int position) {
            return trimestral.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
            final AvaliacaoTrimestral trimestralAmc = trimestral.get(position);

            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);
            RadioButton simButton = (RadioButton) view.findViewById(sim);
            RadioButton naoButton = (RadioButton) view.findViewById(nao);
            RadioButton naButton = (RadioButton) view.findViewById(na);

            //populando as Views
            potencial.setText(String.valueOf(trimestralAmc.getPotencial()));
            questao.setText(String.valueOf(trimestralAmc.getQuestao()));
            titulo.setText(String.valueOf(trimestralAmc.getTitulo()));

            RadioGroup radioGroupAmc = (RadioGroup) view.findViewById(R.id.radioGroupAmc);

            radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    switch (checkedId) {
                        case sim:
                            trimestralAmc.radioButtonValues[0] = true;
                            trimestralAmc.radioButtonValues[1] = false;
                            trimestralAmc.radioButtonValues[2] = false;;

                            // trata radioValor1
                            break;
                        case nao:
                            trimestralAmc.radioButtonValues[0] = false;
                            trimestralAmc.radioButtonValues[1] = true;
                            trimestralAmc.radioButtonValues[2] = false;
                            // trata radioValor2
                            break;
                        case na:
                            trimestralAmc.radioButtonValues[0] = false;
                            trimestralAmc.radioButtonValues[1] = false;
                            trimestralAmc.radioButtonValues[2] = true;
                            // trata radioValor3
                            break;
                    }

                }

            });

            if( trimestralAmc.radioButtonValues[0])
            {
                simButton.setChecked(true);
                naoButton.setChecked(false);
                naButton.setChecked(false);
            } else {
                if(trimestralAmc.radioButtonValues[1]){
                    naoButton.setChecked(true);
                    simButton.setChecked(false);
                    naButton.setChecked(false);
                } else {
                    if(trimestralAmc.radioButtonValues[2]){
                        naButton.setChecked(true);
                        simButton.setChecked(false);
                        naoButton.setChecked(false);
                    }
                }
            }



            return view;
        }


    }


}
