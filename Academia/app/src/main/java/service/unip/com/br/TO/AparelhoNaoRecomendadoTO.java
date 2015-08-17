package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */

import java.util.List;

/**
 * tabela(nome="aparelho_nao_recomendado")
 */
public class AparelhoNaoRecomendadoTO {

    private Long codAparelhoNaoRecomendado;

    private AparelhoTO aparelhoTO;

    private List<AcademiaAparelhoNaoRecomendadoTO> listaAcademiaAparelhoNaoRecomendadoTO;

    private String dscMotivo;

    public Long getCodAparelhoNaoRecomendado() {
        return codAparelhoNaoRecomendado;
    }

    public void setCodAparelhoNaoRecomendado(Long codAparelhoNaoRecomendado) {
        this.codAparelhoNaoRecomendado = codAparelhoNaoRecomendado;
    }

    public AparelhoTO getAparelhoTO() {
        return aparelhoTO;
    }

    public void setAparelhoTO(AparelhoTO aparelhoTO) {
        this.aparelhoTO = aparelhoTO;
    }

    public List<AcademiaAparelhoNaoRecomendadoTO> getListaAcademiaAparelhoNaoRecomendadoTO() {
        return listaAcademiaAparelhoNaoRecomendadoTO;
    }

    public void setListaAcademiaAparelhoNaoRecomendadoTO(List<AcademiaAparelhoNaoRecomendadoTO> listaAcademiaAparelhoNaoRecomendadoTO) {
        this.listaAcademiaAparelhoNaoRecomendadoTO = listaAcademiaAparelhoNaoRecomendadoTO;
    }

    public String getDscMotivo() {
        return dscMotivo;
    }

    public void setDscMotivo(String dscMotivo) {
        this.dscMotivo = dscMotivo;
    }
}
