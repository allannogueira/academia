package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="dieta_has_alimento")
 */
public class DietaAlimentoTO {

    private Long codDietaGeralTO;

    private Long codAlimentoTO;

    public Long getCodDietaGeralTO() {
        return codDietaGeralTO;
    }

    public void setCodDietaGeralTO(Long codDietaGeralTO) {
        this.codDietaGeralTO = codDietaGeralTO;
    }

    public Long getCodAlimentoTO() {
        return codAlimentoTO;
    }

    public void setCodAlimentoTO(Long codAlimentoTO) {
        this.codAlimentoTO = codAlimentoTO;
    }
}
