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

public class DietasActivity extends FragmentActivity {

    List<Map<String, String>> dados = new ArrayList<>();
    List<String> titulo = new ArrayList<>();
    List<String> subtitulo = new ArrayList<>();
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

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
                Intent intent = new Intent(view.getContext(),DescricaoDietaActivity.class);
                Bundle param = new Bundle();

                param.putString("dietaSelecionado",String.valueOf(lista.getItemAtPosition(position)));

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
