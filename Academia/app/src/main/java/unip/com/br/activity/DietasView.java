package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
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

public class DietasView extends ActionBarActivity {

    List<Map<String, String>> dados = new ArrayList<>();
    List<String> titulo = new ArrayList<>();
    List<String> subtitulo = new ArrayList<>();
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        lista = (ListView)findViewById(R.id.listViewDietas);

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
                Intent intent = new Intent(view.getContext(),DescricaoDieta.class);
                Bundle param = new Bundle();

                param.putString("dietaSelecionado",String.valueOf(lista.getItemAtPosition(position)));

                intent.putExtras(param);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dietas_view, menu);
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

        titulo = new ArrayList<>();
        subtitulo = new ArrayList<>();

        titulo.add("Aumento de Massa Muscular");
        titulo.add("Queima de Gordura");
        titulo.add("Definição Muscular");
        titulo.add("Aumento de Massa Muscular");
        titulo.add("Queima de Gordura");
        titulo.add("Definição Muscular");

        subtitulo.add("Arroz integral, Peito de Frango, Frutas ...");
        subtitulo.add("Arroz integral, Peito de Perú, Frutas ...");
        subtitulo.add("Arroz integral, Queijo, Frutas ...");
        subtitulo.add("Arroz integral, Peito de Frango, Proteinas ...");
        subtitulo.add("Arroz integral, Peito de Perú, Fibras ...");
        subtitulo.add("Arroz integral, Queijo, Carboidratos ...");

        for(int index =0; index<titulo.size(); index++) {
            Map<String, String> linha = new HashMap<>();

            linha.put("Titulo", titulo.get(index));
            linha.put("Subtitulo", subtitulo.get(index));
            dados.add(linha);

        }
    }
}
