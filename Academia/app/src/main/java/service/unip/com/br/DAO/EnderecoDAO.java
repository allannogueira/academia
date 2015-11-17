package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;
import service.unip.com.br.TO.EnderecoTO;

/**
 * Created by Cleber on 31/10/2015.
 */
public class EnderecoDAO {
    private SQLiteDatabase db;

    public EnderecoDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(EnderecoTO endereco){
        ContentValues valores = new ContentValues();
        valores.put("rua", endereco.getDscRua());
        valores.put("numero", endereco.getDscNumero());
        valores.put("complemento", endereco.getDscComplemento());
        valores.put("cepbr_endereco", endereco.getCepBrEnderecoTO().getCodCep());
        valores.put("tipo_endereco_id", endereco.getTipoEnderecoTO().getCodTipoEnderecoTO());

        db.insert("endereco", null, valores);
    }

    public void atualizar(EnderecoTO endereco){
        ContentValues valores = new ContentValues();
        valores.put("rua", endereco.getDscRua());
        valores.put("numero", endereco.getDscNumero());
        valores.put("complemento", endereco.getDscComplemento());
        valores.put("cepbr_endereco", endereco.getCepBrEnderecoTO().getCodCep());
        valores.put("tipo_endereco_id", endereco.getTipoEnderecoTO().getCodTipoEnderecoTO());

        db.update("endereco", valores, "_id = ?", new String[]{""+endereco.getCodEndereco()});

    }

    public void deletar(EnderecoTO endereco){
        db.delete("endereco", "_id = "+endereco.getCodEndereco(), null);

    }

    public List<EnderecoTO> consultar(EnderecoTO endereco){
        List<EnderecoTO> listaEnderecos = new ArrayList<EnderecoTO>();
        String[] colunas = new String[]{"_id","rua", "numero", "complemento", "cepbr_endereco", "tipo_endereco_id"};
        Cursor cursor = db. query("endereco", colunas, null, null, null,null, null );

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                EnderecoTO a = new EnderecoTO();
                a.setCodEndereco(cursor.getLong(0));
                a.setDscRua(cursor.getString(1));
                a.setDscNumero(cursor.getString(2));
                a.setDscComplemento(cursor.getString(3));
                a.getCepBrEnderecoTO().setCodCep(cursor.getLong(4));
                a.getTipoEnderecoTO().setCodTipoEnderecoTO(cursor.getLong(5));

                listaEnderecos.add(a);
            }while (cursor.moveToNext());
        }
        return listaEnderecos;
    }
}
