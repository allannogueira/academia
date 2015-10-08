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

public class DetalheTreinoActivity extends FragmentActivity {

    List<Map<String, String>> dados = new ArrayList<>();
    List<String> exercicio = new ArrayList<>();
    List<String> serie = new ArrayList<>();
    List<String> peso = new ArrayList<>();
    private ListView lista;
    String parametro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_treino);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        if(param!=null)
        {
            parametro =param.getString("campoSelecionado");
        }


        lista = (ListView)findViewById(R.id.listViewDetalheTreino);

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

                param.putString("campoSelecionado",String.valueOf(lista.getItemAtPosition(position)));

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

        exercicio = new ArrayList<>();
        serie = new ArrayList<>();
        peso = new ArrayList<>();

        if(parametro.substring(parametro.length() - 2, parametro.length() - 1).equals("A")){
            exercicio.add("Supino Reto");
            exercicio.add("Supino Inclinado");
            exercicio.add("Supino Declinado");
            exercicio.add("Pack Deck");

            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");

            peso.add("Peso: 30Kg");
            peso.add("Peso: 20Kg");
            peso.add("Peso: 25Kg");
            peso.add("Peso: 35Kg");

        }else if(parametro.substring(parametro.length() - 2, parametro.length() - 1).equals("B")){
            exercicio.add("Remada Alta");
            exercicio.add("Remada Unilateral");
            exercicio.add("Puxada Pá");
            exercicio.add("Puxada Frente");

            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");

            peso.add("Peso: 30Kg");
            peso.add("Peso: 20Kg");
            peso.add("Peso: 25Kg");
            peso.add("Peso: 35Kg");
        }else if(parametro.substring(parametro.length() - 2, parametro.length() - 1).equals("C")){
            exercicio.add("Leg Press 45º");
            exercicio.add("Extensora");
            exercicio.add("Flexora");
            exercicio.add("Levantamento Terra");
            exercicio.add("Desenvolvimeto Unilatera");
            exercicio.add("Desenvolvimento Frontal");

            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 3x15 ");
            serie.add("Série: 4x10 ");
            serie.add("Série: 4x10 ");

            peso.add("Peso: 30Kg");
            peso.add("Peso: 20Kg");
            peso.add("Peso: 25Kg");
            peso.add("Peso: 35Kg");
            peso.add("Peso: 5Kg");
            peso.add("Peso: 5Kg");
        }



        for(int index =0; index<exercicio.size(); index++) {
            Map<String, String> linha = new HashMap<>();

            linha.put("Titulo", exercicio.get(index));
            linha.put("Subtitulo", serie.get(index) + "\n" + peso.get(index));
            dados.add(linha);

        }
    }
}
