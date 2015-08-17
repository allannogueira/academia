package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="cepbr_cidade")
 */
public class CepBrCidadeTO {

    private Long codCepBrCidade;

    private String dscCidade;

    private String codIbge;

    private CepBrEstadoTO cepBrEstadoTO;

    public Long getCodCepBrCidade() {
        return codCepBrCidade;
    }

    public void setCodCepBrCidade(Long codCepBrCidade) {
        this.codCepBrCidade = codCepBrCidade;
    }

    public CepBrEstadoTO getCepBrEstadoTO() {
        return cepBrEstadoTO;
    }

    public void setCepBrEstadoTO(CepBrEstadoTO cepBrEstadoTO) {
        this.cepBrEstadoTO = cepBrEstadoTO;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }

    public String getDscCidade() {
        return dscCidade;
    }

    public void setDscCidade(String dscCidade) {
        this.dscCidade = dscCidade;
    }
}
