package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.unip.com.br.DAO.ExercicioDAO;
import service.unip.com.br.DAO.ExercicioHasTreinoDAO;
import service.unip.com.br.DAO.TreinoDAO;
import service.unip.com.br.TO.ExercicioTO;
import service.unip.com.br.TO.ExercicioTreinoTO;
import service.unip.com.br.TO.TreinoAlunoTO;

import unip.com.br.R;


public class TreinosActivity extends FragmentActivity{

    List<Map<String, String>> dados = new ArrayList<>();
    List<String> titulo = new ArrayList<>();
    List<String> subtitulo = new ArrayList<>();
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinos);
        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));
         lista = (ListView)findViewById(R.id.listViewTreinos);

        recuperaDados();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dados,
                android.R.layout.simple_list_item_2,
                new String[] {"Titulo", "Subtitulo"},
                new int[] {android.R.id.text1, android.R.id.text2});
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(),DetalheTreinoActivity.class);
                Bundle param = new Bundle();

                String campoSelecionado = String.valueOf(lista.getItemAtPosition(position));
                campoSelecionado = campoSelecionado.substring(campoSelecionado.length() - 2, campoSelecionado.length() - 1);

                param.putString("campoSelecionado", campoSelecionado);

                intent.putExtras(param);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_academia, menu);

        MenuItem m1 = menu.add(0,0,0, "Medida");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setIcon(R.drawable.medida_icone);

        MenuItem m2 = menu.add(0,1,1, "Perfil");
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m2.setIcon(R.drawable.perfil_icone);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                Intent firstActivity = new Intent(this, AcademiaActivity.class);
                startActivity(firstActivity);
                break;
            case 0 :
                Intent secondActivity = new Intent(this, MedidasActivity.class);
                startActivity(secondActivity);
                break;
            case 1 :
                Intent thirdActivity = new Intent(this, PerfilActivity.class);
                startActivity(thirdActivity);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

     public void recuperaDados(){

        titulo.add("Treino A");
        titulo.add("Treino B");
        titulo.add("Treino C");

        subtitulo.add("Peito, Trícipes e aeróbica");
        subtitulo.add("Costas, Bícipes e aeróbica");
        subtitulo.add("Perna, Ombro e aeróbica");

        for(int index =0; index<titulo.size(); index++) {
            Map<String, String> linha = new HashMap<>();

            linha.put("Titulo", titulo.get(index));
            linha.put("Subtitulo", subtitulo.get(index));
            dados.add(linha);

        }
    }

    public void geraDados(View v){
        inserirDadosTreino();
    }

    private void inserirDadosTreino(){
        TreinoAlunoTO treinoA = new TreinoAlunoTO();

        treinoA.setNmeTreino("A");
        treinoA.setDatCadastro("01/11/2015");
        treinoA.setDataInicio("09/11/2015");
        treinoA.setSerie("3x15");

        TreinoAlunoTO treinoB = new TreinoAlunoTO();

        treinoB.setNmeTreino("B");
        treinoB.setDatCadastro("01/11/2015");
        treinoB.setDataInicio("09/11/2015");
        treinoB.setSerie("4x10");

        TreinoAlunoTO treinoC = new TreinoAlunoTO();

        treinoC.setNmeTreino("C");
        treinoC.setDatCadastro("01/11/2015");
        treinoC.setDataInicio("09/11/2015");
        treinoC.setSerie("5x8");

        TreinoDAO treinoDAO = new TreinoDAO(TreinosActivity.this);

        treinoDAO.inserir(treinoA);
        treinoDAO.inserir(treinoB);
        treinoDAO.inserir(treinoC);

        List<TreinoAlunoTO> lista = treinoDAO.consultar();

        ExercicioDAO exercicioDAO = new ExercicioDAO(TreinosActivity.this);

        ExercicioTO exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Supino Reto");
        exercicio.setDscDetalhes("Treino de peito");
        exercicio.setFinalidade("Peito");
        exercicio.setPeso("20Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Supino Inclinado");
        exercicio.setDscDetalhes("Treino de peito");
        exercicio.setFinalidade("Peito");
        exercicio.setPeso("20Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Crucifixo Reto");
        exercicio.setDscDetalhes("Treino de peito");
        exercicio.setFinalidade("Peito");
        exercicio.setPeso("20Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Pull over");
        exercicio.setDscDetalhes("Treino de peito");
        exercicio.setFinalidade("Peito");
        exercicio.setPeso("15Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Tricpis Testa");
        exercicio.setDscDetalhes("Treino de tricipes");
        exercicio.setFinalidade("Tricipes");
        exercicio.setPeso("10Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Tricpis Maquina");
        exercicio.setDscDetalhes("Treino de tricipes");
        exercicio.setFinalidade("Tricipes");
        exercicio.setPeso("10Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Tricpis Corda");
        exercicio.setDscDetalhes("Treino de tricipes");
        exercicio.setFinalidade("Tricipes");
        exercicio.setPeso("17Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Remada");
        exercicio.setDscDetalhes("Treino de costas");
        exercicio.setFinalidade("Costas");
        exercicio.setPeso("25Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Pa invertida");
        exercicio.setDscDetalhes("Treino de costas");
        exercicio.setFinalidade("Costas");
        exercicio.setPeso("35Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Pegada chifrinho");
        exercicio.setDscDetalhes("Treino de costas");
        exercicio.setFinalidade("Costas");
        exercicio.setPeso("25Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Rosca Martelo");
        exercicio.setDscDetalhes("Bicepis");
        exercicio.setFinalidade("Bicepis");
        exercicio.setPeso("15Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Rosca Direta");
        exercicio.setDscDetalhes("Bicepis");
        exercicio.setFinalidade("Bicepis");
        exercicio.setPeso("10Kg");
        exercicioDAO.inserir(exercicio);

        exercicio = new ExercicioTO();
        exercicio.setNmeExercicio("Rosca 21");
        exercicio.setDscDetalhes("Bicepis");
        exercicio.setFinalidade("Bicepis");
        exercicio.setPeso("7Kg");
        exercicioDAO.inserir(exercicio);

        List<ExercicioTO> listaEx = exercicioDAO.consultar();

        ExercicioHasTreinoDAO et = new ExercicioHasTreinoDAO(TreinosActivity.this);

       for(TreinoAlunoTO treino :lista){

            for(ExercicioTO ex : listaEx){
                if(treino.getNmeTreino().equals("A")){
                    if(ex.getFinalidade().equals("Peito") || ex.getFinalidade().equals("Tricipes")){
                        et.inserir(ex.getCodExercicio(), treino.getCodTreinoAluno(), ex.getPeso());
                    }
                }

                if(treino.getNmeTreino().equals("B")){
                    if(ex.getFinalidade().equals("Costas") || ex.getFinalidade().equals("Bicepis")){
                        et.inserir(ex.getCodExercicio(), treino.getCodTreinoAluno(), ex.getPeso());
                    }
                }
            }
        }

        List<ExercicioTreinoTO> listaExTre = et.consultar();
    }
}
