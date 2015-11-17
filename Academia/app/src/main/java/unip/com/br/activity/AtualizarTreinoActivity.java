package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import service.unip.com.br.DAO.ExercicioHasTreinoDAO;
import unip.com.br.R;

public class AtualizarTreinoActivity extends FragmentActivity {

    String parametro = null;
    TextView tituloActivity;
    TextView serie;
    String[] parametros;
    String[] paramSubtitulo;
    String[] paramSerie;
    EditText peso;
    Long codExercicio;
    Long codTreino;
    Bundle param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_treino);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

        Intent intent = getIntent();
        param = intent.getExtras();

        if(param!=null)
        {
            parametro =param.getString("nomeExercicio");
            codExercicio = param.getLong("codExercicio");
            codTreino = param.getLong("codTreino");
        }

        tituloActivity = (TextView) findViewById(R.id.textViewAtualizarTreino);
        serie = (TextView) findViewById(R.id.textViewSerie);
        peso = (EditText) findViewById(R.id.editPeso);

        parametros = parametro.split(",");
        paramSubtitulo = parametros[0].substring(18).split("\n");
        paramSerie = paramSubtitulo[0].split("x");

        tituloActivity.setText(parametros[1].substring(8, parametros[1].length() - 1));
        serie.setText(("Faltam " +paramSerie[0] + " séries de "+paramSerie[1]+" repetições").toString());
        peso.setText(paramSubtitulo[1].substring(6, paramSubtitulo[1].length() - 2));

    }

    public void reduzSerie(View v){
        int numSerie = Integer.parseInt(paramSerie[0]);

        if(numSerie > 0){
            paramSerie[0] = String.valueOf(numSerie -1);
        }

        serie.setText(("Faltam " + paramSerie[0] + " séries de " + paramSerie[1] + " repetições").toString());
    }

    public void atualiarPeso(View view){

        ExercicioHasTreinoDAO exercicioHasTreinoDAO = new ExercicioHasTreinoDAO(AtualizarTreinoActivity.this);

        exercicioHasTreinoDAO.atualizarPeso(codTreino, codExercicio, peso.getText().toString()+"Kg");

        Intent intent = new Intent(view.getContext(),DetalheTreinoActivity.class);
        Bundle parameter = new Bundle();

        parameter.putString("campoSelecionado", param.getString("campoSelecionado"));

        intent.putExtras(parameter);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_academia, menu);

        MenuItem m1 = menu.add(0, 0, 0, "Medida");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setIcon(R.drawable.medida_icone);

        MenuItem m2 = menu.add(0, 1, 1, "Perfil");
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

}
