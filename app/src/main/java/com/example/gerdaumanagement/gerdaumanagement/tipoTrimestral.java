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

import static com.example.gerdaumanagement.gerdaumanagement.R.id.na;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.nao;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.sim;


/**
 * A simple {@link Fragment} subclass.
 */
public class tipoTrimestral extends Fragment {

    private amc amc = new amc();

    public tipoTrimestral() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_tipo_trimestral, container, false);
        ListView listaTrimestral = (ListView) rootView.findViewById(R.id.listaTrimestre);

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

        List<tiposAvaliacao> trimestral = todosTrimestral();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(trimestral, getActivity());

        listaTrimestral.addFooterView(btnFooter);
        listaTrimestral.setAdapter(adapter);

        return rootView;
    }

    public List<tiposAvaliacao> todosTrimestral() {
        List<tiposAvaliacao> dadosTrimestral = new ArrayList<tiposAvaliacao>();
        dadosTrimestral.add(new tiposAvaliacao("Existe uma lista de todos produtos químicos utilizados?", 'A', "Produto Químico"));
        dadosTrimestral.add(new tiposAvaliacao("Existe inflamavel? Se sim, possuem extintor de incendio no local?", 'A', "Produto Químico"));
        dadosTrimestral.add(new tiposAvaliacao("Proibido uso de fogão a lenha, deve ser a gas e o botijão ficando na parte externa (fora) ter boa ventilação.", 'A', "Cozinha / Refeitorio "));
        dadosTrimestral.add(new tiposAvaliacao("Ter local próprio para guardar os mantimentos e utensílios (prateleiras e ou armários), não pode guardar alimentos no chão.", 'B', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new tiposAvaliacao("Refrigerador para a guarda de alimentos perecíveis, quando tiver diponibilidade de energia elétrica no local.", 'C', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new tiposAvaliacao("Não deverá ter louças sujas e panelas pretas e encardidas e mal acondicionadas (espalhadas).", 'C', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new tiposAvaliacao("Deve ter mesa e bancos em número suficiente para que todos  possam, ao mesmo tempo, fazer as refeições sentados.", 'B', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new tiposAvaliacao("Deve ter cardápios elaborados por nutricionistas (cozinheiras), fixados nas cozinhas.", 'C', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new tiposAvaliacao("É proibido guardar ferramentas/combustíveis/produtos químicos neste local.", 'A', "Cozinha / Refeitorio"));
        dadosTrimestral.add(new tiposAvaliacao("Devem estar sempre limpos e ter um vaso sanitário para cada 20 colaboradores", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("Deve ter 01 chuveiro para cada 10 colaboradores", 'A', "Sanitários / Vestiários    "));
        dadosTrimestral.add(new tiposAvaliacao("Devem ter acento com tampa.", 'B', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("Estão instalados em compartimentos individuais separados masculino e feminino?", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("Instalação hidráulicas, elétricas, equipamentos, pias perfeitas e conservadas.", 'B', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("Deve ter sabão, papel toalha e  Papel Higiênico disponível", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("Porta para preservar o resguardo conveniente.", 'A', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("É proibido guardar ferramentas/combustíveis e produtos químicos neste local.", 'B', "Sanitários / Vestiários"));
        dadosTrimestral.add(new tiposAvaliacao("Devem estar sempre limpos e arrumados", 'B', "Dormitórios"));
        dadosTrimestral.add(new tiposAvaliacao("Devem ter uma cama para cada alojado, tamanho mínimo 1,90m x 0,70 m = 1,33 m², com colchão de espessura mínima 14cm, densidade mínima = 28, e roupa de cama limpa.", 'A', "Dormitórios"));
        dadosTrimestral.add(new tiposAvaliacao("A altura livre entre uma cama e outra, e entre a última e o teto deve ser de no mínimo 1,10m (no caso de beliche).", 'B', "Dormitórios"));
        dadosTrimestral.add(new tiposAvaliacao("Armário ou baú (caixa) com chave para cada alojado guardar seus pertences individualmente (tamanho mínimo de  0,60 m frente x 0,45 m de fundos e x 0,90 m de altura) ", 'A', "Dormitórios"));

        // Continuação do código
        return dadosTrimestral;
    }

    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<tiposAvaliacao> trimestral;
        private final Activity act;

        public AdapterAmcPersonalizada(List<tiposAvaliacao> trimestral, Activity act) {
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
            final tiposAvaliacao trimestralAmc = trimestral.get(position);

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

            radioGroupAmc.check(trimestralAmc.getSelectedRadioButtonId());

            radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(trimestralAmc.getSelectedRadioButtonId() == 0){
                        amc.respostas.add(checkedId);
                    }else{
                        amc.respostas.remove(position);
                        amc.respostas.add(position,checkedId);
                    }

                    trimestralAmc.setSelectedRadioButtonId(checkedId);

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
