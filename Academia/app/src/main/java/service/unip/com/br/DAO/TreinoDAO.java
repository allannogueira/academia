package service.unip.com.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import service.unip.com.br.Helper.DatabaseHelper;
import service.unip.com.br.TO.AlunoTO;
import service.unip.com.br.TO.ExercicioTO;
import service.unip.com.br.TO.ExercicioTreinoTO;
import service.unip.com.br.TO.TreinoAlunoTO;

/**
 * Created by Cleber on 31/10/2015.
 */
public class TreinoDAO {
    private SQLiteDatabase db;

    public TreinoDAO(Context context) {
        DatabaseHelper dataBase = new DatabaseHelper(context);

        db = dataBase.getWritableDatabase();
    }

    public void inserir(TreinoAlunoTO treino) {
        ContentValues valores = new ContentValues();
        valores.put("nome", treino.getNmeTreino());
        valores.put("data_cadastro", treino.getDatCadastro());
        valores.put("data_inicio", treino.getDataInicio());
        valores.put("data_fim", treino.getDataFim());
        valores.put("serie", treino.getSerie());

        db.insert("treino", null, valores);
    }

    public void atualizar(TreinoAlunoTO treino) {
        ContentValues valores = new ContentValues();
        valores.put("nome", treino.getNmeTreino());
        valores.put("data_cadastro", treino.getDatCadastro());
        valores.put("data_inicio", treino.getDataInicio());
        valores.put("data_fim", treino.getDataFim());
        valores.put("serie", treino.getSerie());

        db.update("treino", valores, "_id = ?", new String[]{"" + treino.getCodTreinoAluno()});

    }

    public void deletar(TreinoAlunoTO treino) {
        db.delete("treino", "_id = " + treino.getCodTreinoAluno(), null);

    }

    public List<TreinoAlunoTO> consultar() {
        List<TreinoAlunoTO> listaTreinos = new ArrayList<TreinoAlunoTO>();
        String[] colunas = new String[]{"_id", "nome", "data_cadastro", "data_inicio", "data_fim", "serie"};
        Cursor cursor = db.query("treino", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                TreinoAlunoTO a = new TreinoAlunoTO();
                a.setCodTreinoAluno(cursor.getLong(0));
                a.setNmeTreino(cursor.getString(1));
                a.setDatCadastro(cursor.getString(2));
                a.setDataInicio(cursor.getString(3));
                a.setDataFim(cursor.getString(4));
                a.setSerie(cursor.getString(5));

                listaTreinos.add(a);
            } while (cursor.moveToNext());
        }
        return listaTreinos;
    }

    public TreinoAlunoTO consultarTreino(String nmeTreino) {
        TreinoAlunoTO treino = new TreinoAlunoTO();
        List<String> listaCodExercicios = new ArrayList<>();
        List<ExercicioTO> listaExercicio = new ArrayList<>();
        List<ExercicioTreinoTO> listaExercicioTreino = new ArrayList<>();
        String[] colunas = new String[]{"_id", "nome", "data_cadastro", "data_inicio", "data_fim", "serie"};
        Cursor cursor = db.query("treino", colunas, "nome=?", new String[]{nmeTreino}, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                treino.setCodTreinoAluno(cursor.getLong(0));
                treino.setNmeTreino(cursor.getString(1));
                treino.setDatCadastro(cursor.getString(2));
                treino.setDataInicio(cursor.getString(3));
                treino.setDataFim(cursor.getString(4));
                treino.setSerie(cursor.getString(5));

            } while (cursor.moveToNext());

            String[] colunasII = new String[]{"exercicios_id", "treino_id", "peso"};
            Cursor cursorII = db.query("exercicios_has_treino", colunasII, "treino_id = ?", new String[]{"" + treino.getCodTreinoAluno()}, null, null, null);

            if (cursorII.getCount() > 0) {
                cursorII.moveToFirst();
                do {
                    ExercicioTreinoTO exercicioTreinoTO = new ExercicioTreinoTO();
                    exercicioTreinoTO.setCodExercicioTO(cursorII.getString(0));
                    exercicioTreinoTO.setCodTreinoAluno(cursorII.getString(1));
                    exercicioTreinoTO.setPeso(cursorII.getString(2));
                    listaExercicioTreino.add(exercicioTreinoTO);

                } while (cursorII.moveToNext());

                String[] colunasIII = new String[]{"_id","nome", "ar_livre", "finalidade", "como_fazer"};

                for(ExercicioTreinoTO cod : listaExercicioTreino) {

                    Cursor cursorIII = db.query("exercicios", colunasIII, "_id=?", new String[]{cod.getCodExercicioTO()}, null, null, null);

                    if (cursorIII.getCount() > 0) {
                        cursorIII.moveToFirst();
                        do {
                            ExercicioTO exercicio = new ExercicioTO();

                            exercicio.setCodExercicio(Long.parseLong(cursorIII.getString(0)));
                            exercicio.setNmeExercicio(cursorIII.getString(1));
                            exercicio.setArLivre(cursorIII.getString(2));
                            exercicio.setFinalidade(cursorIII.getString(3));
                            exercicio.setDscDetalhes(cursorIII.getString(4));
                            exercicio.setPeso(cod.getPeso());

                            listaExercicio.add(exercicio);

                        } while (cursorIII.moveToNext());
                    }
                }
                treino.setListaExercicioTO(listaExercicio);
            }
        }

        return treino;
    }
}