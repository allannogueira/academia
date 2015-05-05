package unip.com.br.View;

import android.app.ListActivity;
import android.drm.DrmStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unip.com.br.View.R;

public class GraficosView extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> listaGrafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_graficos);

        String[] de ={"nomeGrafico", "dscGrafico"};
        int[] para ={R.id.nomeGrafico, R.id.dscGrafico};

        SimpleAdapter adapter = new SimpleAdapter(this, listarGraficos(),R.layout.activity_graficos,de,para);

        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_graficos_view, menu);
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

    public List<Map<String, Object>> listarGraficos(){
        listaGrafico = new ArrayList<Map<String,Object>>();

        Map<String, Object> item;

        item = new HashMap<String, Object>();
        item.put("nomeGrafico","Crescimento Muscular");
        item.put("dscGrafico","Gráfico demonstrativo de crescimento muscular");
        listaGrafico.add(item);

        item = new HashMap<String, Object>();
        item.put("nomeGrafico", "Queima de Calorias");
        item.put("dscGrafico","Gráfico demonstrativo de queima de calorias");
        listaGrafico.add(item);

        item = new HashMap<String, Object>();
        item.put("nomeGrafico","Distância percorrida");
        item.put("dscGrafico","Gráfico demonstrativo de distância percorrida");
        listaGrafico.add(item);

        item = new HashMap<String, Object>();
        item.put("nomeGrafico","Redução de Peso");
        item.put("dscGrafico","Gráfico demonstrativo de perda de peso");
        listaGrafico.add(item);

        return listaGrafico;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Map<String, Object> map = listaGrafico.get(position);
        String grafico = (String) map.get("nomeGrafico");
        String msg = "Gráfico selecionada: " + grafico;

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
