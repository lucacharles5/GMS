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
public class tipoMensal extends Fragment  {

    public tipoMensal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tipo_mensal, container, false);
        ListView listaMensal = (ListView) rootView.findViewById(R.id.lista);

        Button btnFooter = new Button(getActivity());
        btnFooter.setText("ENVIAR");
        btnFooter.setBackgroundResource(R.drawable.gradiente_azul_semconor);
        btnFooter.setTextColor(getResources().getColor(R.color.cinza));

        btnFooter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
        /*[...]*/
            }
        });


        List<AvaliacaoMensal> mensal = todosMensal();
        //ArrayAdapter<AvaliacaoMensal> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mensal);

        //chamada da nossa implementação
        AdapterAmcPersonalizada adapter = new AdapterAmcPersonalizada(mensal, getActivity());

        listaMensal.addFooterView(btnFooter);
        listaMensal.setAdapter(adapter);




        return rootView;
    }


    public List<AvaliacaoMensal> todosMensal() {
        List<AvaliacaoMensal> dados = new ArrayList<AvaliacaoMensal>();
    dados.add(new AvaliacaoMensal("As máquinas e equipamentos possuem selo de liberação por um líder Gerdau e está dentro do prazo de validade?", 'A', "Condição Fisica", false, false,false));
        dados.add(new AvaliacaoMensal("Atividades se encontram sinalizadas ou isoladas?", 'B' , "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Todos os colaboradores estão usando os EPI´s básicos, específicos e em boas condições? Os EPI's são adequados aos riscos das atividades? Quando aplicável são realizados pré-uso dos mesmos?", 'B', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("As plataformas, andaimes, enlonadores, estruturas de guarda corpo e corrimão se encontram em boas condições?", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Máquinas e equipamentos que possuem partes rotativas estão adequadas conforme NR 12?", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Existe local adequado para refeição e sanitários suficientes conforme NR 31?", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("A contratada faz o uso de bloqueio de energia quando aplicavel?", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Todas as maquinas devem possuir proteção contra tombamento e cinto de segurança", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("A frente de trabalho possui caixa de primeiros socorros?", 'C', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Está sendo cumprida a proibição de utilizar adornos como: brincos, pulseiras, relógios, cordões, anéis, etc?", 'C', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("As proteções contra quedas, seja para acesso ou execução das tarefas, estão instaladas e usadas  de acordo c/ os procedimentos de segurança e conforme projeto elaborado por profissional habilitado ?", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Os veículos operacionais e transporte de pessoas passaram pela vistoria mensal?", 'A', "Condição Fisica",false, false,false));
        dados.add(new AvaliacaoMensal("Todas atividades realizadas possuem padrão, IO ou APR?", 'A', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("A APR é de conhecimento, está assinada por todos os executantes da tarefa e disponível na frente de serviço?  Toda liderança da contratada foi treinada nos padrões de APR e PT?", 'A', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("As IPU's estão sendo preenchidas corretamente para máquinas, equipamentos, veículos e ferramentas manuais?", 'A', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Colaboradores que executam atividades críticas estão portando crachá de autorização para Riscos Críticos?", 'A', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Operadores e motoristas estão portanto CNH?", 'C', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("A empresa tem uma média de 2 relatos por colaborador?", 'C', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("A empresa está emitindo RTR?", 'C', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Os relatos estão sendo tratados em DDS?", 'C', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("A empresa está dando fedback dos relatos e RTR para colaboradores?", 'C', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Está sendo realizado aferição de pressão arterial para colaboradores que realizam atividades críticas?", 'C', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Possui alguma ação em atraso de acidente?", 'A', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Regras Gerais e específicas estão sendo cumpridas?", 'B', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("Possui novos colaborares na area? Se sim, possuem padrinhos treinando em ordem de serviço, IO, padrão e etc?", 'A', "Sistema",false, false,false));
        dados.add(new AvaliacaoMensal("A contratada deve possuir a coleta seletiva implantada e recipientes identificados à disposição dos colaboradores", 'B', "Meio Ambiente",false, false,false));
        dados.add(new AvaliacaoMensal("A coleta seletiva deve ser utilizada corretamente, com a destinação correta nos recipientes", 'C', "Meio Ambiente",false, false,false));
        dados.add(new AvaliacaoMensal("As embalagens de produtos quimicos / agrotóxicos devem ser devidamente armazenadas e devolvidas ao fabricante", 'A', "Meio Ambiente",false, false,false));
        dados.add(new AvaliacaoMensal("A contratada destina corretamente o óleo lubrificante usado e toma medidas adicionais durante o abastecimento de maquinas / motosserra", 'B', "Meio Ambiente",false, false,false));
        dados.add(new AvaliacaoMensal("As instalações devem ser localizadas com geografia favorável para obtenção de água, fora das APP (áreas de preservação permanente), com distância mínima a 100 metros dos rios e das nascentes d’água.", 'A', "Meio Ambiente",false, false,false));
        dados.add(new AvaliacaoMensal("Os produtos Químicos e Combustiveis estão armazenados de forma correta?", 'B', "Produto Quimíco e  Combustiveis",false, false,false));
        dados.add(new AvaliacaoMensal("Deve ter FISQP de todos os produtos armazenados, com atendimento as remendações e regras de armazenamento.", 'B', "Produto Quimíco e  Combustiveis",false, false,false));
        dados.add(new AvaliacaoMensal("Os locais de armazenamento possuem placas de acesso restrito e cadeado?", 'B', "Produto Quimíco e  Combustiveis",false, false,false));
        dados.add(new AvaliacaoMensal("As embalagens vazias de combustíveis ou lubrificantes devem permanecer neste local até ser retiradas da fazenda.", 'B', "Produto Quimíco e  Combustiveis",false, false,false));
        dados.add(new AvaliacaoMensal("Os produtos quimicos e inflamaveis são acima de 37°? Se não, existe autorização da area de SSMA da unidade?", 'A', "Produto Quimíco e  Combustiveis",false, false,false));
        dados.add(new AvaliacaoMensal("O deposito de produtos químicos posuem sinalização e proteção contra incêndios?", 'A', "Produto Quimíco e  Combustiveis",false, false,false));
        dados.add(new AvaliacaoMensal("Os serviços com produtos químicos e inflamáveis, possui a APR e Permissão de Trabalho? ", 'A', "Produto Quimíco e  Combustiveis",false, false,false));

        // Continuação do código
        return dados;
    }


    class AvaliacaoMensal {
        private String questao;
        private char potencial;
        private String titulo;
        private boolean sim, nao, na;


        public AvaliacaoMensal(String questao, char potencial, String titulo, boolean sim, boolean nao, boolean na) {
            this.questao = questao;
            this.potencial = potencial;
            this.titulo = titulo;
            this.sim = sim;
            this.nao = nao;
            this.na = na;

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

        public boolean isSim() {
            return sim;
        }

        public void setSim(boolean sim) {
            this.sim = sim;
        }

        public boolean isNao() {
            return nao;
        }

        public void setNao(boolean nao) {
            this.nao = nao;
        }

        public boolean isNa() {
            return na;
        }

        public void setNa(boolean na) {
            this.na = na;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        @Override
        public String toString() {
            return "Questao: " + questao + " Potencial: " +
                    potencial + "Titulo: " + titulo + "Sim: " + sim +
                    "Não: " + nao + "NA: " + na;
        }

    }

    class AdapterAmcPersonalizada extends BaseAdapter {

        private final List<AvaliacaoMensal> mensal;
        private final Activity act;

        public AdapterAmcPersonalizada(List<AvaliacaoMensal> mensal, Activity act) {
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
            AvaliacaoMensal mensalAmc = mensal.get(position);

            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);

            //populando as Views
            potencial.setText(String.valueOf(mensalAmc.getPotencial()));
            questao.setText(String.valueOf(mensalAmc.getQuestao()));
            titulo.setText(String.valueOf(mensalAmc.getTitulo()));

            if(mensalAmc.sim == true)
            {

            }

            return view;
        }


    }


}
