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
public class tipoSemestral extends Fragment {

    public tipoSemestral() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tipo_semestral, container, false);
        ListView listaSemestral = (ListView) rootView.findViewById(R.id.listaSemestre);

        Button btnFooter = new Button(getActivity());
        btnFooter.setText("ENVIAR");
        btnFooter.setBackgroundResource(R.drawable.gradiente_azul_semconor);
        btnFooter.setTextColor(getResources().getColor(R.color.cinza));

        btnFooter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
        /*[...]*/
            }
        });


        List<AvaliacaoSemestral> semestral = todosSemestral();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(semestral, getActivity());

        listaSemestral.addFooterView(btnFooter);
        listaSemestral.setAdapter(adapter);

        return rootView;
    }

    public List<AvaliacaoSemestral> todosSemestral() {
        List<AvaliacaoSemestral> dadosSemestral = new ArrayList<AvaliacaoSemestral>();
        dadosSemestral.add(new AvaliacaoSemestral("A empresa possui PPRA/ PCMSO/ PCMAT?  O plano de ação do PPRA está de acordo com o cronograma?", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("Existe avaliação global do PPRA/ PCMSO", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("Os exames periodicos estão em dia? (Verificar por amostragem)", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("As licenças e documentos dos veículos estão em dia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("De acordo com os tacógrafos os veículos estão respeitando o limite de velocidade? ( Amostragem)", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("Livro de registro de inspeção deve esta disponivel na empresa (frente de trabalho). Os autos que geraram as não conformidades, autos de infração e multas devem ser regularizados / sanados", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("A contratada participa das reuniões trimestral com a gerencia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("Possui alguma ação em atraso do Risco Crítico?", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("Fichas de EPI's estão atualizadas?", 'B', "SEGURANÇA - GERAL"));
        dadosSemestral.add(new AvaliacaoSemestral("A empresa contratada possui PAE e está claro para os colaboradores?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral(" A empresa contratada realiza simulados de acidente?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("Os colaboradores estão com treinamento de integração ou reciclagem em dia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliacaoSemestral("A reunião de CIPATR foi realizada conforme calendário?", 'B', "Segurança Geral"));

        // Continuação do código
        return dadosSemestral;
    }

    class AvaliacaoSemestral {
        private String questao;
        private char potencial;
        private String titulo;
        boolean[] radioButtonValues = new boolean[3];


        public AvaliacaoSemestral(String questao, char potencial, String titulo) {
            this.questao = questao;
            this.potencial = potencial;
            this.titulo = titulo;

        }

        public boolean[] getRadioButtonValues() {
            return radioButtonValues;
        }

        public void setRadioButtonValues(boolean[] radioButtonValues) {
            this.radioButtonValues = radioButtonValues;
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

        @Override
        public String toString() {
            return "Questao: " + questao + " Potencial: " +
                    potencial + "Titulo:" + titulo;
        }

    }

    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<AvaliacaoSemestral> semestral;
        private final Activity act;

        public AdapterAmcPersonalizada(List<AvaliacaoSemestral> semestral, Activity act) {
            this.semestral = semestral;
            this.act = act;
        }

        @Override
        public int getCount() {
            return semestral.size();
        }

        @Override
        public Object getItem(int position) {
            return semestral.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
           final AvaliacaoSemestral semestralAmc = semestral.get(position);

            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);
            RadioButton simButton = (RadioButton) view.findViewById(R.id.sim);
            RadioButton naoButton = (RadioButton) view.findViewById(R.id.nao);
            RadioButton naButton = (RadioButton) view.findViewById(R.id.na);

            //populando as Views
            potencial.setText(String.valueOf(semestralAmc.getPotencial()));
            questao.setText(String.valueOf(semestralAmc.getQuestao()));
            titulo.setText(String.valueOf(semestralAmc.getTitulo()));


            RadioGroup radioGroupAmc = (RadioGroup) view.findViewById(R.id.radioGroupAmc);

            radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    switch (checkedId) {
                        case sim:
                            semestralAmc.radioButtonValues[0] = true;
                            semestralAmc.radioButtonValues[1] = false;
                            semestralAmc.radioButtonValues[2] = false;;

                            // trata radioValor1
                            break;
                        case nao:
                            semestralAmc.radioButtonValues[0] = false;
                            semestralAmc.radioButtonValues[1] = true;
                            semestralAmc.radioButtonValues[2] = false;
                            // trata radioValor2
                            break;
                        case na:
                            semestralAmc.radioButtonValues[0] = false;
                            semestralAmc.radioButtonValues[1] = false;
                            semestralAmc.radioButtonValues[2] = true;
                            // trata radioValor3
                            break;
                    }

                }

            });

            if( semestralAmc.radioButtonValues[0])
            {
                simButton.setChecked(true);
                naoButton.setChecked(false);
                naButton.setChecked(false);
            } else {
                if(semestralAmc.radioButtonValues[1]){
                    naoButton.setChecked(true);
                    simButton.setChecked(false);
                    naButton.setChecked(false);
                } else {
                    if(semestralAmc.radioButtonValues[2]){
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
