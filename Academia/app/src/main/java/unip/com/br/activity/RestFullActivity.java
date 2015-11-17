package unip.com.br.activity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import service.unip.com.br.HttpConnection;
import service.unip.com.br.TO.AcademiaTO;
import unip.com.br.R;

public class RestFullActivity extends Activity {

    private static String POST = "POST";
    private static String GET = "GET";
    private static String DELETE = "DELETE";
    private static String PUT = "PUT";
    private static String URL = "http://201.53.251.98:2380/album-rest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_full);
    }

    public void sendJson(View view){

        AcademiaTO academiaTO = new AcademiaTO();
        academiaTO.setDataCadastro("28-10-2015");
        academiaTO.setNmeAcademia("Teste");

        String data = generateJson(academiaTO);
        String id="";

        callServer(POST, data, id);

    }

    public void getJson(View view){
        String data = "";
        String id="1";
        callServer(GET, data,id);
    }

    public void putJson(View view){
        AcademiaTO academiaTO = new AcademiaTO();
        academiaTO.setDataCadastro("28-10-2015");
        academiaTO.setNmeAcademia("Teste");

        String data = generateJson(academiaTO);
        String id="";

        callServer(PUT, data, id);
    }

    public void deleteJson(View view){
        String data = "";
        String id="1";
        callServer(DELETE, data, id);
    }

    private String generateJson(AcademiaTO academiaTO){
         JSONObject jo = new JSONObject();


        try{

            jo.put("dataCadastro", academiaTO.getDataCadastro());
            jo.put("nome", academiaTO.getNmeAcademia());
        }catch (JSONException e){e.printStackTrace();}

        return (jo.toString());
    }

    private AcademiaTO deGenerateJson(String data){
        AcademiaTO academiaTO = new AcademiaTO();
    try{
        JSONObject jo = new JSONObject();

        academiaTO.setDataCadastro((jo.getString("dataCadastro")));
        academiaTO.setNmeAcademia(jo.getString("nome"));
        }catch (JSONException e){e.printStackTrace();}

        return (academiaTO);
    }

    private void callServer (final String method, final String data, final String id){
        new Thread(){
            public void run(){
               switch (method){
                   case "GET":
                       String answer = HttpConnection.getDataWeb(URL, method, data);

                       Log.i("Script", answer);

                       if(!answer.isEmpty()){
                           deGenerateJson(answer);
                       }
                       break;
                   case "POST":
                        HttpConnection.postDataWeb(data);
                       break;
                   case "PUT":
                       HttpConnection.updateDataWeb(URL, id, data);
                       break;
                   case  "DELETE":
                       HttpConnection.deleteDataWeb(URL,id);
                       break;
                   default:
                       break;
               }
            }
        }.start();
    }
}
