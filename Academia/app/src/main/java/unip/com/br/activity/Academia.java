package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Academia extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
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
    public void treinosView(View view){
        Intent intent = new Intent(this, Treinos.class);
        startActivity(intent);

    }

    public void dietasView(View view){
        Intent intent = new Intent(this, DietasView.class);
        startActivity(intent);

    }

    public void atividadesView(View view){
        Intent intent = new Intent(this, AtividadesView.class);
        startActivity(intent);

    }

    public void graficosView(View view){
        Intent intent = new Intent(this, GraficosView.class);
        startActivity(intent);

    }

    public void mapa(View view){
        Intent intent = new Intent(this, GPSActivity.class);
        startActivity(intent);

    }
}
