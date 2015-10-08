package unip.com.br.activity;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
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

public class GraficosActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> listaGrafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_graficos);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

        String[] de ={"nomeGrafico", "dscGrafico"};
        int[] para ={R.id.nomeGrafico, R.id.dscGrafico};

        SimpleAdapter adapter = new SimpleAdapter(this, listarGraficos(),R.layout.activity_graficos,de,para);

        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);

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
