package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="cepbr_endereco")
 */
public class CepBrEnderecoTO {

    private Long codCep;

    private String endereco;

    private CepBrBairroTO cepBrBairroTO;

    private CepBrCidadeTO cepBrCidadeT;


    public Long getCodCep() {

        return codCep;
    }

    public void setCodCep(Long codCep) {
        this.codCep = codCep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public CepBrBairroTO getCepBrBairroTO() {
        return cepBrBairroTO;
    }

    public void setCepBrBairroTO(CepBrBairroTO cepBrBairroTO) {
        this.cepBrBairroTO = cepBrBairroTO;
    }

    public CepBrCidadeTO getCepBrCidadeT() {
        return cepBrCidadeT;
    }

    public void setCepBrCidadeT(CepBrCidadeTO cepBrCidadeT) {
        this.cepBrCidadeT = cepBrCidadeT;
    }
}
