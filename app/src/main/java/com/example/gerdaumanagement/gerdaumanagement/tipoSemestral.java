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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


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


        List<AvaliazaoSemestral> semestral = todosSemestral();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(semestral, getActivity());

        listaSemestral.addFooterView(btnFooter);
        listaSemestral.setAdapter(adapter);

        return rootView;
    }

    public List<AvaliazaoSemestral> todosSemestral() {
        List<AvaliazaoSemestral> dadosSemestral = new ArrayList<AvaliazaoSemestral>();
        dadosSemestral.add(new AvaliazaoSemestral("A empresa possui PPRA/ PCMSO/ PCMAT?  O plano de ação do PPRA está de acordo com o cronograma?", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("Existe avaliação global do PPRA/ PCMSO", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("Os exames periodicos estão em dia? (Verificar por amostragem)", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("As licenças e documentos dos veículos estão em dia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("De acordo com os tacógrafos os veículos estão respeitando o limite de velocidade? ( Amostragem)", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("Livro de registro de inspeção deve esta disponivel na empresa (frente de trabalho). Os autos que geraram as não conformidades, autos de infração e multas devem ser regularizados / sanados", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("A contratada participa das reuniões trimestral com a gerencia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("Possui alguma ação em atraso do Risco Crítico?", 'A', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("Fichas de EPI's estão atualizadas?", 'B', "SEGURANÇA - GERAL"));
        dadosSemestral.add(new AvaliazaoSemestral("A empresa contratada possui PAE e está claro para os colaboradores?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral(" A empresa contratada realiza simulados de acidente?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("Os colaboradores estão com treinamento de integração ou reciclagem em dia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new AvaliazaoSemestral("A reunião de CIPATR foi realizada conforme calendário?", 'B', "Segurança Geral"));



        // Continuação do código
        return dadosSemestral;
    }

    class AvaliazaoSemestral {
        private String questao;
        private char potencial;
        private String titulo;


        public AvaliazaoSemestral(String questao, char potencial, String titulo) {
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

        @Override
        public String toString() {
            return "Questao: " + questao + " Potencial: " +
                    potencial + "Titulo:" + titulo;
        }

    }

    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<AvaliazaoSemestral> semestral;
        private final Activity act;

        public AdapterAmcPersonalizada(List<AvaliazaoSemestral> semestral, Activity act) {
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
            AvaliazaoSemestral semestralAmc = semestral.get(position);

            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);

            //populando as Views
            potencial.setText(String.valueOf(semestralAmc.getPotencial()));
            questao.setText(String.valueOf(semestralAmc.getQuestao()));
            titulo.setText(String.valueOf(semestralAmc.getTitulo()));


            return view;
        }


    }


}
