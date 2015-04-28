package unip.com.br.View;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Treinos extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> listTreinos;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        String[] de = {"imagem", "treino", "dscTreino"};
        int[] para = {R.id.tipoTreino, R.id.nomeTreino, R.id.dscTreino};

        SimpleAdapter adapter = new SimpleAdapter(this, listarTreinos(),R.layout.activity_treinos,de,para);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_academia, menu);
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

    private List<Map<String, Object>> listarTreinos(){
        listTreinos = new ArrayList<Map<String,Object>>();

        Map<String, Object> item;

        item = new HashMap<String, Object>();
        item.put("imagem", R.drawable.logo);
        item.put("treino", "Treino A");
        item.put("dscTreino", "Supino reto, Supino inclinado, Pack Deck ...");
        listTreinos.add(item);

        item = new HashMap<String, Object>();
        item.put("imagem", R.drawable.logo);
        item.put("treino", "Treino B");
        item.put("dscTreino", "Remada unilateral, Puxada trás, Remada ...");
        listTreinos.add(item);

        item = new HashMap<String, Object>();
        item.put("imagem", R.drawable.logo);
        item.put("treino", "Treino C");
        item.put("dscTreino", "Leg press 45,  Extensora, Flexora ...");
        listTreinos.add(item);

        return listTreinos;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Map<String, Object> map = listTreinos.get(position);
        String treino = (String) map.get("treino");
        String msg = "Treino selecionado: " + treino;

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DetalheTreino.class));
    }
}
