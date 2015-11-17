package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;

/**
 * Created by Cleber on 31/10/2015.
 */
public class AlunoDAO {
    private SQLiteDatabase db;

    public AlunoDAO(Context context){
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(AlunoTO aluno){
        ContentValues valores = new ContentValues();
        valores.put("nome", aluno.getNmeAluno());
        valores.put("cpf", aluno.getNumCpf());
        valores.put("rg", aluno.getNumRg());
        valores.put("email", aluno.getDscEmail());
        valores.put("objetivo", aluno.getObjTreino());
        valores.put("medidas_id", aluno.getMedidasAlunoTO().getCodMedidasAlunoTO());
        valores.put("treino_id", aluno.getTreinoAlunoTO().getCodTreinoAluno());
        valores.put("dieta_id", aluno.getDietaAlunoTO().getCodDietaAluno());
        valores.put("endereco_id", aluno.getEnderecoAluno().getCodEndereco());

        db.insert("aluno", null, valores);
    }

    public void atualizar(AlunoTO aluno){
        ContentValues valores = new ContentValues();
        valores.put("nome", aluno.getNmeAluno());
        valores.put("cpf", aluno.getNumCpf());
        valores.put("rg", aluno.getNumRg());
        valores.put("email", aluno.getDscEmail());
        valores.put("objetivo", aluno.getObjTreino());
        valores.put("medidas_id", aluno.getMedidasAlunoTO().getCodMedidasAlunoTO());
        valores.put("treino_id", aluno.getTreinoAlunoTO().getCodTreinoAluno());
        valores.put("dieta_id", aluno.getDietaAlunoTO().getCodDietaAluno());
        valores.put("endereco_id", aluno.getEnderecoAluno().getCodEndereco());

        db.update("aluno", valores, "_id = ?", new String[]{""+aluno.getCodAluno()});

    }

    public void deletar(AlunoTO aluno){
        db.delete("aluno", "_id = "+aluno.getCodAluno(), null);

    }

    public List<AlunoTO> consultar(AlunoTO aluno){
        List<AlunoTO> listaAlunos = new ArrayList<AlunoTO>();
        String[] colunas = new String[]{"_id","nome", "cpf", "rg", "email", "objetivo", "medidas_id", "treino_id", "dieta_id", "endereco_id"};
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
        }
        return listaAlunos;
    }
}
