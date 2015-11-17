package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;

import java.util.List;

import de.greenrobot.event.EventBus;
import service.unip.com.br.DAO.AlimentosDAO;
import service.unip.com.br.DAO.DietaGeralDAO;
import service.unip.com.br.DAO.DietaHasAlimentoDAO;
import service.unip.com.br.TO.AlimentoTO;
import service.unip.com.br.TO.DietaAlimentoTO;
import service.unip.com.br.TO.DietaGeralTO;
import unip.com.br.R;
import unip.com.br.academia.ProfileFragment;
import unip.com.br.util.Pref;


public class AcademiaActivity extends FragmentActivity {

    private static final String SHOWING_SETTINGS_KEY = "Showing settings";
    private TextView txtPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia);
       /* getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);*/


        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("uniqueId", installation.getInstallationId());
        installation.saveInBackground();

        ParsePush.subscribeInBackground("all-games");


        EventBus.getDefault().register(this);

        txtPush = (TextView) findViewById(R.id.txtPush);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       super.onCreateOptionsMenu(menu);
       //getMenuInflater().inflate(R.menu.menu_academia, menu);

        MenuItem m1 = menu.add(0, 0, 0, "Medida");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setIcon(R.drawable.medida_icone);

        MenuItem m2 = menu.add(0, 1, 1, "Perfil");
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m2.setIcon(R.drawable.perfil_icone);

        MenuItem m3 = menu.add(0, 2, 2, "Notificacao");
        m3.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m3.setIcon(R.drawable.notificacao_icone);

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
            case 2 :
                Intent webService = new Intent(this, LoginActivity.class);
                startActivity(webService);
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

    public void inserirDados(View view){
        DietaGeralDAO dietaGeralDAO = new DietaGeralDAO(AcademiaActivity.this);
        AlimentosDAO alimentosDAO = new AlimentosDAO(AcademiaActivity.this);
        DietaHasAlimentoDAO dietaHasAlimentoDAO = new DietaHasAlimentoDAO(AcademiaActivity.this);

        DietaGeralTO dietaGeralTO = new DietaGeralTO();
        dietaGeralTO.setNmeDieta("Dieta do Arroz");
        dietaGeralTO.setFinalidade("Aumento massa muscular");
        dietaGeralDAO.inserir(dietaGeralTO);

        dietaGeralTO = new DietaGeralTO();
        dietaGeralTO.setNmeDieta("Dieta DETOX");
        dietaGeralTO.setFinalidade("Redução de medida");
        dietaGeralDAO.inserir(dietaGeralTO);

        dietaGeralTO = new DietaGeralTO();
        dietaGeralTO.setNmeDieta("Dieta da Batata Doce");
        dietaGeralTO.setFinalidade("Aumento massa muscular");
        dietaGeralDAO.inserir(dietaGeralTO);

        dietaGeralTO = new DietaGeralTO();
        dietaGeralTO.setNmeDieta("Dieta Sem Carboidrato");
        dietaGeralTO.setFinalidade("Definição muscular");
        dietaGeralDAO.inserir(dietaGeralTO);

        dietaGeralTO = new DietaGeralTO();
        dietaGeralTO.setNmeDieta("Dieta do Lixo");
        dietaGeralTO.setFinalidade("Aumento massa muscular");
        dietaGeralDAO.inserir(dietaGeralTO);

        List<DietaGeralTO> listaDietaGeral = dietaGeralDAO.consultar();

        AlimentoTO alimentoTO = new AlimentoTO();
        alimentoTO.setNmeAlimento("Batata Doce");
        alimentoTO.setDscNutricional("Carboidrato e proteinas");
        alimentoTO.setDscCaracteriscia("Batada doce é bom para o aumento de massa muscular.");
        alimentosDAO.inserir(alimentoTO);

        alimentoTO = new AlimentoTO();
        alimentoTO.setNmeAlimento("Frango Grelhado");
        alimentoTO.setDscNutricional("Carboidrato e proteinas e livre de gorduras");
        alimentoTO.setDscCaracteriscia("O frango grelhado é um forte aliado aos atletas pois ajuda no aumento da massa muscular com o mínimo de gordura possível");
        alimentosDAO.inserir(alimentoTO);

        alimentoTO = new AlimentoTO();
        alimentoTO.setNmeAlimento("Arroz Integral");
        alimentoTO.setDscNutricional("Carboidrato");
        alimentoTO.setDscCaracteriscia("O arroz integral é necessário para todos os atletas que desejam almentar a massa muscular");
        alimentosDAO.inserir(alimentoTO);

        alimentoTO = new AlimentoTO();
        alimentoTO.setNmeAlimento("Saladas com tom verde Escuro");
        alimentoTO.setDscNutricional("Vitaminas");
        alimentoTO.setDscCaracteriscia("As saladas de cor verde escuro são ricas em vitaminas e contém ferro.");
        alimentosDAO.inserir(alimentoTO);

        alimentoTO = new AlimentoTO();
        alimentoTO.setNmeAlimento("Feijao");
        alimentoTO.setDscNutricional("Carboidrato");
        alimentoTO.setDscCaracteriscia("O feijão contém carboidratos e ferro");
        alimentosDAO.inserir(alimentoTO);

        alimentoTO = new AlimentoTO();
        alimentoTO.setNmeAlimento("Ovo cozido");
        alimentoTO.setDscNutricional("Carboidrato e proteinas");
        alimentoTO.setDscCaracteriscia("O ovo cozido contém albumina uma proteina essencial para o aumento da massa");
        alimentosDAO.inserir(alimentoTO);

        List<AlimentoTO> listaAlimentoTO = alimentosDAO.consultar();

        for(DietaGeralTO dietaGetal : listaDietaGeral){
            for(AlimentoTO alimento : listaAlimentoTO){
                DietaAlimentoTO dietaAlimentoTO = new DietaAlimentoTO();
                dietaAlimentoTO.setCodDietaGeralTO(dietaGetal.getCodDieta());
                dietaAlimentoTO.setCodAlimentoTO(alimento.getCodAlimento());
                dietaHasAlimentoDAO.inserir(dietaAlimentoTO);
            }
        }

        List<DietaAlimentoTO> listaDietaAlimento = dietaHasAlimentoDAO.consultar();
    }

    public void alterarText(String texto){
        txtPush.setText(texto);
    }

    public void onEvent(final String texto){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alterarText(texto);
            }
        });
    }
}
