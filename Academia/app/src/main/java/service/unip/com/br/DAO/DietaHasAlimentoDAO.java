package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlimentoTO;
import service.unip.com.br.TO.DietaAlimentoTO;

/**
 * Created by Cleber on 06/11/2015.
 */
public class DietaHasAlimentoDAO {

    private SQLiteDatabase db;

    public DietaHasAlimentoDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(DietaAlimentoTO dietaAlimentoTO){
        ContentValues valores = new ContentValues();
        valores.put("dieta_id", dietaAlimentoTO.getCodDietaGeralTO());
        valores.put("alimentos_id", dietaAlimentoTO.getCodAlimentoTO());

        db.insert("dieta_has_alimentos", null, valores);
    }

    public List<DietaAlimentoTO> consultar(){
        List<DietaAlimentoTO> listaDietaAlimentoTO = new ArrayList<DietaAlimentoTO>();
        String[] colunas = new String[]{"dieta_id","alimentos_id"};
        Cursor cursor = db. query("dieta_has_alimentos", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                DietaAlimentoTO a = new DietaAlimentoTO();
                a.setCodDietaGeralTO(cursor.getLong(0));
                a.setCodAlimentoTO(cursor.getLong(1));

                listaDietaAlimentoTO.add(a);
            }while (cursor.moveToNext());
        }
        return listaDietaAlimentoTO;
    }
}
