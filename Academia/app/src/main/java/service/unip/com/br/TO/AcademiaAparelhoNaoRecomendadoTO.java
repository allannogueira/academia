package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */

import java.util.List;

/**
 * tabela(nome="academia_has_aparelho_nao_recomendado")
 */
public class AcademiaAparelhoNaoRecomendadoTO {

    private List<AcademiaTO> listaAcademiaTO;

    private List<AparelhoNaoRecomendadoTO> listaAparelhoNaoRecomendadoTO;

    public List<AcademiaTO> getListaAcademiaTO() {
        return listaAcademiaTO;
    }

    public void setListaAcademiaTO(List<AcademiaTO> listaAcademiaTO) {
        this.listaAcademiaTO = listaAcademiaTO;
    }

    public List<AparelhoNaoRecomendadoTO> getListaAparelhoNaoRecomendadoTO() {
        return listaAparelhoNaoRecomendadoTO;
    }

    public void setListaAparelhoNaoRecomendadoTO(List<AparelhoNaoRecomendadoTO> listaAparelhoNaoRecomendadoTO) {
        this.listaAparelhoNaoRecomendadoTO = listaAparelhoNaoRecomendadoTO;
    }
}
