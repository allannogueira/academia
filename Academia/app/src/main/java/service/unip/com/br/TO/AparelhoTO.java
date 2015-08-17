package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * tabela(nome="aparelho")
 */
public class AparelhoTO {

    private Long codAparelho;

    private String dscNome;

    private String dscModelo;

    private String dscFinalidade;

    private AcademiaTO academiaTO;

    public Long getCodAparelho() {
        return codAparelho;
    }

    public void setCodAparelho(Long codAparelho) {
        this.codAparelho = codAparelho;
    }

    public String getDscNome() {
        return dscNome;
    }

    public void setDscNome(String dscNome) {
        this.dscNome = dscNome;
    }

    public String getDscModelo() {
        return dscModelo;
    }

    public void setDscModelo(String dscModelo) {
        this.dscModelo = dscModelo;
    }

    public String getDscFinalidade() {
        return dscFinalidade;
    }

    public void setDscFinalidade(String dscFinalidade) {
        this.dscFinalidade = dscFinalidade;
    }

    public AcademiaTO getAcademiaTO() {
        return academiaTO;
    }

    public void setAcademiaTO(AcademiaTO academiaTO) {
        this.academiaTO = academiaTO;
    }
}
