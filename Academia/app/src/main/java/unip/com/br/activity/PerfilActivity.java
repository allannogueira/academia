package unip.com.br.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import unip.com.br.R;

public class PerfilActivity extends Activity {

    private EditText primeiroNome;
    private EditText ultimoNome;
    private EditText cidade;
    private EditText rua;
    private EditText bairro;
    private EditText numero;
    private EditText telefone;
    private EditText celular;
    private Button btnSalvarPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.laranja));

        primeiroNome = (EditText) findViewById(R.id.primeiroNomeAluno);
        ultimoNome  = (EditText) findViewById(R.id.ultimoNomeAluno);
        cidade = (EditText) findViewById(R.id.nomeCidade);
        rua   = (EditText) findViewById(R.id.nomeRua);
        bairro  = (EditText) findViewById(R.id.nomeBairro);
        numero = (EditText) findViewById(R.id.numeroAluno);
        telefone= (EditText) findViewById(R.id.numTelefone);
        celular = (EditText) findViewById(R.id.numCelular);
        btnSalvarPerfil = (Button) findViewById(R.id.btnSalvarPerfil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_academia, menu);

        MenuItem m1 = menu.add(0,0,0, "Medidas");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setIcon(R.drawable.medida_icone);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                Intent homeActivity = new Intent(this, AcademiaActivity.class);
                startActivity(homeActivity);
                break;
            case 0:
                Intent medidaActivity = new Intent(this, MedidasActivity.class);
                startActivity(medidaActivity);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();

        btnSalvarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(null,"Teste", Toast.LENGTH_LONG).show();
            }
        });
    }
}
