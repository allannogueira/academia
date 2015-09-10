package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetalheTreinoActivity extends ActionBarActivity {

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
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

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
