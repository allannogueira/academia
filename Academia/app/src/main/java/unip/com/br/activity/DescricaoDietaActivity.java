package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
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

import service.unip.com.br.DAO.AlimentosDAO;
import service.unip.com.br.TO.AlimentoTO;
import unip.com.br.R;

public class DescricaoDietaActivity extends FragmentActivity {

    List<Map<String, String>> dadosDesjejum = new ArrayList<>();
    List<Map<String, String>> dadosAlmoco = new ArrayList<>();
    List<Map<String, String>> dadosLanche = new ArrayList<>();
    List<Map<String, String>> dadosJantar = new ArrayList<>();
    List<Map<String, String>> dadosCeia = new ArrayList<>();
    List<String> descicao = new ArrayList<>();
    List<String> alimento = new ArrayList<>();
    private ListView listaDesjejum;
    private Long codDieta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_dieta);

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        if(param!=null)
        {
            codDieta = param.getLong("idDieta");
        }

        listaDesjejum = (ListView)findViewById(R.id.listaDesjejum);

        recuperarDados();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dadosDesjejum,
                android.R.layout.simple_list_item_2,
                new String[] {"Titulo", "Subtitulo"},
                new int[] {android.R.id.text1, android.R.id.text2});

        listaDesjejum.setAdapter(adapter);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));
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

    public void recuperarDados(){

        descicao = new ArrayList<>();
        alimento = new ArrayList<>();

        AlimentosDAO alimentosDAO = new AlimentosDAO(this);

        List<AlimentoTO> listaAlimento = alimentosDAO.consultarAlimentoDieta(codDieta);

        for (AlimentoTO alimentoTO : listaAlimento) {
            alimento.add(alimentoTO.getNmeAlimento());
            descicao.add(alimentoTO.getDscCaracteriscia());
        }

        /*quantidade.add("1 un");
        quantidade.add("100 g");
        quantidade.add("1 fatia");
        quantidade.add("1 copo");


        alimento.add("Maça");
        alimento.add("Aveia");
        alimento.add("Pão integral com Requeijão");
        alimento.add("Leite desnatado");*/

        for(int index =0; index<alimento.size(); index++) {
            Map<String, String> linha = new HashMap<>();

            linha.put("Titulo", alimento.get(index));
            linha.put("Subtitulo", descicao.get(index));
            dadosDesjejum.add(linha);
        }
    }
}
