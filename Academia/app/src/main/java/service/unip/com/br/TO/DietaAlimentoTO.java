package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="dieta_has_alimento")
 */
public class DietaAlimentoTO {

    private List<DietaGeralTO> listaDietaGeralTO;

    private List<AlimentoTO> listaAlimentoTO;

    public List<DietaGeralTO> getListaDietaGeralTO() {
        return listaDietaGeralTO;
    }

    public void setListaDietaGeralTO(List<DietaGeralTO> listaDietaGeralTO) {
        this.listaDietaGeralTO = listaDietaGeralTO;
    }

    public List<AlimentoTO> getListaAlimentoTO() {
        return listaAlimentoTO;
    }

    public void setListaAlimentoTO(List<AlimentoTO> listaAlimentoTO) {
        this.listaAlimentoTO = listaAlimentoTO;
    }
}
