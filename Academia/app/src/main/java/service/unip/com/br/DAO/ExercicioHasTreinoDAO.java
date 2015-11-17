package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;
import service.unip.com.br.TO.ExercicioArLivreTO;
import service.unip.com.br.TO.ExercicioTO;
import service.unip.com.br.TO.ExercicioTreinoTO;

/**
 * Created by Cleber on 06/11/2015.
 */
public class ExercicioHasTreinoDAO {

    private SQLiteDatabase db;

    public ExercicioHasTreinoDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(Long idExercicio, Long idTreino, String peso){
        ContentValues valores = new ContentValues();
        valores.put("exercicios_id", Integer.parseInt(idExercicio.toString()));
        valores.put("treino_id", Integer.parseInt(idTreino.toString()));
        valores.put("peso", peso);

        db.insert("exercicios_has_treino", null, valores);
    }

    public List<ExercicioTreinoTO> consultar(){
        List<ExercicioTreinoTO> listExercicioTreinoTO = new ArrayList<>();
        List<String> listCodTreino = new ArrayList<>();

        String[] colunas = new String[]{"exercicios_id","treino_id", "peso"};
        Cursor cursor = db. query("exercicios_has_treino", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                ExercicioTreinoTO exercicioTreinoTO = new ExercicioTreinoTO();
                exercicioTreinoTO.setCodExercicioTO(cursor.getString(0));
                exercicioTreinoTO.setCodTreinoAluno(cursor.getString(1));
                exercicioTreinoTO.setPeso(cursor.getString(2));

                listExercicioTreinoTO.add(exercicioTreinoTO);
            }while (cursor.moveToNext());
        }
        return listExercicioTreinoTO;
    }

    public void atualizarPeso(Long codTreino, Long codExercicio, String peso){
        ContentValues valores = new ContentValues();
        valores.put("peso", peso);

        db.update("exercicios_has_treino", valores, "exercicios_id = ? and treino_id = ?", new String[]{""+codExercicio, ""+codTreino});
    }
}
