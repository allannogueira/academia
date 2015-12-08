package unip.com.br.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import service.unip.com.br.TO.MedidasAlunoTO;
import service.unip.com.br.Utils.StringUtils;
import unip.com.br.R;

public class MedidasActivity extends FragmentActivity {

    private MedidasAlunoTO medida = new MedidasAlunoTO();
    private BigDecimal imc = BigDecimal.ZERO;
    private BigDecimal gorduraCorporal = BigDecimal.ZERO;
    private String sexo;
    private BigDecimal idade = BigDecimal.ZERO;
    private static DecimalFormat df = new java.text.DecimalFormat( "#,##0.00" );
    private Button btnSalvar;

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
        medida.setBicipsDireito((EditText) findViewById(R.id.bracoDireito));
        medida.setBicipsEsquerdo((EditText) findViewById(R.id.bracoEsquerdo));
        medida.setTricepsDireito((EditText) findViewById(R.id.antBracoDireito));
        medida.setTricepsEsquerdo((EditText) findViewById(R.id.antBracoEsquerdo));
        medida.setCoxaDireita((EditText) findViewById(R.id.coxaDireita));
        medida.setCoxaEsquerda((EditText) findViewById(R.id.coxaEsquerda));
        medida.setPeitoralMaior((EditText) findViewById(R.id.peitoralMaior));
        medida.setPeitoralMenor((EditText) findViewById(R.id.peitoralMenor));
        medida.setPanturilhaDireita((EditText) findViewById(R.id.panturilhaDireita));
        medida.setPanturilhaEsquerda((EditText) findViewById(R.id.pantirilhaEsquerda));
        btnSalvar = (Button) findViewById(R.id.btnSalvarMedida);
    }

    @Override
    public void onResume() {
        super.onResume();

        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!validarCampos()) {
                    String msg = "IMC : " + calcularIMC() + "\nGordura Corporal : " + calcularGorduraCorporal() + "\nDeseja Retornar a Tela Principal?";

                    new AlertDialog.Builder(MedidasActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Resultado")
                            .setMessage(msg)
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //Stop the activity
                                    MedidasActivity.this.finish();
                                }

                            })
                            .setNegativeButton("Nao", null)
                            .show();
                } else {
                    Toast.makeText(MedidasActivity.this,"Existe Campos Nao Preenchidos", Toast.LENGTH_LONG).show();
                }
            }
        });

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

    public String calcularIMC(){

        BigDecimal altura = new BigDecimal(medida.getAltura().getText().toString()).divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal peso = new BigDecimal(medida.getPeso().getText().toString());

        imc = peso.divide(altura.multiply(altura), 2, RoundingMode.HALF_UP);

        return df.format(imc);
    }

    public String calcularGorduraCorporal(){

        BigDecimal vlrSexo = BigDecimal.ZERO;
        BigDecimal vlrFixoIMC = new BigDecimal(1.20);
        BigDecimal vlrFixoIdade = new BigDecimal(0.23);
        BigDecimal vlrFixoSexo = new BigDecimal(10.80);
        BigDecimal vlrFixoFinal = new BigDecimal(5.40);
        idade = new BigDecimal(21);

        if("masculino".equals(sexo)){
            vlrSexo = BigDecimal.ONE;
        }
        gorduraCorporal = (vlrFixoIMC.multiply(imc)).add(vlrFixoIdade.multiply(idade).
                subtract(vlrFixoSexo.multiply(vlrSexo)).subtract(vlrFixoFinal).setScale(2, RoundingMode.HALF_EVEN));

        return df.format(gorduraCorporal)+"%";
    }

    public boolean validarCampos(){
        boolean campoNaoPreenchidos = false;

        if(StringUtils.isNullOrEmpty(medida.getPeso().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getQuadril().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getAbdomen().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getBicipsDireito().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getBicipsEsquerdo().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getTricepsDireito().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getTricepsEsquerdo().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getCoxaDireita().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getCoxaEsquerda().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getPeitoralMaior().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getPeitoralMenor().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getPanturilhaDireita().getText().toString())
                || StringUtils.isNullOrEmpty(medida.getPanturilhaEsquerda().getText().toString())){

            campoNaoPreenchidos = true;
        }

        return campoNaoPreenchidos;
    }
}
