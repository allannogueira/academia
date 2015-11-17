package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;
import service.unip.com.br.TO.ExercicioTO;

/**
 * Created by Cleber on 06/11/2015.
 */
public class ExercicioDAO {

    private SQLiteDatabase db;

    public ExercicioDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(ExercicioTO exercicio){
        ContentValues valores = new ContentValues();
        valores.put("nome", exercicio.getNmeExercicio());
        valores.put("ar_livre", "N");
        valores.put("finalidade", exercicio.getFinalidade());
        valores.put("como_fazer", exercicio.getDscDetalhes());
        valores.put("peso", exercicio.getPeso());

        db.insert("exercicios", null, valores);
    }

//    public void atualizar(AlunoTO aluno){
//        ContentValues valores = new ContentValues();
//        valores.put("nome", aluno.getNmeAluno());
//        valores.put("cpf", aluno.getNumCpf());
//        valores.put("rg", aluno.getNumRg());
//        valores.put("email", aluno.getDscEmail());
//        valores.put("objetivo", aluno.getObjTreino());
//        valores.put("medidas_id", aluno.getMedidasAlunoTO().getCodMedidasAlunoTO());
//        valores.put("treino_id", aluno.getTreinoAlunoTO().getCodTreinoAluno());
//        valores.put("dieta_id", aluno.getDietaAlunoTO().getCodDietaAluno());
//        valores.put("endereco_id", aluno.getEnderecoAluno().getCodEndereco());
//
//        db.update("aluno", valores, "_id = ?", new String[]{""+aluno.getCodAluno()});
//
//    }
//
//    public void deletar(AlunoTO aluno){
//        db.delete("aluno", "_id = "+aluno.getCodAluno(), null);
//
//    }
//
    public List<ExercicioTO> consultar(){
        List<ExercicioTO> listaExercicio = new ArrayList<ExercicioTO>();
        String[] colunas = new String[]{"_id","nome", "ar_livre", "finalidade", "como_fazer", "peso"};
        Cursor cursor = db. query("exercicios", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                ExercicioTO a = new ExercicioTO();
                a.setCodExercicio(cursor.getLong(0));
                a.setNmeExercicio(cursor.getString(1));
                a.setArLivre(cursor.getString(2));
                a.setFinalidade(cursor.getString(3));
                a.setDscDetalhes(cursor.getString(4));
                a.setPeso(cursor.getString(5));

                listaExercicio.add(a);
            }while (cursor.moveToNext());
        }
        return listaExercicio;
    }
}
