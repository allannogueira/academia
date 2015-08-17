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

    private Date dataCadastro;

    private List<AlunoTO> listaAlunoTO;

    private EnderecoTO enderecoTO;

    private List<SugestaoReclamacaoTO> listaSugestaoReclamacao;

    private AcademiaTO matrizAcademia;

    private List<AcademiaAparelhoNaoRecomendadoTO> listaAcademiaAparelhoNaoRecomendadoTOTO;

    private List<AparelhoTO> listaAparelhoTO;
}
