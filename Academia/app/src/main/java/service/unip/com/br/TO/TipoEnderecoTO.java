package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="tipo_endereco")
 */
public class TipoEnderecoTO {

    private Long codTipoEnderecoTO;

    private String descricao;

    public Long getCodTipoEnderecoTO() {
        return codTipoEnderecoTO;
    }

    public void setCodTipoEnderecoTO(Long codTipoEnderecoTO) {
        this.codTipoEnderecoTO = codTipoEnderecoTO;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
