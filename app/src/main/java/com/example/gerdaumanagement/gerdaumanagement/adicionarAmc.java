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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.gerdaumanagement.gerdaumanagement.R.id.dataRealizada;


/**
 * A simple {@link Fragment} subclass.
 */
public class adicionarAmc extends Fragment {
    private amc amcFeita = new amc();
    private Spinner nomeS;
    private Spinner contratadaS;
    private Spinner tipoS;
    private EditText data;
    private View rootviewSalva;

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

        db_funcao db = new db_funcao(getActivity());


        final View rootView = inflater.inflate(R.layout.fragment_adicionar_amc, container, false);

        List<String> listNomes = new ArrayList<String>();
        listNomes = db.buscarUsuarios();

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

        data = (EditText) rootView.findViewById(dataRealizada);
        data.addTextChangedListener(Mask.insert("##/##/####", data));

        RelativeLayout contentTipo = (RelativeLayout) rootView.findViewById(R.id.contentTipo);
        contentTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(getActivity());
            }
        });

        //Método do Spinner para capturar o item selecionado
        tipoS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                String nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado

                if (nome.equals("Mensal")) {

                    tipoMensal tipoMensal = new tipoMensal();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentTipo, tipoMensal, tipoMensal.getTag()).addToBackStack(null).commit();

                }
                if (nome.equals("Semestral")) {
                    tipoSemestral tipoSemestral = new tipoSemestral();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentTipo, tipoSemestral, tipoSemestral.getTag()).addToBackStack(null).commit();

                }
                if (nome.equals("Trimestral")) {

                    tipoTrimestral tipoTrimestral = new tipoTrimestral();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentTipo, tipoTrimestral, tipoTrimestral.getTag()).addToBackStack(null).commit();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


       /* nomeS = (Spinner) rootView.findViewById(R.id.colaboradoresAmc);
        contratadaS = (Spinner) rootView.findViewById(R.id.contratadasAmc);
        tipoS = (Spinner) rootView.findViewById(R.id.spinnerTipo);
        data = (EditText)rootView.findViewById(R.id.dataRealizada);*/


        rootviewSalva = rootView;
        return rootView;

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


    public void salvarRespostas(ArrayList<Integer> respostas) {

        amcFeita.respostas = respostas;
        amcFeita.setNome(nomeS.toString());
        amcFeita.setTipo(tipoS.toString());
        amcFeita.setTerceira(contratadaS.toString());
        amcFeita.setData(data.getText().toString());

        db_funcao db = new db_funcao(getContext());
        db.inserirAmc(amcFeita);

        Toast.makeText(getActivity(), "AMC inserida com sucesso!", Toast.LENGTH_SHORT).show();


    }

}