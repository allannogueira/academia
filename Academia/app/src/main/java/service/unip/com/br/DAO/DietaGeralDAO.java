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
import service.unip.com.br.TO.DietaAlunoTO;
import service.unip.com.br.TO.DietaGeralTO;

/**
 * Created by Cleber on 06/11/2015.
 */
public class DietaGeralDAO {

    private SQLiteDatabase db;

    public DietaGeralDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(DietaGeralTO dietaGeralTO){
        ContentValues valores = new ContentValues();
        valores.put("nome", dietaGeralTO.getNmeDieta());
        valores.put("finalidade", dietaGeralTO.getFinalidade());

        db.insert("dietaGeral", null, valores);
    }

    public List<DietaGeralTO> consultar(){
        List<DietaGeralTO> listaDietas = new ArrayList<DietaGeralTO>();
        String[] colunas = new String[]{"_id","nome", "finalidade"};
        Cursor cursor = db. query("dietaGeral", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                DietaGeralTO a = new DietaGeralTO();
                a.setCodDieta(cursor.getLong(0));
                a.setNmeDieta(cursor.getString(1));
                a.setFinalidade(cursor.getString(2));

                listaDietas.add(a);
            }while (cursor.moveToNext());
        }
        return listaDietas;
    }

    public List<DietaGeralTO> consultarDietaGeral(){
        List<DietaGeralTO> listaDietas = new ArrayList<DietaGeralTO>();
        List<DietaAlimentoTO> listaDietaAlimentoTO = new ArrayList<DietaAlimentoTO>();
        List<AlimentoTO> listaAlimentoTO = new ArrayList<AlimentoTO>();

        String[] colunas = new String[]{"_id","nome", "finalidade"};
        Cursor cursor = db. query("dietaGeral", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                DietaGeralTO dietaGeralTO = new DietaGeralTO();
                dietaGeralTO.setCodDieta(cursor.getLong(0));
                dietaGeralTO.setNmeDieta(cursor.getString(1));
                dietaGeralTO.setFinalidade(cursor.getString(2));

                listaDietas.add(dietaGeralTO);

            }while (cursor.moveToNext());

            for(DietaGeralTO dietaGeralTO : listaDietas){

                String[] colunasII = new String[]{"dieta_id","alimentos_id"};
                Cursor cursorII = db. query("dieta_has_alimentos", colunasII, "dieta_id=?", new String[]{""+dietaGeralTO.getCodDieta()}, null,null, null );

                if(cursorII.getCount() > 0) {
                    cursorII.moveToFirst();

                    do {
                        DietaAlimentoTO a = new DietaAlimentoTO();
                        a.setCodDietaGeralTO(cursorII.getLong(0));
                        a.setCodAlimentoTO(cursorII.getLong(1));

                        listaDietaAlimentoTO.add(a);
                    } while (cursor.moveToNext());

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
                }
                dietaGeralTO.setListaAlimentoTO(listaAlimentoTO);
            }
        }
        return listaDietas;
    }
}
