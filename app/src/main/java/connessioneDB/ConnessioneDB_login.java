package connessioneDB;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ConnessioneDB_login  extends AsyncTask<String,Void,String> {

    AlertDialog dialog;
    Context context;

    public ConnessioneDB_login(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    public String doInBackground(String... voids) {
        String result = "";
        String user = voids[0];
        String pass = voids[1];

        String link = "http://tave.osdb.it/ProgettoFineAnno/login.php";

        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            System.out.println("ciao3");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            System.out.println("ciao4");
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
            System.out.println("ciao5");
            writer.write(data);
            System.out.println("ciao6");
            writer.flush();
            writer.close();
            ops.close();
            System.out.println("ciao7");
            InputStream ips = http.getInputStream();
            System.out.println("ciao8");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            System.err.println("ciao4");
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();

            System.out.println("ciaoFIne");

        } catch (MalformedURLException e) {
            result = e.getMessage();
            System.err.println(e);
        } catch (IOException e) {
            result = e.getMessage();
            System.err.println(e);
        }

        return result;
    }
}
