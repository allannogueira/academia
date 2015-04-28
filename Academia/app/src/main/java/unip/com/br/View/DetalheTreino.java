package unip.com.br.View;

import android.app.ListActivity;
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

public class DetalheTreino extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> listDetalheTreino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] de = {"exercicio", "serie", "ultimoPeso"};
        int[] para = {R.id.nomeExercicio, R.id.numSerie, R.id.ultimoPeso};

        SimpleAdapter adapter = new SimpleAdapter(this, listarDetalheTreino(),R.layout.activity_detalhe_treino,de,para);

        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);
    }


    private List<Map<String, Object>> listarDetalheTreino(){
        listDetalheTreino = new ArrayList<Map<String,Object>>();

        Map<String, Object> item;

        item = new HashMap<String, Object>();
        item.put("exercicio", "Supino Reto");
        item.put("serie", "Série: 3 repetições de 15 vezes");
        item.put("ultimoPeso", "Último peso: 15Kg");
        listDetalheTreino.add(item);

        item = new HashMap<String, Object>();
        item.put("exercicio", "Supino Inclinado");
        item.put("serie", "Série: 3 repetições de 15 vezes");
        item.put("ultimoPeso", "Último peso: 10Kg");
        listDetalheTreino.add(item);

        item = new HashMap<String, Object>();
        item.put("exercicio", "Supino Declinado");
        item.put("serie", "Série: 3 repetições de 15 vezes");
        item.put("ultimoPeso", "Último peso: 10Kg");
        listDetalheTreino.add(item);

        item = new HashMap<String, Object>();
        item.put("exercicio", "Pack Deck");
        item.put("serie", "Série: 3 repetições de 10 vezes");
        item.put("ultimoPeso", "Último peso: 15Kg");
        listDetalheTreino.add(item);

        return listDetalheTreino;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Map<String, Object> map = listDetalheTreino.get(position);
        String treino = (String) map.get("treino");
        String msg = "Treino selecionado: " + treino;

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
