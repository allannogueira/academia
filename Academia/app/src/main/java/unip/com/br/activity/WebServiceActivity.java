package unip.com.br.activity;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import unip.com.br.R;


public class WebServiceActivity extends FragmentActivity {

    private static final String SOAP_ACTION = "http://201.53.251.98:2380/services/index/academias#academias";
    private static final String METHOD_NAME = "academias";
    private static final String NAMESPACE = "serverAcademia";
    //private static final String URL = "http://retamero.com.br/webservice/server.php?wsdl";
    private static final String URL = "http://201.53.251.98:2380/services/index/academias?wsdl";
    private TextView tvtv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16;
    private EditText etTexto;
    private String response;
    private String msg;

    public void limparCampos(){
      /*  tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        tv7.setText("");
        tv8.setText("");
        tv9.setText("");
        tv10.setText("");
        tv11.setText("");
        tv12.setText("");
        tv13.setText("");
        tv14.setText("");
        tv15.setText("");
        tv16.setText("");*/
    }

    public void notifica(String msg){
        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(contexto, msg, duracao);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        msg ="Digite o ID do aluno.";
        notifica(msg);
        setContentView(R.layout.activity_web_service);

        myAsyncTask myRequest = new myAsyncTask();
        myRequest.execute();

        /*tv = (TextView) findViewById(R.id.textView36); //retorno
        tv1 = (TextView) findViewById(R.id.textView4); //id
        tv2 = (TextView) findViewById(R.id.textView6); //peso
        tv3 = (TextView) findViewById(R.id.textView21); //altura
        tv4 = (TextView) findViewById(R.id.textView22); //pema
        tv5 = (TextView) findViewById(R.id.textView23); //peme
        tv6 = (TextView) findViewById(R.id.textView24); //quadril
        tv7 = (TextView) findViewById(R.id.textView25); //bies
        tv8 = (TextView) findViewById(R.id.textView26); //bidi
        tv9 = (TextView) findViewById(R.id.textView27); //tres
        tv10 = (TextView) findViewById(R.id.textView28); //trdi
        tv11 = (TextView) findViewById(R.id.textView29); //coes
        tv12 = (TextView) findViewById(R.id.textView30); //codi
        tv13 = (TextView) findViewById(R.id.textView31); //paes
        tv14 = (TextView) findViewById(R.id.textView32); //padi
        tv15 = (TextView) findViewById(R.id.textView33); //ques
        tv16 = (TextView) findViewById(R.id.textView34); //qudi
        etTexto = (EditText) findViewById(R.id.editText2);//envia
        Button btn = (Button) findViewById(R.id.button);
*/
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
                String texto = etTexto.getText().toString();
                if(texto == null || texto.isEmpty()){
                    msg = "ERRO: Um número precisa ser espefícidado";
                    //tv.setText(msg);
                    notifica(msg);
                }
                else{
                    myAsyncTask myRequest = new myAsyncTask();
                    myRequest.execute();
                }
            }
        });*/
    }

    private class myAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {
                JSONObject obj = new JSONObject(response);
                if (obj.getString("id").equals("vazio")) {
                    msg = "ERR0: Este usuario não existe em nosso banco de dados.";
                    //tv.setText(msg);
                    notifica(msg);
                } else if (obj.getString("id").equals("null")) {
                    msg = "ERR0: Não foi possivel estabelecer uma conexão com o servidor.";
                    //tv.setText(msg);
                    notifica(msg);
                } else {
                   // tv.setText(response);
                    msg = "Busca realizada com sucesso!";
                  //  tv.setText(response);
                    notifica(msg);
                }

                if (response.equals("{\"id\":\"null\"}") || response.equals("{\"id\":\"vazio\"}")) {
                    //tv1.setText("");
                } else {
                   // tv1.setText(obj.getString("id"));
                }
               /* tv2.setText(obj.getString("peso"));
                tv3.setText(obj.getString("altura"));
                tv4.setText(obj.getString("peitoral_maior"));
                tv5.setText(obj.getString("peitoral_menor"));
                tv6.setText(obj.getString("quadril"));
                tv7.setText(obj.getString("biceps_esquerdo"));
                tv8.setText(obj.getString("biceps_direito"));
                tv9.setText(obj.getString("triceps_esquerdo"));
                tv10.setText(obj.getString("triceps_direito"));
                tv11.setText(obj.getString("coxas_esquerda"));
                tv12.setText(obj.getString("coxas_direita"));
                tv13.setText(obj.getString("panturrilha_esquerda"));
                tv14.setText(obj.getString("panturrilha_direita"));
                tv15.setText(obj.getString("quadril_esquerdo"));
                tv16.setText(obj.getString("quadril_direito"));*/

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0){
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            //request.addProperty("id", etTexto.getText().toString());

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try{
                androidHttpTransport.call(SOAP_ACTION, envelope);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            SoapObject result;
            result = (SoapObject) envelope.bodyIn;

            if (result != null){
                response = result.getProperty(0).toString();
                Log.i("TAG", response);
            }
            else {
                Log.i("TAG", "====> NULO <========");
                response = "{\"id\":\"null\"}";
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web, menu);
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
