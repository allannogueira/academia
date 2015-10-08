package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class AcademiaActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia);
       /* getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);*/

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
            case 0 : Toast.makeText(this,"teste",Toast.LENGTH_LONG).show();
                break;
            case 1 :
                Intent secondActivity = new Intent(this, MedidasActivity.class);
                startActivity(secondActivity);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void treinosView(View view){
        Intent intent = new Intent(this, TreinosActivity.class);
        startActivity(intent);

    }

    public void dietasView(View view){
        Intent intent = new Intent(this, DietasActivity.class);
        startActivity(intent);

    }

    public void atividadesView(View view){
        Intent intent = new Intent(this, AtividadesActivity.class);
        startActivity(intent);

    }

    public void graficosView(View view){
        Intent intent = new Intent(this, GraficosActivity.class);
        startActivity(intent);

    }

    public void mapa(View view){
        Intent intent = new Intent(this, GPSActivity.class);
        startActivity(intent);

    }
}
