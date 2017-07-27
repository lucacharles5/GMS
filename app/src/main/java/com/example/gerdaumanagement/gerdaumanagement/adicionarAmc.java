package com.example.gerdaumanagement.gerdaumanagement;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static com.example.gerdaumanagement.gerdaumanagement.R.id.dataRealizada;


/**
 * A simple {@link Fragment} subclass.
 */
public class adicionarAmc extends Fragment  {
    private amc amcFeita = new amc();
    private Spinner nomeS;
    private Spinner contratadaS;
    private Spinner tipoS;
    private EditText dataS;

    public adicionarAmc() {
        // Required empty public constructor
    }

    String[] COLABORADORES = new String[]{"Clever", "Diogo", "Fernando", "Mylena", "Lucas Charles", "Lucas Rafael", "Ediberto", "Eduardo"};
    String[] CONTRATADAS = new String[]{"AGROFUTURA CULTIVO DE EUCALIPTO E COMERCIO LTDA.", "AGROSUL PRODUCAO DE CARVAO LTDA.", "AJR EMPREENDIMENTO RURAIS LTDA.",
            "BELA RODRIGUES LTDA.", "CJR TRANSPORTES IMPORTAÇAO E EXPOR. LTDA.", "DEL REY REFLORESTAMENTO LTDA.", "FERREIRA SERVIÇOS FLORESTAIS LTDA.",
            "GLOBAL ENERGETICA LTDA.", "INVENTAR GMB CONSULTORIA LTDA.", "L E LOCAÇAO DE MAQ EQUIP LTDA.TRANSROCHA", "NG TRANSPORTES", "MINAS SUL FLORESTAL LTDA EPP", "MJ REFLORESTAMENTO LTDA ME",
            "MV TRATORES E SERVIÇOS LTDA", "REFLORESTAR SERVIÇOS FLORESTAIS LTDA.", "REFLORESTAMENTO PIEDADE LTDA", "SANTA CLARA SERVICOS FLORESTAIS LTD", "SANTOS ARAUJO  SERVIÇOS FLORESTAIS LTDA.",
            "TOMBA TERRA", "UNIAO PRESTAÇAO DE SERIVÇOS FLORSTAIS LTDA."};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MenuDrawer) getActivity()).setActionBarTitle("AMC");

        db_funcao db = new db_funcao(getActivity());


        final View rootView = inflater.inflate(R.layout.fragment_adicionar_amc, container, false);

        List<String> listNomes = new ArrayList<String>();
        listNomes = db.buscarUsuarios();

        for (int i = 0; i < listNomes.size(); i++) {
            if (listNomes.get(i).equals("admin")) {
                listNomes.remove(i);
            }
        }

        List<String> listContratadas = new ArrayList<String>();
        listContratadas.add("AGROFUTURA");
        listContratadas.add("AGROSUL");
        listContratadas.add("AJR");
        listContratadas.add("BELA RODRIGUES");
        listContratadas.add("CJR TRANSPORTES");
        listContratadas.add("DEL REY");
        listContratadas.add("FERREIRA SERVIÇOS");
        listContratadas.add("GLOBAL ENERGETICA");
        listContratadas.add("L E LOCAÇAO");
        listContratadas.add("NG TRANSPORTES");
        listContratadas.add("MINAS SUL");
        listContratadas.add("MV TRATORES ");
        listContratadas.add("NG MJ REFLORESTAMENTO");
        listContratadas.add("REFLORESTAR");
        listContratadas.add("REFLORESTAMENTO PIEDADE");
        listContratadas.add("SANTA CLARA");
        listContratadas.add("SANTOS ARAUJO");
        listContratadas.add("TOMBA TERRA");
        listContratadas.add("UNIAO PRESTAÇAO DE SERIVÇOS FLORSTAIS LTDA.");


        nomeS = (Spinner) rootView.findViewById(R.id.colaboradoresAmc);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, listNomes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nomeS.setAdapter(spinnerArrayAdapter);

        contratadaS = (Spinner) rootView.findViewById(R.id.contratadasAmc);

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, listContratadas);
        spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contratadaS.setAdapter(spinnerArrayAdapter);

        //TiPOS
        tipoS = (Spinner) rootView.findViewById(R.id.spinnerTipo);
        ArrayAdapter<CharSequence> adapterTipos = ArrayAdapter.createFromResource(getActivity(), R.array.tipos, android.R.layout.simple_list_item_1);
        adapterTipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoS.setAdapter(adapterTipos);

        dataS = (EditText) rootView.findViewById(dataRealizada);
        dataS.addTextChangedListener(Mask.insert("##/##/####", dataS));

        Button selecao = (Button) rootView.findViewById(R.id.preencherAmc);
        selecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                preencherAMC(nomeS, contratadaS,tipoS,dataS);
            }
        });


        return rootView;

    }

    public void preencherAMC(Spinner nomeS, Spinner contratadaS, Spinner tipoS, EditText dataS){

        Bundle data = new Bundle();
        data.putString("nome",nomeS.getSelectedItem().toString());
        data.putString("contratada", contratadaS.getSelectedItem().toString());
        data.putString("tipo", tipoS.getSelectedItem().toString());
        data.putString("data",dataS.getText().toString());

        preencherAmc preencherAmc = new preencherAmc();
        preencherAmc.setArguments(data);
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.content, preencherAmc, preencherAmc.getTag()).addToBackStack(null).commit();


    }


    //esconder teclado
    private void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public abstract static class Mask {

        public static String unmask(String s) {
            return s.replaceAll("[.]", "").replaceAll("[-]", "")
                    .replaceAll("[/]", "").replaceAll("[(]", "")
                    .replaceAll("[)]", "");
        }

        public static TextWatcher insert(final String mask, final EditText ediTxt) {
            return new TextWatcher() {
                boolean isUpdating;
                String old = "";

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String str = Mask.unmask(s.toString());
                    String mascara = "";
                    if (isUpdating) {
                        old = str;
                        isUpdating = false;
                        return;
                    }
                    int i = 0;
                    for (char m : mask.toCharArray()) {
                        if (m != '#' && str.length() > old.length()) {
                            mascara += m;
                            continue;
                        }
                        try {
                            mascara += str.charAt(i);
                        } catch (Exception e) {
                            break;
                        }
                        i++;
                    }
                    isUpdating = true;
                    ediTxt.setText(mascara);
                    ediTxt.setSelection(mascara.length());
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void afterTextChanged(Editable s) {
                }
            };
        }

    }






    /*public void salvarRespostas(ArrayList<Integer> respostas) {

        amcFeita.respostas = respostas;
        amcFeita.setNome(nomeS.toString());
        amcFeita.setTipo(tipoS.toString());
        amcFeita.setTerceira(contratadaS.toString());
        amcFeita.setData(data.getText().toString());

        db_funcao db = new db_funcao(getContext());
        db.inserirAmc(amcFeita);

        Toast.makeText(getActivity(), "AMC inserida com sucesso!", Toast.LENGTH_SHORT).show();


    }*/

}