package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import service.unip.com.br.TO.MedidasAlunoTO;
import unip.com.br.activity.R;

public class MedidasActivity extends FragmentActivity {

    private MedidasAlunoTO medida = new MedidasAlunoTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas);
       // getSupportActionBar().setCustomView(R.layout.actionbar);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

        medida.setAltura((EditText) findViewById(R.id.altura));
        medida.setPeso((EditText) findViewById(R.id.peso));
        medida.setQuadril((EditText) findViewById(R.id.quadril));
        medida.setAbdomen((EditText) findViewById(R.id.abdomen));
        medida.setBicipsDireito((EditText) findViewById(R.id.bicpesDireito));
        medida.setBicipsEsquerdo((EditText) findViewById(R.id.bicpesEsquerdo));
        medida.setTricepsDireito((EditText) findViewById(R.id.tricipesDireito));
        medida.setTricepsEsquerdo((EditText) findViewById(R.id.tricipesEsquerdo));
        medida.setCoxaDireita((EditText) findViewById(R.id.coxaDireita));
        medida.setCoxaEsquerda((EditText) findViewById(R.id.coxaEsquerda));
        medida.setPeitoralMaior((EditText) findViewById(R.id.peitoralMaior));
        medida.setPeitoralMenor((EditText) findViewById(R.id.peitoralMenor));
        medida.setPanturilhaDireita((EditText) findViewById(R.id.panturilhaDireita));
        medida.setPanturilhaEsquerda((EditText) findViewById(R.id.pantirilhaEsquerda));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_academia, menu);

        MenuItem m2 = menu.add(0,0,0, "Perfil");
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
                Intent perfilActivity = new Intent(this, PerfilActivity.class);
                startActivity(perfilActivity);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
