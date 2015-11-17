package unip.com.br.activity;

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

import unip.com.br.R;

public class AtividadesActivity extends ActionBarActivity {


    List<Map<String, String>> dados = new ArrayList<>();
    String[] valores = new String[] {
            "Acesso a minha localização",
            "Satélite de GPS",
            "Local de rede móvel e Wi-Fi"};
    String[] descricoes = new String[] {
            "Permitir que os aplicativos que solicitaram sua permissão " +
                    "usem seus dados de localização",
            "Permitir que os aplicativos usem o GPS do telefone para " +
                    "determinar sua posição",
            "Permitir que os aplicativos usem o serviço de localização " +
                    "do Google para determinar seu local mais rapidamente. Dados " +
                    "de localização anônimos serão coletados e enviados ao Google"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividades);
        ListView lista = (ListView)findViewById(R.id.listViewAtividades);
        for(int i=0; i<valores.length; i++) {
            Map<String, String> linha = new HashMap<>();
            dados.add(linha);
            linha.put("Titulo", valores[i]);
            linha.put("Subtitulo", descricoes[i]);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dados,
                android.R.layout.simple_list_item_2,
                new String[] {"Titulo", "Subtitulo"},
                new int[] {android.R.id.text1, android.R.id.text2});
        lista.setAdapter(adapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividades_view, menu);
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
}
