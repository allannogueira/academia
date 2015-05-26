package unip.com.br.View;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unip.com.br.View.R;

public class DescricaoDieta extends ActionBarActivity {

    List<Map<String, String>> dadosDesjejum = new ArrayList<>();
    List<Map<String, String>> dadosAlmoco = new ArrayList<>();
    List<Map<String, String>> dadosLanche = new ArrayList<>();
    List<Map<String, String>> dadosJantar = new ArrayList<>();
    List<Map<String, String>> dadosCeia = new ArrayList<>();
    List<String> quantidade = new ArrayList<>();
    List<String> alimento = new ArrayList<>();
    private ListView listaDesjejum;
    private ListView listaAlmoco;
    private ListView listaLanche;
    private ListView listaJantar;
    private ListView listaCeia;
    String parametro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_dieta);

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        if(param!=null)
        {
            parametro =param.getString("dietaSelecionado");
        }

        listaDesjejum = (ListView)findViewById(R.id.listaDesjejum);
        listaAlmoco = (ListView)findViewById(R.id.listaAlmoco);
        listaLanche = (ListView)findViewById(R.id.listaLanche);
        listaJantar = (ListView)findViewById(R.id.listaJantar);
        listaCeia = (ListView)findViewById(R.id.listaCeia);

        recuperarDados();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dadosCeia,
                android.R.layout.simple_list_item_2,
                new String[] {"Titulo", "Subtitulo"},
                new int[] {android.R.id.text1, android.R.id.text2});

        listaDesjejum.setAdapter(adapter);
        listaAlmoco.setAdapter(adapter);
        listaLanche.setAdapter(adapter);
        listaJantar.setAdapter(adapter);
        listaCeia.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_descricao_dieta, menu);
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

    public void recuperarDados(){

        quantidade = new ArrayList<>();
        alimento = new ArrayList<>();


        quantidade.add("1 un");
        quantidade.add("100 g");
        quantidade.add("1 fatia");
        quantidade.add("1 copo");


        alimento.add("Maça");
        alimento.add("Aveia");
        alimento.add("Pão integral com Requeijão");
        alimento.add("Leite desnatado");

        for(int index =0; index<alimento.size(); index++) {
            Map<String, String> linha = new HashMap<>();

            linha.put("Titulo", quantidade.get(index) + " " + alimento.get(index));
            dadosDesjejum.add(linha);
            dadosAlmoco.add(linha);
            dadosLanche.add(linha);
            dadosJantar.add(linha);
            dadosCeia.add(linha);
        }
    }
}
