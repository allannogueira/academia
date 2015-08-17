package service.unip.com.br.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cleber on 15/04/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "Workout";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context){
        super (context, BANCO_DADOS, null, VERSAO);
    }

      //criação de tabelas deve ser realizadas no método onCreate
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE aluno (_id INTEGER PRIMARY KEY," +
        " nome TEXT, data_nasc DATE, FOREING KEY (medidas_id) REFERENCES medida(_id));");

        db.execSQL("CREATE TABLE medida (_id INTEGER PRIMARY KEY, altura DOUBLE);");
    }

    //alterações de tabelas deve ser realizadas no método onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

    }


}
