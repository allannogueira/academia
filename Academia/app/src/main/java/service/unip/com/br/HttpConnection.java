package service.unip.com.br;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cleber on 09/09/2015.
 */
public class HttpConnection {


    public static String getDataWeb(String url, String method, String data){

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String answer = "";
        try{
            ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
            valores.add(new BasicNameValuePair("id", data));

            httpPost.setEntity(new UrlEncodedFormEntity(valores));
            
            HttpResponse resposta = httpClient.execute(httpPost);
            answer = EntityUtils.toString(resposta.getEntity());

        } catch (NullPointerException e) {e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}

        return(answer);

    }

    public static  void postDataWeb(String data){
        /*String decoded = new String();
        try {

            String urlParameters  = "param1=a&param2=b&param3=c";
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;
            URL    url            = new URL( uri );
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setDoOutput( true);
            conn.setInstanceFollowRedirects( false);
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches( false);
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                wr.write( postData );


                decoded = new String(postData);


            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
    }

    public static void updateDataWeb(String uri, String id, String data){

        URL url = null;
        try {

            url = new URL(uri);
            HttpURLConnection httpCon = null;
            httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            out.close();
            httpCon.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteDataWeb(String uri, String id){

        URL url = null;
        try {

            url = new URL(uri);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty(
                    "Content-Type", "application/Json" );
            httpCon.setRequestMethod("DELETE");
            httpCon.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}
