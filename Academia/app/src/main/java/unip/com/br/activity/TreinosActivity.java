package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TreinosActivity extends ActionBarActivity{

    List<Map<String, String>> dados = new ArrayList<>();
    List<String> titulo = new ArrayList<>();
    List<String> subtitulo = new ArrayList<>();
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinos);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
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

                param.putString("campoSelecionado",String.valueOf(lista.getItemAtPosition(position)));

                intent.putExtras(param);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_academia, menu);
        return true;
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
}
