package activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.alin.memoxvp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import POJOs.Client;
import POJOs.RecyclerItem;
import Utils.JSONParser;
import adapter.ResultRecycleViewAdapter;

public class ResultActivity extends AppCompatActivity {
    private ProgressDialog progressDialog = null;
    private List<Client> feedsList;
    private RecyclerView mRecyclerView;
    private ResultRecycleViewAdapter adapter;


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


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);


        new loadData().execute();

    }


    private class loadData extends AsyncTask<String, String, JSONObject> {
        JSONObject jsonobj = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ResultActivity.this, "Fetching from Memox", "Please wait ...");
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            JSONParser jParser = new JSONParser();

            jsonobj = jParser.getJSONFromUrl(url);
            Log.d("doInBackground", "");
            parseResult(jsonobj);

            //  adapter.notifyDataSetChanged();

            return jsonobj;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            adapter = new ResultRecycleViewAdapter(feedsList, ResultActivity.this);
            mRecyclerView.setAdapter(adapter);


            Toast.makeText(getApplicationContext(), jsonobj.toString().substring(1, jsonobj.toString().length() - 1),
                    Toast.LENGTH_LONG).show();

            Log.d("onPostExecute", result.toString());
        }
    }


    private void parseResult(JSONObject response) {


        feedsList = new ArrayList<Client>();

        // for (int i = 0; i < 3; i++) {

        Client item = new Client();
        if (response.optString("Denumire_Agent") != null) {
            item.setDenumireAgent(response.optString("Denumire_Agent"));
        }

        if (response.optString("Adresa") != null) {
            item.setAdresa(response.optString("Adresa"));
        }

        if (response.optString("Cod_Fiscal") != null) {
            item.setCodFiscal(response.optString("Cod_Fiscal"));
        }

        if (response.optString("Localitate") != null) {
            item.setLocalitate(response.optString("Localitate"));
        }

        feedsList.add(item);
        //}
    }


    /*
       Cleanup on every activity restart to avoid duplicate data.
    */
    @Override
    protected void onRestart() {
        super.onRestart();

        adapter.clearRecycler();

        new loadData().execute();
    }
}
