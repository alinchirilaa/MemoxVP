package activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alin.memoxvp.R;

import org.json.JSONObject;

import Clase.JSONParser;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we will using AsyncTask during parsing
        new AsyncTaskParseJson().execute();
    }

    // you can make this class as another java file so it will be separated from your main activity.
    public class AsyncTaskParseJson extends AsyncTask<String, String, JSONObject> {
        String url = "";  //JSON string url
        private ProgressDialog progressDialog = new ProgressDialog(ResultActivity.this);
        // contacts JSONArray
        JSONObject jsonobj = null;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Downloading articles...");
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface arg0) {
                    AsyncTaskParseJson.this.cancel(true);
                }
            });
        }

        @Override
        protected JSONObject doInBackground(String... arg0) {
                // instantiate our json parser
                JSONParser jParser = new JSONParser();

                // get json string from url
                JSONObject json = jParser.getJSONFromUrl(url);
                return json;
                // get the array of users
                //jsonobj = json.getJSONObject(String.valueOf(json));
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Log.d("onPostExecute", result.toString());
        }
    }
}