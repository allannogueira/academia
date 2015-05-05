package unip.com.br.View;


import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

public class DetalheDietaView extends ActionBarActivity {

    List<Map<String, String>> dados = new ArrayList<>();
    List<String> exercicio = new ArrayList<>();
    List<String> serie = new ArrayList<>();
    List<String> peso = new ArrayList<>();
    private ListView lista;
    String parametro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_dieta);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        if(param!=null)
        {
            parametro =param.getString("dietaSelecionado");
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
                Intent intent = new Intent(view.getContext(),DetalheTreino.class);
                Bundle param = new Bundle();

                param.putString("campoSelecionado",String.valueOf(lista.getItemAtPosition(position)));

                intent.putExtras(param);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe_dieta_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void recuperaDados(){

        exercicio = new ArrayList<>();
        serie = new ArrayList<>();
        peso = new ArrayList<>();


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

        for(int index =0; index<exercicio.size(); index++) {
            Map<String, String> linha = new HashMap<>();

            linha.put("Titulo", exercicio.get(index));
            linha.put("Subtitulo", serie.get(index) + "\n" + peso.get(index));
            dados.add(linha);

        }
    }
}
