package activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.alin.memoxvp.R;

import org.json.JSONObject;

import Utils.JSONParser;

public class ResultActivity extends AppCompatActivity {
    private ProgressDialog progressDialog = null;
    String url = "http://www.memox.ro/mfin/mobileMfin.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        new loadData().execute();

    }
    private class loadData extends AsyncTask<String, String, JSONObject> {
        JSONObject jsonobj = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog  = ProgressDialog.show(ResultActivity.this, "Fetching from Memox", "Please wait ...");
        }
        @Override
        protected JSONObject doInBackground(String... params) {
            JSONParser jParser = new JSONParser();
            jsonobj = jParser.getJSONFromUrl(url);
            return jsonobj;
//            JSONObject json = jParser.getJSONFromUrl(url);
//            return json;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
            progressDialog .dismiss();
            Toast.makeText(getApplicationContext(), jsonobj.toString().substring(1, jsonobj.toString().length() - 1),
                    Toast.LENGTH_LONG).show();
            Log.d("onPostExecute", result.toString());
        }
    }
}
