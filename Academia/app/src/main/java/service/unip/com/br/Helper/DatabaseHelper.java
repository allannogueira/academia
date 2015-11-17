package service.unip.com.br.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cleber on 15/04/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "Workout";
    private static final int VERSAO = 17;

    private static String tableAluno = "CREATE TABLE aluno (_id INTEGER PRIMARY KEY autoincrement, "
            + "nome TEXT, "
            + "data_nasc DATE, " +
            "cpf text, " +
            "rg text, " +
            "email text, " +
            "objetivo text, "
            + "FOREING KEY (medidas_id) REFERENCES medida(_id), " +
            "FOREING KEY (treino_id) REFERENCES treino(_id), " +
            "FOREING KEY (dieta_id) REFERENCES dieta(_id), " +
            "FOREING KEY (endereco_id) REFERENCES endereco(_id));";

    private static  String tableMedida = "CREATE TABLE medida (_id INTEGER PRIMARY KEY autoincrement, altura DOUBLE);";

    private static  String tableExercicios = "CREATE TABLE exercicios (_id INTEGER PRIMARY KEY autoincrement, " +
            "nome TEXT, " +
            "ar_livre BOOLEAN, " +
            "finalidade TEXT, " +
            "como_fazer TEXT," +
            "peso TEXT);";

    private static  String tableExercicioHasTreino = "CREATE TABLE exercicios_has_treino(exercicios_id integer , " +
            "treino_id integer, " +
            "peso text);";

    private static  String tableTreino = "CREATE TABLE treino(_id integer primary key autoincrement," +
            "nome text, " +
            "data_cadastro text, " +
            "data_inicio text, " +
            "data_fim text," +
            "serie text);";

    private static  String tableFrequencia = "CREATE TABLE frequencia(_id integer primary key autoincrement, " +
            "data_presenca date, " +
            "foreing key (aluno_id) references aluno(_id));";

    private static  String tableAlimentos = "CREATE TABLE alimentos(_id integer primary key autoincrement, " +
            "nome text, " +
            "caracteristica text, " +
            "descricao_nutricional text);";

    private static  String tableDietaHasAlimento = "CREATE TABLE dieta_has_alimentos(dieta_id integer," +
            "alimentos_id integer);";

    private static  String tableDietaGeral = "CREATE TABLE dietaGeral(_id integer primary key autoincrement, " +
            "nome text, " +
            "finalidade text);";

    private static  String tableDieta = "CREATE TABLE dieta(_id integer primary key autoincrement, " +
            "data_inicio text, " +
            "data_fim text, " +
            "dieta_id);";

    private static  String tableAcademia = "CREATE TABLE academia(_id integer primary key autoincrement, " +
            "nome text, " +
            "data_cadastro date, " +
            "foreing key (matriz_id) references academia(_id), " +
            "foreing key (endereco_id) references endereco(_id));";

    private static  String tableCepBrEstado = "CREATE TABLE cepbr_estado(uf text, " +
            "estado text, " +
            "cod_ibge date);";

    private static  String tableCepBrCidade = "CREATE TABLE cepbr_cidade(id_cidade integer, " +
            "cidade text, " +
            "cod_ibge text," +
            "uf text);";

    private static  String tableCepBrBairro = "CREATE TABLE cepbr_bairro(id_bairro integer, " +
            "bairro text, " +
            "cod_ibge text," +
            "id_cidade text);";

    private static  String tableCepBrEndereco = "CREATE TABLE cepbr_endereco(cep text, " +
            "endereco text, " +
            "id_bairro text," +
            "id_cidade text);";

    private static  String tableTipoEndereco = "CREATE TABLE tipo_endereco(_id integer primary key autoincrement, " +
            "descricao text);";

    private static  String tableEndereco = "CREATE TABLE endereco(_id integer primary key autoincrement, " +
            "rua text, " +
            "numero  text, " +
            "complemento  text, " +
            "cepbr_endereco text, " +
            "foreing key (tipo_endereco_id) references tipo_endereco(_id));";

    private static  String tableAparelho = "CREATE TABLE aparelho(_id integer primary key autoincrement, " +
            "nome text, " +
            "modelo  text, " +
            "finalidade  text, " +
            "foreing key (academia_id) references academia(_id));";

    private static  String tableAcademiaHasAluno = "CREATE TABLE academia_has_aluno(_id integer primary key autoincrement, " +
            "foreing key (academia_id) references academia(_id), " +
            "foreing key (aluno_id) references aluno(_id));";

    private static  String tableMedidas = "CREATE TABLE medidas(_id integer primary key autoincrement, " +
            "peso text, " +
            "altura text, " +
            "braco_d text, " +
            "braco_e text, " +
            "antbraco_d text, " +
            "antbraco_e text, " +
            "peitoral_maior text, " +
            "peitoral_menor text, " +
            "quadril text, " +
            "coxa_d text, " +
            "coxa_e text, " +
            "panturilha_d text, " +
            "panturilha_e text);";

    private static  String tableArLivre = "CREATE TABLE ar_livre(_id integer primary key autoincrement, " +
            "gordura_queimada text, " +
            "distancia_percorrida text, " +
            "aluno_id integer);";

    private static  String tableAparelhoNaoRecomendado = "CREATE TABLE aparelho_nao_recomendado(_id integer primary key autoincrement, " +
            "motivo text, " +
            "foreing key (aparelho_id) references aparelho(_id));";

    private static  String tableAcademiaHasAparelhoNaoRecomendado = "CREATE TABLE academia_has_aparelho_nao_recomendado(foreing key (aparelho_nao_recomendado_id) references aparelho_nao_recomendado(_id)," +
            "foreing key (academia_id) references academia(_id));";

    public DatabaseHelper(Context context){
        super (context, BANCO_DADOS, null, VERSAO);
    }

      //criação de tabelas deve ser realizadas no método onCreate
    @Override
    public void onCreate(SQLiteDatabase db){

        //db.execSQL(tableAluno);
       // db.execSQL(tableMedida);
        db.execSQL(tableExercicios);
        db.execSQL(tableExercicioHasTreino);
        db.execSQL(tableTreino);
        //db.execSQL(tableFrequencia);
        db.execSQL(tableAlimentos);
        db.execSQL(tableDietaHasAlimento);
        db.execSQL(tableDietaGeral);
        db.execSQL(tableDieta);
//        db.execSQL(tableAcademia);
//        db.execSQL(tableCepBrEstado);
//        db.execSQL(tableCepBrCidade);
//        db.execSQL(tableCepBrBairro);
//        db.execSQL(tableCepBrEndereco);
//        db.execSQL(tableTipoEndereco);
//        db.execSQL(tableEndereco);
//        db.execSQL(tableAparelho);
//        db.execSQL(tableAcademiaHasAluno);
//        db.execSQL(tableMedidas);
        db.execSQL(tableArLivre);
        /*db.execSQL(tableAparelhoNaoRecomendado);
        db.execSQL(tableAcademiaHasAparelhoNaoRecomendado);*/
    }

    //alterações de tabelas deve ser realizadas no método onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) {
        /*db.execSQL("drop table aluno;");
        db.execSQL("drop table medida;");*/
        db.execSQL("drop table exercicios;");
        db.execSQL("drop table exercicios_has_treino;");
        db.execSQL("drop table treino;");
        //db.execSQL("drop table frequencia;");

        db.execSQL("drop table alimentos;");
        db.execSQL("drop table dieta_has_alimentos;");
        db.execSQL("drop table dietaGeral;");
        db.execSQL("drop table dieta;");

        //db.execSQL("drop table academia;");
        /*db.execSQL("drop table cepbr_estado;");
        db.execSQL("drop table cepbr_cidade;");
        db.execSQL("drop table cepbr_bairro;");
        db.execSQL("drop table cepbr_endereco;");
        db.execSQL("drop table tipo_endereco;");
        db.execSQL("drop table endereco;");
        db.execSQL("drop table aparelho;");
        db.execSQL("drop table academia_has_aluno;");
        db.execSQL("drop table medidas;");*/
        db.execSQL("drop table ar_livre;");
        /*db.execSQL("drop table aparelho_nao_recomendado;");
        db.execSQL("drop table academia_has_aparelho_nao_recomendado;");*/

        onCreate(db);
    }

}
