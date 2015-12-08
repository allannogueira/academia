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
import service.unip.com.br.TO.DietaGeralTO;

/**
 * Created by Cleber on 06/11/2015.
 */
public class AlimentosDAO {

    private SQLiteDatabase db;

    public AlimentosDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(AlimentoTO alimentoTO){
        ContentValues valores = new ContentValues();
        valores.put("nome", alimentoTO.getNmeAlimento());
        valores.put("caracteristica", alimentoTO.getDscCaracteriscia());
        valores.put("descricao_nutricional", alimentoTO.getDscNutricional());

        db.insert("alimentos", null, valores);
    }

    public List<AlimentoTO> consultar(){
        List<AlimentoTO> listaAlimentoTO = new ArrayList<AlimentoTO>();
        String[] colunas = new String[]{"_id","nome", "caracteristica", "descricao_nutricional"};
        Cursor cursor = db. query("alimentos", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                AlimentoTO a = new AlimentoTO();
                a.setCodAlimento(cursor.getLong(0));
                a.setNmeAlimento(cursor.getString(1));
                a.setDscCaracteriscia(cursor.getString(2));
                a.setDscNutricional(cursor.getString(3));

                listaAlimentoTO.add(a);
            }while (cursor.moveToNext());
        }
        return listaAlimentoTO;
    }

    public List<AlimentoTO> consultarAlimentoDieta(Long codDieta){
        List<DietaAlimentoTO> listaDietaAlimentoTO = new ArrayList<DietaAlimentoTO>();
        List<AlimentoTO> listaAlimentoTO = new ArrayList<AlimentoTO>();

        String[] colunas = new String[]{"dieta_id","alimentos_id"};
        Cursor cursor = db. query("dieta_has_alimentos", colunas, "dieta_id=?", new String[]{""+codDieta}, null,null, null );

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                DietaAlimentoTO a = new DietaAlimentoTO();
                a.setCodDietaGeralTO(cursor.getLong(0));
                a.setCodAlimentoTO(cursor.getLong(1));

                listaDietaAlimentoTO.add(a);
            } while (cursor.moveToNext());
        }

        for (DietaAlimentoTO dietaAlimentoTO : listaDietaAlimentoTO) {

            String[] colunasIII = new String[]{"_id", "nome", "caracteristica", "descricao_nutricional"};
            Cursor cursorIII = db.query("alimentos", colunasIII, "_id=?", new String[]{""+dietaAlimentoTO.getCodAlimentoTO()}, null, null, null);

            if (cursorIII.getCount() > 0) {
                cursorIII.moveToFirst();

                do {
                    AlimentoTO a = new AlimentoTO();
                    a.setCodAlimento(cursorIII.getLong(0));
                    a.setNmeAlimento(cursorIII.getString(1));
                    a.setDscCaracteriscia(cursorIII.getString(2));
                    a.setDscNutricional(cursorIII.getString(3));

                    listaAlimentoTO.add(a);
                } while (cursor.moveToNext());
            }
        }

        return listaAlimentoTO;
    }

}
