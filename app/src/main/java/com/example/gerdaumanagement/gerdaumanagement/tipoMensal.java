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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class tipoMensal extends Fragment  {

    private amc amc = new amc();


    public tipoMensal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_tipo_mensal, container, false);
        ListView listaMensal = (ListView) rootView.findViewById(R.id.lista);

        Button btnFooter = new Button(getActivity());
        btnFooter.setText("ENVIAR");
        btnFooter.setBackgroundResource(R.drawable.gradiente_azul_semconor);
        btnFooter.setTextColor(getResources().getColor(R.color.cinza));

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




        List<tiposAvaliacao> mensal = todosMensal();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        btnFooter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Iterator it = amc.respostas.iterator();
                while (it.hasNext()) {
                    System.out.println("AQUIIIIIIIIIIIIIIIIIIII" + it.next());
                }

               salvarAmc(rootView);

            }
        });

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(mensal, getActivity());

        listaMensal.addFooterView(btnFooter);
        listaMensal.setAdapter(adapter);

        return rootView;
    }


    public List<tiposAvaliacao> todosMensal() {
        List<tiposAvaliacao> dados = new ArrayList<tiposAvaliacao>();
        dados.add(new tiposAvaliacao("As máquinas e equipamentos possuem selo de liberação por um líder Gerdau e está dentro do prazo de validade?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Atividades se encontram sinalizadas ou isoladas?", 'B', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Todos os colaboradores estão usando os EPI´s básicos, específicos e em boas condições? Os EPI's são adequados aos riscos das atividades? Quando aplicável são realizados pré-uso dos mesmos?", 'B', "Condição Fisica"));
        dados.add(new tiposAvaliacao("As plataformas, andaimes, enlonadores, estruturas de guarda corpo e corrimão se encontram em boas condições?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Máquinas e equipamentos que possuem partes rotativas estão adequadas conforme NR 12?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Existe local adequado para refeição e sanitários suficientes conforme NR 31?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("A contratada faz o uso de bloqueio de energia quando aplicavel?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Todas as maquinas devem possuir proteção contra tombamento e cinto de segurança", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("A frente de trabalho possui caixa de primeiros socorros?", 'C', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Está sendo cumprida a proibição de utilizar adornos como: brincos, pulseiras, relógios, cordões, anéis, etc?", 'C', "Condição Fisica"));
        dados.add(new tiposAvaliacao("As proteções contra quedas, seja para acesso ou execução das tarefas, estão instaladas e usadas  de acordo c/ os procedimentos de segurança e conforme projeto elaborado por profissional habilitado ?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Os veículos operacionais e transporte de pessoas passaram pela vistoria mensal?", 'A', "Condição Fisica"));
        dados.add(new tiposAvaliacao("Todas atividades realizadas possuem padrão, IO ou APR?", 'A', "Sistema"));
        dados.add(new tiposAvaliacao("A APR é de conhecimento, está assinada por todos os executantes da tarefa e disponível na frente de serviço?  Toda liderança da contratada foi treinada nos padrões de APR e PT?", 'A', "Sistema"));
        dados.add(new tiposAvaliacao("As IPU's estão sendo preenchidas corretamente para máquinas, equipamentos, veículos e ferramentas manuais?", 'A', "Sistema"));
        dados.add(new tiposAvaliacao("Colaboradores que executam atividades críticas estão portando crachá de autorização para Riscos Críticos?", 'A', "Sistema"));
        dados.add(new tiposAvaliacao("Operadores e motoristas estão portanto CNH?", 'C', "Sistema"));
        dados.add(new tiposAvaliacao("A empresa tem uma média de 2 relatos por colaborador?", 'C', "Sistema"));
        dados.add(new tiposAvaliacao("A empresa está emitindo RTR?", 'C', "Sistema"));
        dados.add(new tiposAvaliacao("Os relatos estão sendo tratados em DDS?", 'C', "Sistema"));
        dados.add(new tiposAvaliacao("A empresa está dando fedback dos relatos e RTR para colaboradores?", 'C', "Sistema"));
        dados.add(new tiposAvaliacao("Está sendo realizado aferição de pressão arterial para colaboradores que realizam atividades críticas?", 'C', "Sistema"));
        dados.add(new tiposAvaliacao("Possui alguma ação em atraso de acidente?", 'A', "Sistema"));
        dados.add(new tiposAvaliacao("Regras Gerais e específicas estão sendo cumpridas?", 'B', "Sistema"));
        dados.add(new tiposAvaliacao("Possui novos colaborares na area? Se sim, possuem padrinhos treinando em ordem de serviço, IO, padrão e etc?", 'A', "Sistema"));
        dados.add(new tiposAvaliacao("A contratada deve possuir a coleta seletiva implantada e recipientes identificados à disposição dos colaboradores", 'B', "Meio Ambiente"));
        dados.add(new tiposAvaliacao("A coleta seletiva deve ser utilizada corretamente, com a destinação correta nos recipientes", 'C', "Meio Ambiente"));
        dados.add(new tiposAvaliacao("As embalagens de produtos quimicos / agrotóxicos devem ser devidamente armazenadas e devolvidas ao fabricante", 'A', "Meio Ambiente"));
        dados.add(new tiposAvaliacao("A contratada destina corretamente o óleo lubrificante usado e toma medidas adicionais durante o abastecimento de maquinas / motosserra", 'B', "Meio Ambiente"));
        dados.add(new tiposAvaliacao("As instalações devem ser localizadas com geografia favorável para obtenção de água, fora das APP (áreas de preservação permanente), com distância mínima a 100 metros dos rios e das nascentes d’água.", 'A', "Meio Ambiente"));
        dados.add(new tiposAvaliacao("Os produtos Químicos e Combustiveis estão armazenados de forma correta?", 'B', "Produto Quimíco e  Combustiveis"));
        dados.add(new tiposAvaliacao("Deve ter FISQP de todos os produtos armazenados, com atendimento as remendações e regras de armazenamento.", 'B', "Produto Quimíco e  Combustiveis"));
        dados.add(new tiposAvaliacao("Os locais de armazenamento possuem placas de acesso restrito e cadeado?", 'B', "Produto Quimíco e  Combustiveis"));
        dados.add(new tiposAvaliacao("As embalagens vazias de combustíveis ou lubrificantes devem permanecer neste local até ser retiradas da fazenda.", 'B', "Produto Quimíco e  Combustiveis"));
        dados.add(new tiposAvaliacao("Os produtos quimicos e inflamaveis são acima de 37°? Se não, existe autorização da area de SSMA da unidade?", 'A', "Produto Quimíco e  Combustiveis"));
        dados.add(new tiposAvaliacao("O deposito de produtos químicos posuem sinalização e proteção contra incêndios?", 'A', "Produto Quimíco e  Combustiveis"));
        dados.add(new tiposAvaliacao("Os serviços com produtos químicos e inflamáveis, possui a APR e Permissão de Trabalho? ", 'A', "Produto Quimíco e  Combustiveis"));

        // Continuação do código
        return dados;
    }

    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<tiposAvaliacao> mensal;
        private final Activity act;


        public AdapterAmcPersonalizada(List<tiposAvaliacao> mensal, Activity act) {
            this.mensal = mensal;
            this.act = act;
        }


        @Override
        public int getCount() {
            return mensal.size();
        }

        @Override
        public Object getItem(int position) {
            return mensal.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);

            final tiposAvaliacao mensalAmc = mensal.get(position);

            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);


            //populando as Views
            potencial.setText(String.valueOf(mensalAmc.getPotencial()));
            questao.setText(String.valueOf(mensalAmc.getQuestao()));
            titulo.setText(String.valueOf(mensalAmc.getTitulo()));

            RadioGroup radioGroupAmc = (RadioGroup) view.findViewById(R.id.radioGroupAmc);

            radioGroupAmc.check(mensalAmc.getSelectedRadioButtonId());

            radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(mensalAmc.getSelectedRadioButtonId() == 0){
                        amc.respostas.add(checkedId);
                    }else{
                        amc.respostas.remove(position);
                        amc.respostas.add(position,checkedId);
                    }

                    mensalAmc.setSelectedRadioButtonId(checkedId);

                }

            });


            return view;
        }


    }


    public void salvarAmc(View view){

       String salvarString = null;
        for(int i = 0; i < amc.respostas.size();i++){
            salvarString = salvarString +"," + i + "," + amc.respostas.get(i);
        }

        db_funcao bd = new db_funcao(getContext());
        bd.inserirAmc(amc);

      Toast.makeText(getActivity(), "AMC inserido com sucesso!", Toast.LENGTH_SHORT).show();

    }



}
