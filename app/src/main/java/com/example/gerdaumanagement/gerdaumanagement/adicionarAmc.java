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
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class adicionarAmc extends Fragment  {



    public adicionarAmc() {
        // Required empty public constructor
    }

    String[] COLABORADORES = new String[] {"Clever", "Diogo", "Fernando", "Mylena", "Lucas Charles","Lucas Rafael","Ediberto","Eduardo"};
    String[] CONTRATADAS = new String[] {"AGROFUTURA CULTIVO DE EUCALIPTO E COMERCIO LTDA.", "AGROSUL PRODUCAO DE CARVAO LTDA.","AJR EMPREENDIMENTO RURAIS LTDA.",
            "BELA RODRIGUES LTDA.", "CJR TRANSPORTES IMPORTAÇAO E EXPOR. LTDA.", "DEL REY REFLORESTAMENTO LTDA.", "FERREIRA SERVIÇOS FLORESTAIS LTDA.",
    "GLOBAL ENERGETICA LTDA.", "INVENTAR GMB CONSULTORIA LTDA.", "L E LOCAÇAO DE MAQ EQUIP LTDA.TRANSROCHA", "NG TRANSPORTES", "MINAS SUL FLORESTAL LTDA EPP", "MJ REFLORESTAMENTO LTDA ME",
    "MV TRATORES E SERVIÇOS LTDA", "REFLORESTAR SERVIÇOS FLORESTAIS LTDA.", "REFLORESTAMENTO PIEDADE LTDA","SANTA CLARA SERVICOS FLORESTAIS LTD","SANTOS ARAUJO  SERVIÇOS FLORESTAIS LTDA.",
    "TOMBA TERRA", "UNIAO PRESTAÇAO DE SERIVÇOS FLORSTAIS LTDA."};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        final View rootView = inflater.inflate(R.layout.fragment_adicionar_amc, container, false);
        //COlaborador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, COLABORADORES);
        AutoCompleteTextView textView = (AutoCompleteTextView) rootView.findViewById(R.id.colaboradoresAmc);
        textView.setThreshold(2);
        textView.setAdapter(adapter);

        //contratadas
        ArrayAdapter<String> adapterContra = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, CONTRATADAS);
        AutoCompleteTextView textViewContra = (AutoCompleteTextView) rootView.findViewById(R.id.contratadasAmc);
        textViewContra.setThreshold(1);
        textViewContra.setAdapter(adapterContra);

        //TiPOS
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinnerTipo);
        ArrayAdapter<CharSequence> adapterTipos = ArrayAdapter.createFromResource(getActivity(), R.array.tipos, android.R.layout.select_dialog_item);
        adapterTipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterTipos);

        final EditText dataRealizada = (EditText) rootView.findViewById(R.id.dataRealizada);
        dataRealizada.addTextChangedListener(Mask.insert("##/##/####", dataRealizada));

            RelativeLayout contentTipo = (RelativeLayout) rootView.findViewById(R.id.contentTipo);
        contentTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(getActivity());
            }
        });



        //Método do Spinner para capturar o item selecionado
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                String nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado

                if (nome.equals("Mensal")) {

                    tipoMensal tipoMensal = new tipoMensal();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentTipo,tipoMensal, tipoMensal.getTag()).addToBackStack(null).commit();

                }if (nome.equals("Semestral")) {
                    tipoSemestral tipoSemestral = new tipoSemestral();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentTipo,tipoSemestral, tipoSemestral.getTag()).addToBackStack(null).commit();

                }if (nome.equals("Trimestral")) {

                    tipoTrimestral tipoTrimestral = new tipoTrimestral();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentTipo,tipoTrimestral, tipoTrimestral.getTag()).addToBackStack(null).commit();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

        public  static TextWatcher insert(final String mask, final EditText ediTxt) {
            return new TextWatcher() {
                boolean isUpdating;
                String old = "";
                public void onTextChanged(CharSequence s, int start, int before,int count) {
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
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                public void afterTextChanged(Editable s) {}
            };
        }


    }



}
