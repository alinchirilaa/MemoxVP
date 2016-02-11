package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fragment.WalkthroughActivity;

/**
 * Created by vasin on 2/5/2016.
 */
public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        new Thread (){
            @Override
            public void run() {
                try{
                    sleep(1700);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        }.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}