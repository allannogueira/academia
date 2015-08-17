package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */
public class SugestaoReclamacaoTO {

    private Long codSugestaoReclamacao;

    private AlunoTO alunoTO;

    private AcademiaTO academiaTO;

    private String dscPergunta;

    private String dscResposta;

    /*
        Esta Flag poder ser S ou R
        S: sugestao
        R: reclamaçao
     */
    private String flg_registro;

    public Long getCodSugestaoReclamacao() {
        return codSugestaoReclamacao;
    }

    public void setCodSugestaoReclamacao(Long codSugestaoReclamacao) {
        this.codSugestaoReclamacao = codSugestaoReclamacao;
    }

    public AlunoTO getAlunoTO() {
        return alunoTO;
    }

    public void setAlunoTO(AlunoTO alunoTO) {
        this.alunoTO = alunoTO;
    }

    public AcademiaTO getAcademiaTO() {
        return academiaTO;
    }

    public void setAcademiaTO(AcademiaTO academiaTO) {
        this.academiaTO = academiaTO;
    }

    public String getDscPergunta() {
        return dscPergunta;
    }

    public void setDscPergunta(String dscPergunta) {
        this.dscPergunta = dscPergunta;
    }

    public String getDscResposta() {
        return dscResposta;
    }

    public void setDscResposta(String dscResposta) {
        this.dscResposta = dscResposta;
    }

    public String getFlg_registro() {
        return flg_registro;
    }

    public void setFlg_registro(String flg_registro) {
        this.flg_registro = flg_registro;
    }


}
