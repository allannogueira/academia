package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="cepbr_estado")
 */
public class CepBrEstadoTO {

    private Long codCepBrEstado;

    private String dscEstado;

    private String codIbge;

    public Long getCodCepBrEstado() {
        return codCepBrEstado;
    }

    public void setCodCepBrEstado(Long codCepBrEstado) {
        this.codCepBrEstado = codCepBrEstado;
    }

    public String getDscEstado() {
        return dscEstado;
    }

    public void setDscEstado(String dscEstado) {
        this.dscEstado = dscEstado;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }
}
