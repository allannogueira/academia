package service.unip.com.br.TO;

import java.util.Date;
import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */

/**
 * tabela(nome="academia")
 */
public class AcademiaTO {

    private Long codAcademiaTO;

    private String nmeAcademia;

    private String dataCadastro;

    private List<AlunoTO> listaAlunoTO;

    private EnderecoTO enderecoTO;

    private List<SugestaoReclamacaoTO> listaSugestaoReclamacao;

    private AcademiaTO matrizAcademia;

    private List<AcademiaAparelhoNaoRecomendadoTO> listaAcademiaAparelhoNaoRecomendadoTOTO;

    private List<AparelhoTO> listaAparelhoTO;

    public Long getCodAcademiaTO() {
        return codAcademiaTO;
    }

    public void setCodAcademiaTO(Long codAcademiaTO) {
        this.codAcademiaTO = codAcademiaTO;
    }

    public String getNmeAcademia() {
        return nmeAcademia;
    }

    public void setNmeAcademia(String nmeAcademia) {
        this.nmeAcademia = nmeAcademia;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<AlunoTO> getListaAlunoTO() {
        return listaAlunoTO;
    }

    public void setListaAlunoTO(List<AlunoTO> listaAlunoTO) {
        this.listaAlunoTO = listaAlunoTO;
    }

    public EnderecoTO getEnderecoTO() {
        return enderecoTO;
    }

    public void setEnderecoTO(EnderecoTO enderecoTO) {
        this.enderecoTO = enderecoTO;
    }

    public List<SugestaoReclamacaoTO> getListaSugestaoReclamacao() {
        return listaSugestaoReclamacao;
    }

    public void setListaSugestaoReclamacao(List<SugestaoReclamacaoTO> listaSugestaoReclamacao) {
        this.listaSugestaoReclamacao = listaSugestaoReclamacao;
    }

    public AcademiaTO getMatrizAcademia() {
        return matrizAcademia;
    }

    public void setMatrizAcademia(AcademiaTO matrizAcademia) {
        this.matrizAcademia = matrizAcademia;
    }

    public List<AcademiaAparelhoNaoRecomendadoTO> getListaAcademiaAparelhoNaoRecomendadoTOTO() {
        return listaAcademiaAparelhoNaoRecomendadoTOTO;
    }

    public void setListaAcademiaAparelhoNaoRecomendadoTOTO(List<AcademiaAparelhoNaoRecomendadoTO> listaAcademiaAparelhoNaoRecomendadoTOTO) {
        this.listaAcademiaAparelhoNaoRecomendadoTOTO = listaAcademiaAparelhoNaoRecomendadoTOTO;
    }

    public List<AparelhoTO> getListaAparelhoTO() {
        return listaAparelhoTO;
    }

    public void setListaAparelhoTO(List<AparelhoTO> listaAparelhoTO) {
        this.listaAparelhoTO = listaAparelhoTO;
    }
}
