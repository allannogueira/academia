package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="endereco")
 */
public class EnderecoTO {

    private Long codEndereco;

    private String dscRua;

    private String dscNumero;

    private String dscComplemento;

    private TipoEnderecoTO tipoEnderecoTO;

    private CepBrEnderecoTO cepBrEnderecoTO;

    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getDscRua() {
        return dscRua;
    }

    public void setDscRua(String dscRua) {
        this.dscRua = dscRua;
    }

    public String getDscNumero() {
        return dscNumero;
    }

    public void setDscNumero(String dscNumero) {
        this.dscNumero = dscNumero;
    }

    public String getDscComplemento() {
        return dscComplemento;
    }

    public void setDscComplemento(String dscComplemento) {
        this.dscComplemento = dscComplemento;
    }

    public TipoEnderecoTO getTipoEnderecoTO() {
        return tipoEnderecoTO;
    }

    public void setTipoEnderecoTO(TipoEnderecoTO tipoEnderecoTO) {
        this.tipoEnderecoTO = tipoEnderecoTO;
    }

    public CepBrEnderecoTO getCepBrEnderecoTO() {
        return cepBrEnderecoTO;
    }

    public void setCepBrEnderecoTO(CepBrEnderecoTO cepBrEnderecoTO) {
        this.cepBrEnderecoTO = cepBrEnderecoTO;
    }
}
