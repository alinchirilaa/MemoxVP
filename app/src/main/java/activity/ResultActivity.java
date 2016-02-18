package activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.alin.memoxvp.R;

import org.json.JSONObject;

import Clase.JSONParser;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // we will using AsyncTask during parsing
        new AsyncTaskParseJson().execute();
    }

    // you can make this class as another java file so it will be separated from your main activity.
    public class AsyncTaskParseJson extends AsyncTask<String, String, JSONObject> {
        String url = "http://www.memox.ro/mfin/mobileMfin.php";  //JSON string url
        private ProgressDialog progressDialog = null;
        // contacts JSONArray
        JSONObject jsonobj = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ResultActivity.this,
                    "Fetching from Memox", "Please wait ...");
        }

        @Override
        protected JSONObject doInBackground(String... arg0) {
                // instantiate our json parser
                JSONParser jParser = new JSONParser();

                // get json string from url
                jsonobj = jParser.getJSONFromUrl(url);
                return jsonobj;
                // get the array of users
                //jsonobj = json.getJSONObject(String.valueOf(json));
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), jsonobj.toString().substring(1,jsonobj.toString().length()-1), Toast.LENGTH_SHORT).show();
            Log.d("onPostExecute", result.toString());
        }
    }
}