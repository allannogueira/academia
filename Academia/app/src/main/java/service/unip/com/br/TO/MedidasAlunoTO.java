package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */

import android.widget.EditText;

/**
 * Table(neme="medidas")
 */
public class MedidasAlunoTO {

    private Long codMedidasAlunoTO;

    private EditText peso;

    private EditText altura;

    private EditText bicipsDireito;

    private EditText bicipsEsquerdo;

    private EditText tricepsDireito;

    private EditText tricepsEsquerdo;

    private EditText peitoralMaior;

    private EditText peitoralMenor;

    private EditText quadril;

    private EditText coxaDireita;

    private EditText coxaEsquerda;

    private EditText panturilhaDireita;

    private EditText panturilhaEsquerda;

    private EditText flgLado;

    public EditText getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(EditText abdomen) {
        this.abdomen = abdomen;
    }

    private EditText abdomen;

    public Long getCodMedidasAlunoTO() {
        return codMedidasAlunoTO;
    }

    public void setCodMedidasAlunoTO(Long codMedidasAlunoTO) {
        this.codMedidasAlunoTO = codMedidasAlunoTO;
    }

    public EditText getPeso() {
        return peso;
    }

    public void setPeso(EditText peso) {
        this.peso = peso;
    }

    public EditText getAltura() {
        return altura;
    }

    public void setAltura(EditText altura) {
        this.altura = altura;
    }

    public EditText getBicipsDireito() {
        return bicipsDireito;
    }

    public void setBicipsDireito(EditText bicipsDireito) {
        this.bicipsDireito = bicipsDireito;
    }

    public EditText getTricepsDireito() {
        return tricepsDireito;
    }

    public void setTricepsDireito(EditText tricepsDireito) {
        this.tricepsDireito = tricepsDireito;
    }

    public EditText getPeitoralMaior() {
        return peitoralMaior;
    }

    public void setPeitoralMaior(EditText peitoralMaior) {
        this.peitoralMaior = peitoralMaior;
    }

    public EditText getPeitoralMenor() {
        return peitoralMenor;
    }

    public void setPeitoralMenor(EditText peitoralMenor) {
        this.peitoralMenor = peitoralMenor;
    }

    public EditText getQuadril() {
        return quadril;
    }

    public void setQuadril(EditText quadril) {
        this.quadril = quadril;
    }

    public EditText getCoxaDireita() {
        return coxaDireita;
    }

    public void setCoxaDireita(EditText coxaDireita) {
        this.coxaDireita = coxaDireita;
    }

    public EditText getPanturilhaDireita() {
        return panturilhaDireita;
    }

    public void setPanturilhaDireita(EditText panturilhaDireita) {
        this.panturilhaDireita = panturilhaDireita;
    }

    public EditText getFlgLado() {
        return flgLado;
    }

    public void setFlgLado(EditText flgLado) {
        this.flgLado = flgLado;
    }

    public EditText getBicipsEsquerdo() {
        return bicipsEsquerdo;
    }

    public void setBicipsEsquerdo(EditText bicipsEsquerdo) {
        this.bicipsEsquerdo = bicipsEsquerdo;
    }

    public EditText getTricepsEsquerdo() {
        return tricepsEsquerdo;
    }

    public void setTricepsEsquerdo(EditText tricepsEsquerdo) {
        this.tricepsEsquerdo = tricepsEsquerdo;
    }

    public EditText getCoxaEsquerda() {
        return coxaEsquerda;
    }

    public void setCoxaEsquerda(EditText coxaEsquerda) {
        this.coxaEsquerda = coxaEsquerda;
    }

    public EditText getPanturilhaEsquerda() {
        return panturilhaEsquerda;
    }

    public void setPanturilhaEsquerda(EditText panturilhaEsquerda) {
        this.panturilhaEsquerda = panturilhaEsquerda;
    }
}
