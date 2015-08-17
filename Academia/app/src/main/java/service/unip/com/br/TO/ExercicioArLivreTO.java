package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="ar_livre")
 */
public class ExercicioArLivreTO {

    private Long codExercicioArLivre;

    private String vlrCaloriasQueimada;

    private String distanciaPercorrida;

    private AlunoTO alunoTO;

    public Long getCodExercicioArLivre() {
        return codExercicioArLivre;
    }

    public void setCodExercicioArLivre(Long codExercicioArLivre) {
        this.codExercicioArLivre = codExercicioArLivre;
    }

    public String getVlrCaloriasQueimada() {
        return vlrCaloriasQueimada;
    }

    public void setVlrCaloriasQueimada(String vlrCaloriasQueimada) {
        this.vlrCaloriasQueimada = vlrCaloriasQueimada;
    }

    public String getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(String distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public AlunoTO getAlunoTO() {
        return alunoTO;
    }

    public void setAlunoTO(AlunoTO alunoTO) {
        this.alunoTO = alunoTO;
    }
}
