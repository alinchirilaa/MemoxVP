package activity;


import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.graphics.BitmapFactory;
import android.widget.TextView;

import com.example.alin.memoxvp.R;

public class AboutActivity extends AppCompatActivity {

    private final String url = "http://www.memox.ro/";

    private CustomTabsClient mClient;
    private CustomTabsSession mCustomTabsSession;
    private static final String TAG = "About";

    private static class NavigationCallback extends CustomTabsCallback {
        @Override
        public void onNavigationEvent(int navigationEvent, Bundle extras) {
            Log.w(TAG, "onNavigationEvent: Code = " + navigationEvent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button moreDetailsButton = (Button) findViewById(R.id.button_about);
        moreDetailsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this ,R.style.AppCompatAlertDialogStyle);
                builder.setTitle(R.string.info_title);
                builder.setMessage(R.string.info_description);
                builder.setPositiveButton(R.string.ok,null);
                builder.show();
            }

        });

        CustomTabsServiceConnection mConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                mClient = customTabsClient;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                    mClient = null;
            }
        };

        String packageName = "com.android.chrome";
        CustomTabsClient.bindCustomTabsService(this,packageName,mConnection);


        TextView textViewSRL = (TextView) findViewById(R.id.about_srl);
        TextView textViewNr1 = (TextView) findViewById(R.id.about_nr1);
        TextView textViewNr2 = (TextView) findViewById(R.id.about_nr2);
        TextView textViewAdresa = (TextView) findViewById(R.id.about_adresa);





    }

    public void prefetchContent(View view){
        if (mClient != null) {
            mClient.warmup(0);
            CustomTabsSession customTabsSession = getSession();
            customTabsSession.mayLaunchUrl(Uri.parse(url),null,null);

        }
    }

    private CustomTabsSession getSession() {
        if (mClient == null) {
            mCustomTabsSession = null;
        } else if (mCustomTabsSession == null) {
            mCustomTabsSession = mClient.newSession(new NavigationCallback());
        }
        return mCustomTabsSession;
    }

    public void loadCustomTabs(View view){
        CustomTabsIntent.Builder mBuilder = new CustomTabsIntent.Builder(getSession());
        mBuilder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        mBuilder.setCloseButtonIcon(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_arrow_back_white_24dp));
        mBuilder.addMenuItem("Share", setMenuItem());
        mBuilder.setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left);
        mBuilder.setExitAnimations(this, R.anim.slide_in_left, R.anim.slide_out_right);
        CustomTabsIntent mIntent = mBuilder.build();
        mIntent.launchUrl(this, Uri.parse(url));

    }

    private PendingIntent setMenuItem() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Official website of Anjith Sasindran");
        shareIntent.putExtra(Intent.EXTRA_TEXT, url);
        return PendingIntent.getActivity(this, 0, shareIntent, 0);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //target set to home
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

