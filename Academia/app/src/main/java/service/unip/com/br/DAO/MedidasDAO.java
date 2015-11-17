package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;
import service.unip.com.br.TO.MedidasAlunoTO;

/**
 * Created by Cleber on 31/10/2015.
 */
public class MedidasDAO {
    private SQLiteDatabase db;

    public MedidasDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(MedidasAlunoTO medida){
       ContentValues valores = new ContentValues();
       /*  valores.put("nome", medida);
        valores.put("cpf", medida);
        valores.put("rg", medida);
        valores.put("email", medida);*/

        db.insert("medida", null, valores);
    }

    public void atualizar(MedidasAlunoTO medida){
        ContentValues valores = new ContentValues();
       /*  valores.put("nome", medida);
        valores.put("cpf", medida);
        valores.put("rg", medida);
        valores.put("email", medida);*/

        db.update("medida", valores, "_id = ?", new String[]{""+medida.getCodMedidasAlunoTO()});

    }

    public void deletar(MedidasAlunoTO medida){
        db.delete("medida", "_id = "+medida.getCodMedidasAlunoTO(), null);

    }

    public List<AlunoTO> consultar(MedidasAlunoTO medida){
        List<AlunoTO> listaAlunos = new ArrayList<AlunoTO>();
        /*String[] colunas = new String[]{"_id","nome", "cpf", "rg", "email", "objetivo", "medidas_id", "treino_id", "dieta_id", "endereco_id"};
        Cursor cursor = db. query("aluno", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                AlunoTO a = new AlunoTO();
                a.setCodAluno(cursor.getLong(0));
                a.setNmeAluno(cursor.getString(1));
                a.setNumCpf(cursor.getString(2));
                a.setNumRg(cursor.getString(3));
                a.setDscEmail(cursor.getString(4));

                listaAlunos.add(a);
            }while (cursor.moveToNext());
        }*/
        return listaAlunos;
    }
}
