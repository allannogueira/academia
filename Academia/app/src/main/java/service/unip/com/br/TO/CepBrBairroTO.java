package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="cepbr_bairro")
 */
public class CepBrBairroTO {

    private Long codCepBrBairro;

    private String nmeBairro;

    private CepBrCidadeTO cepBrCidadeTO;

    public Long getCodCepBrBairro() {
        return codCepBrBairro;
    }

    public void setCodCepBrBairro(Long codCepBrBairro) {
        this.codCepBrBairro = codCepBrBairro;
    }

    public String getNmeBairro() {
        return nmeBairro;
    }

    public void setNmeBairro(String nmeBairro) {
        this.nmeBairro = nmeBairro;
    }

    public CepBrCidadeTO getCepBrCidadeTO() {
        return cepBrCidadeTO;
    }

    public void setCepBrCidadeTO(CepBrCidadeTO cepBrCidadeTO) {
        this.cepBrCidadeTO = cepBrCidadeTO;
    }
}
