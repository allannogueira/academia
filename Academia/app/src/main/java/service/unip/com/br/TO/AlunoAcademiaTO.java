package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */

/**
 * Tabela(name="aluno_has_academia")
 */
public class AlunoAcademiaTO {

    private List<AlunoTO> listaAlunoTO;

    private List<AcademiaTO> listaAcademiaTO;

    public List<AlunoTO> getListaAlunoTO() {
        return listaAlunoTO;
    }

    public void setListaAlunoTO(List<AlunoTO> listaAlunoTO) {
        this.listaAlunoTO = listaAlunoTO;
    }

    public List<AcademiaTO> getListaAcademiaTO() {
        return listaAcademiaTO;
    }

    public void setListaAcademiaTO(List<AcademiaTO> listaAcademiaTO) {
        this.listaAcademiaTO = listaAcademiaTO;
    }
}
