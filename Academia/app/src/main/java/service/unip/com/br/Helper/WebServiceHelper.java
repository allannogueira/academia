package service.unip.com.br.Helper;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import service.unip.com.br.TO.MedidasAlunoTO;

/**
 * Created by Cleber on 11/09/2015.
 */
public class WebServiceHelper {

    private static final String SOAP_ACTION = "http://201.82.228.134:2380/webservice/server.php/exemplo";
    private static final String METHOD_NAME = "exemplo";
    private static final String NAMESPACE = "http://201.82.228.134:2380/webservice";
    //private static final String URL = "http://retamero.com.br/webservice/server.php?wsdl";
    private static final String URL = "http://201.82.228.134:2380/webservice/server.php?wsdl";
    private String response;
    private String  msg;
    private String idAluno;

    private MedidasAlunoTO medidaAluno = new MedidasAlunoTO();

    public void consultarPorIdAluno(String id){

        idAluno = id;

        myAsyncTask myRequest = new myAsyncTask();
        myRequest.execute();

    }

    private class myAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {
                JSONObject obj = new JSONObject(response);
                if (obj.getString("id").equals("vazio")) {
                    msg = "ERR0: Este usuario não existe em nosso banco de dados.";
                } else if (obj.getString("id").equals("null")) {
                    msg = "ERR0: Não foi possivel estabelecer uma conexão com o servidor.";
                } else {
                    msg = "Busca realizada com sucesso!";;
                }


                medidaAluno.getPeso().setText(obj.getString("peso"));
                medidaAluno.getAltura().setText(obj.getString("altura"));
                medidaAluno.getPeitoralMaior().setText(obj.getString("peitoral_maior"));
                medidaAluno.getPeitoralMenor().setText(obj.getString("peitoral_menor"));
                medidaAluno.getQuadril().setText(obj.getString("quadril"));
                medidaAluno.getBicipsEsquerdo().setText(obj.getString("biceps_esquerdo"));
                medidaAluno.getBicipsDireito().setText(obj.getString("biceps_direito"));
                medidaAluno.getTricepsEsquerdo().setText(obj.getString("triceps_esquerdo"));
                medidaAluno.getTricepsDireito().setText(obj.getString("triceps_direito"));
                medidaAluno.getCoxaEsquerda().setText(obj.getString("coxas_esquerda"));
                medidaAluno.getCoxaDireita().setText(obj.getString("coxas_direita"));
                medidaAluno.getPanturilhaEsquerda().setText(obj.getString("panturrilha_esquerda"));
                medidaAluno.getPanturilhaDireita().setText(obj.getString("panturrilha_direita"));
                medidaAluno.getQuadril().setText(obj.getString("quadril_esquerdo"));
                //tv16.setText(obj.getString("quadril_direito"));

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
            request.addProperty("id", idAluno);

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
}
