package com.example.gerdaumanagement.gerdaumanagement;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import SQLITE.db_funcao;
import pojos.amc;
import pojos.tiposAvaliacao;


/**
 * A simple {@link Fragment} subclass.
 */
public class preencherAmc extends Fragment {

    private pojos.amc amc = new amc();


    ArrayList<Character> potenciais = new ArrayList<>();

    public preencherAmc() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_preencher_amc, container, false);
        ListView lista = (ListView) rootView.findViewById(R.id.lista);

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
        List<tiposAvaliacao> dadosQuestoes = null;

        if(amc.getTipo().equals("Mensal")){
            ((MenuDrawer) getActivity()).setActionBarTitle("AMC Mensal");
            dadosQuestoes= todosMensal();

        }else {
            if(amc.getTipo().equals("Trimestral")){
                ((MenuDrawer) getActivity()).setActionBarTitle("AMC Trimestral");
                dadosQuestoes= todosTrimestral();
            }else
            {
                if(amc.getTipo().equals("Semestral")){
                    ((MenuDrawer) getActivity()).setActionBarTitle("AMC Semestral");
                    dadosQuestoes= todosSemestral();
                }
            }
        }


        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);
        for(int i =0; i< dadosQuestoes.size();i++){
            final tiposAvaliacao pegarpotencial = dadosQuestoes.get(i);

            potenciais.add(pegarpotencial.getPotencial());
            amc.respostas.add(1000);
        }
        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(dadosQuestoes, getActivity());

        lista.addFooterView(btnFooter);
        lista.setAdapter(adapter);

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

        private final List<tiposAvaliacao> dados;
        private final Activity act;

        public AdapterAmcPersonalizada(List<tiposAvaliacao> dados, Activity act) {
            this.dados = dados;
            this.act = act;
        }

        @Override
        public int getCount() {
            return dados.size();
        }

        @Override
        public Object getItem(int position) {
            return dados.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
            final tiposAvaliacao dadosAmc = dados.get(position);

            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);
            RadioButton simButton = (RadioButton) view.findViewById(R.id.sim);
            RadioButton naoButton = (RadioButton) view.findViewById(R.id.nao);
            RadioButton naButton = (RadioButton) view.findViewById(R.id.na);

            //populando as Views
            potencial.setText(String.valueOf(dadosAmc.getPotencial()));
            questao.setText(String.valueOf(dadosAmc.getQuestao()));
            titulo.setText(String.valueOf(dadosAmc.getTitulo()));


            RadioGroup radioGroupAmc = (RadioGroup) view.findViewById(R.id.radioGroupAmc);

            radioGroupAmc.check(dadosAmc.getSelectedRadioButtonId());

            radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                        amc.respostas.remove(position);
                        amc.respostas.add(position,checkedId);


                    dadosAmc.setSelectedRadioButtonId(checkedId);

                }

            });
            return view;
        }

    }

    public void salvarAmc(View view){

        int flag = 0;
        for(int i =0 ; i< amc.respostas.size();i++){

            if(amc.respostas.get(i)== 1000){

                flag =1;

            }
        }

        if(flag == 1){
            Toast.makeText(getActivity(), "Responda todas questões", Toast.LENGTH_SHORT).show();
        }
        else{
            amc.resultado = calcularResultado();
            String salvarString = null;
            for(int j = 0; j < amc.respostas.size();j++){
                salvarString = salvarString +","+ amc.respostas.get(j);
            }

            amc.setRespostasString(salvarString);
            db_funcao bd = new db_funcao(getContext());
            bd.inserirAmc(amc);


            Toast.makeText(getActivity(), "Avaliação inserida com sucesso!", Toast.LENGTH_SHORT).show();
            tecAmc tecAmc = new tecAmc();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.content,tecAmc, tecAmc.getTag()).commit();

        }


    }


    private double calcularResultado() {
        int resultado = 0;
        int resultado1= 0;

        for(int i=0;i<potenciais.size();i++) {
            if (amc.respostas.get(i) == 2131624064) {

                if (potenciais.get(i) == 'A') {

                    resultado += 3;
                } else {
                    if (potenciais.get(i) == 'B') {
                        resultado += 2;
                    } else {
                        if (potenciais.get(i) == 'C') {
                            resultado += 1;
                        }
                    }
                }

            } else {
                resultado += 0;
            }

            if (amc.respostas.get(i) == 2131624066) {

                resultado1 += 0;

            } else {

                if (potenciais.get(i) == 'A') {
                    resultado1 += 3;
                } else {
                    if (potenciais.get(i) == 'B') {
                        resultado1 += 2;
                    } else {
                        if (potenciais.get(i) == 'C') {
                            resultado1 += 1;
                        }
                    }
                }

            }

        }


        if(resultado == 0 || resultado1 == 0){
            return 0;
        }else
        {


            double resultadoFinal = ((double)resultado/(double)resultado1)*100;

            return (resultadoFinal);
        }

    }
}

