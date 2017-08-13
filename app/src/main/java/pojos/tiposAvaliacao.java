package pojos;

/**
 * Created by Lucas on 24/07/2017.
 */

public class tiposAvaliacao {
    private String questao;
    private char potencial;
    private String titulo;
    private int selectedRadioButtonId;

    public tiposAvaliacao(String questao, char potencial, String titulo) {
        this.questao = questao;
        this.potencial = potencial;
        this.titulo = titulo;

    }

    public int getSelectedRadioButtonId() {
        return selectedRadioButtonId;
    }

    public void setSelectedRadioButtonId(int radioButtonId) {
        selectedRadioButtonId = radioButtonId;
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
                potencial + "Titulo: " + titulo;
    }

}
