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

/**
 * Created by Cleber on 06/11/2015.
 */
public class ArLivreDAO {

    private SQLiteDatabase db;

    public ArLivreDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(ExercicioArLivreTO arLivre){
        ContentValues valores = new ContentValues();
        valores.put("gordura_queimada", arLivre.getVlrCaloriasQueimada());
        valores.put("distancia_percorrida", arLivre.getDistanciaPercorrida());
        valores.put("aluno_id", arLivre.getAlunoTO().getCodAluno());

        db.insert("ar_livre", null, valores);
    }

    public void atualizar(ExercicioArLivreTO arLivre){
        ContentValues valores = new ContentValues();
        valores.put("gordura_queimada", arLivre.getVlrCaloriasQueimada());
        valores.put("distancia_percorrida", arLivre.getDistanciaPercorrida());
        valores.put("aluno_id", arLivre.getAlunoTO().getCodAluno());

        db.update("ar_livre", valores, "_id = ?", new String[]{""+arLivre.getCodExercicioArLivre()});

    }

    public void deletar(ExercicioArLivreTO arLivre){
        db.delete("ar_livre", "_id = "+arLivre.getCodExercicioArLivre(), null);

    }

    public List<ExercicioArLivreTO> consultar(){
        List<ExercicioArLivreTO> listaExercicios = new ArrayList<ExercicioArLivreTO>();
        String[] colunas = new String[]{"_id","gordura_queimada", "distancia_percorrida", "aluno_id"};
        Cursor cursor = db. query("ar_livre", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                ExercicioArLivreTO a = new ExercicioArLivreTO();
                AlunoTO aluno = new AlunoTO();
                a.setCodExercicioArLivre(cursor.getLong(0));
                a.setVlrCaloriasQueimada(cursor.getString(1));
                a.setDistanciaPercorrida(cursor.getString(2));
                aluno.setCodAluno(cursor.getLong(3));
                a.setAlunoTO(aluno);

                listaExercicios.add(a);
            }while (cursor.moveToNext());
        }
        return listaExercicios;
    }
}
