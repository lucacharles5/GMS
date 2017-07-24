package com.example.gerdaumanagement.gerdaumanagement;


import android.app.Activity;
import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class tipoSemestral extends Fragment {

    private amc amc = new amc();

    public tipoSemestral() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_tipo_semestral, container, false);
        ListView listaSemestral = (ListView) rootView.findViewById(R.id.listaSemestre);

        Button btnFooter = new Button(getActivity());
        btnFooter.setText("ENVIAR");
        btnFooter.setBackgroundResource(R.drawable.gradiente_azul_semconor);
        btnFooter.setTextColor(getResources().getColor(R.color.cinza));

        btnFooter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                salvarAmc(rootView);
            }
        });

        Intent intent = getActivity().getIntent();
        if(intent != null){
            if(getArguments() != null){

                getArguments().getString("nome", "");
                getArguments().getString("contratada", "");
                getArguments().getString("tipo", "");
                getArguments().getString("data", "");
                getArguments().getInt("id", 0);

                int id = getArguments().getInt("id");
                String nomeSalvar = getArguments().getString("nome");
                String contratadasSalvar = getArguments().getString("contratada");
                String dataSalvar = getArguments().getString("data");
                String tipoSalvar = getArguments().getString("tipo");

                amc.setId(id);
                amc.setNome(nomeSalvar);
                amc.setContratada(contratadasSalvar);
                amc.setTipo(tipoSalvar);
                amc.setData(dataSalvar);

            }
        }
        List<tiposAvaliacao> semestral = todosSemestral();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(semestral, getActivity());

        listaSemestral.addFooterView(btnFooter);
        listaSemestral.setAdapter(adapter);

        return rootView;
    }

    public List<tiposAvaliacao> todosSemestral() {
        List<tiposAvaliacao> dadosSemestral = new ArrayList<tiposAvaliacao>();
        dadosSemestral.add(new tiposAvaliacao("A empresa possui PPRA/ PCMSO/ PCMAT?  O plano de ação do PPRA está de acordo com o cronograma?", 'A', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("Existe avaliação global do PPRA/ PCMSO", 'A', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("Os exames periodicos estão em dia? (Verificar por amostragem)", 'A', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("As licenças e documentos dos veículos estão em dia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("De acordo com os tacógrafos os veículos estão respeitando o limite de velocidade? ( Amostragem)", 'B', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("Livro de registro de inspeção deve esta disponivel na empresa (frente de trabalho). Os autos que geraram as não conformidades, autos de infração e multas devem ser regularizados / sanados", 'A', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("A contratada participa das reuniões trimestral com a gerencia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("Possui alguma ação em atraso do Risco Crítico?", 'A', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("Fichas de EPI's estão atualizadas?", 'B', "SEGURANÇA - GERAL"));
        dadosSemestral.add(new tiposAvaliacao("A empresa contratada possui PAE e está claro para os colaboradores?", 'B', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao(" A empresa contratada realiza simulados de acidente?", 'B', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("Os colaboradores estão com treinamento de integração ou reciclagem em dia?", 'B', "Segurança Geral"));
        dadosSemestral.add(new tiposAvaliacao("A reunião de CIPATR foi realizada conforme calendário?", 'B', "Segurança Geral"));

        // Continuação do código
        return dadosSemestral;
    }


    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<tiposAvaliacao> semestral;
        private final Activity act;

        public AdapterAmcPersonalizada(List<tiposAvaliacao> semestral, Activity act) {
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
           final tiposAvaliacao semestralAmc = semestral.get(position);

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

            radioGroupAmc.check(semestralAmc.getSelectedRadioButtonId());

            radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(semestralAmc.getSelectedRadioButtonId() == 0){
                        amc.respostas.add(checkedId);
                    }else{
                        amc.respostas.remove(position);
                        amc.respostas.add(position,checkedId);
                    }

                    semestralAmc.setSelectedRadioButtonId(checkedId);

                }

            });
            return view;
        }


    }

    public void salvarAmc(View view){

        String salvarString = null;
        for(int i = 0; i < amc.respostas.size();i++){
            salvarString = salvarString +","+ amc.respostas.get(i);
        }

        amc.setRespostasString(salvarString);

        db_funcao bd = new db_funcao(getContext());
        bd.inserirAmc(amc);

        Toast.makeText(getActivity(), "AMC inserido com sucesso!", Toast.LENGTH_SHORT).show();

    }

}
