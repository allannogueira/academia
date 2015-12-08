package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;
import service.unip.com.br.TO.DietaAlunoTO;

/**
 * Created by Cleber on 31/10/2015.
 */
public class DietaDAO {
    private SQLiteDatabase db;

    public DietaDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(DietaAlunoTO dietaAluno){
        ContentValues valores = new ContentValues();
        valores.put("data_inicio", dietaAluno.getDataInicio());
        valores.put("data_fim", dietaAluno.getDataFim());
        valores.put("dieta_id", dietaAluno.getDietaGeralTO().getCodDieta());

        db.insert("dieta", null, valores);
    }

    public void atualizar(DietaAlunoTO dietaAluno){
        ContentValues valores = new ContentValues();
        valores.put("data_inicio", dietaAluno.getDataInicio());
        valores.put("data_fim", dietaAluno.getDataFim());
        valores.put("dieta_id", dietaAluno.getDietaGeralTO().getCodDieta());

        db.update("dieta", valores, "_id = ?", new String[]{"" + dietaAluno.getCodDietaAluno()});

    }

    public void deletar(DietaAlunoTO dietaAluno){
        db.delete("dieta", "_id = " + dietaAluno.getCodDietaAluno(), null);

    }

    public List<DietaAlunoTO> consultar(DietaAlunoTO dietaAluno){
        List<DietaAlunoTO> listaDietas = new ArrayList<DietaAlunoTO>();
        String[] colunas = new String[]{"_id","data_inicio", "data_fim", "dieta_id"};
        Cursor cursor = db. query("dieta", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                DietaAlunoTO a = new DietaAlunoTO();
                a.setCodDietaAluno(cursor.getLong(0));
                a.setDataInicio(cursor.getString(1));
                a.setDataFim(cursor.getString(2));
                a.getDietaGeralTO().setCodDieta(cursor.getLong(3));

                listaDietas.add(a);
            }while (cursor.moveToNext());
        }
        return listaDietas;
    }
}
