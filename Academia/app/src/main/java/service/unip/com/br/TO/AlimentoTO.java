package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="alimentos")
 */
public class AlimentoTO {

    private Long codAlimento;

    private String nmeAlimento;

    private String dscCaracteriscia;

    private String dscNutricional;

    private List<DietaAlimentoTO> listaDietaAlimentoTO;

    public Long getCodAlimento() {
        return codAlimento;
    }

    public void setCodAlimento(Long codAlimento) {
        this.codAlimento = codAlimento;
    }

    public String getNmeAlimento() {
        return nmeAlimento;
    }

    public void setNmeAlimento(String nmeAlimento) {
        this.nmeAlimento = nmeAlimento;
    }

    public String getDscCaracteriscia() {
        return dscCaracteriscia;
    }

    public void setDscCaracteriscia(String dscCaracteriscia) {
        this.dscCaracteriscia = dscCaracteriscia;
    }

    public String getDscNutricional() {
        return dscNutricional;
    }

    public void setDscNutricional(String dscNutricional) {
        this.dscNutricional = dscNutricional;
    }

    public List<DietaAlimentoTO> getListaDietaAlimentoTO() {
        return listaDietaAlimentoTO;
    }

    public void setListaDietaAlimentoTO(List<DietaAlimentoTO> listaDietaAlimentoTO) {
        this.listaDietaAlimentoTO = listaDietaAlimentoTO;
    }
}
