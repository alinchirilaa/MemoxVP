package com.example.alin.memoxvp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);   //Back button to home enable
        actionBar.setDisplayHomeAsUpEnabled(true);   //  -//-

//                                      --WebView code--

        String summary = "<html><body><p align=\"justify\"><b>Aplicatia MemoX VP</b> a fost conceputa pentru a usura activitatea " +
                "persoanelor care activeaza in domeniul financiar contabil si nu numai. Scopul acesteia este ca sa reduca timpul" +
                " petrecut pe site-urile institutiilor publice pentru verificarea clientilor si furnizorilor unei organizatii in " +
                "vederea obtinerii de informatii cu privire la:  datele de identificare, status (activ/inactiv, insolventa)," +
                " inregistrarea TVA / TVAI, cod VIES. Cum in practica pot interveni destul de frecvent modificari ale datelor " +
                "agentilor economici, un astfel de instrument reprezinta o necesitate.<br>In acest scop oferim organizatiilor " +
                "posibilitatea de a-si verifica in timp real si cu o economie de timp considerabila intreaga baza de date de clienti " +
                "si furnizori cu care acestea colaboreaza.<br>Sursele de date utilizate sunt: Ministerul de Finante (MF)," +
                "Agentia Nationala de Administrare Fiscala (ANAF), Oficiul National al Registrului Comertului (ONRC) si Baze de date proprii." +
                "Se verifica datele inregistrate la Ministerul de Finante (datele de identificare, TVA, TVAI)," +
                "in Registrul contribuabililor inactivi/reactivati, in Registrul persoanelor impozabile care aplica sistemul de TVA la incasare," +
                "Buletinul Insolventei, iar pentru partenerii externi se valideaza numarul de inregistrare pentru TVA-VIES.</p></body></html>";

        WebView webView = (WebView) findViewById(R.id.webView1);
        webView.loadData(summary, "text/html", null);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.getSettings().setBuiltInZoomControls(true);   //zoom_in zoom_out working
        webView.getSettings().setDisplayZoomControls(false);  //hide zoom control


//                                      --WebView code--

        //--------------------------------------------------------------------------------------//


//        TextView myTextview;
//        myTextview= (TextView) findViewById(R.id.txtAbout);
//        myTextview.setText(Html.fromHtml("<html><body><p align=\"justify\"><b>Aplicatia MemoX VP</b> a fost conceputa pentru a usura activitatea " +
//                "persoanelor care activeaza in domeniul financiar contabil si nu numai. Scopul acesteia este ca sa reduca timpul" +
//                "petrecut pe site-urile institutiilor publice pentru verificarea clientilor si furnizorilor unei organizatii in" +
//                "vederea obtinerii de informatii cu privire la:  datele de identificare, status (activ/inactiv, insolventa)," +
//                "inregistrarea TVA / TVAI, cod VIES. Cum in practica pot interveni destul de frecvent modificari ale datelor " +
//                "agentilor economici, un astfel de instrument reprezinta o necesitate.<br>In acest scop oferim organizatiilor " +
//                "posibilitatea de a-si verifica in timp real si cu o economie de timp considerabila intreaga baza de date de clienti" +
//                "si furnizori cu care acestea colaboreaza.<br>Sursele de date utilizate sunt: Ministerul de Finante (MF)," +
//                "Agentia Nationala de Administrare Fiscala (ANAF), Oficiul National al Registrului Comertului (ONRC) si Baze de date proprii." +
//                "Se verifica datele inregistrate la Ministerul de Finante (datele de identificare, TVA, TVAI)," +
//                "in Registrul contribuabililor inactivi/reactivati, in Registrul persoanelor impozabile care aplica sistemul de TVA la incasare," +
//                "Buletinul Insolventei, iar pentru partenerii externi se valideaza numarul de inregistrare pentru TVA-VIES.</p></body></html>"));
//        myTextview.setMovementMethod(new ScrollingMovementMethod());


                                //-------FAB dispare din ABout-------

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
                                //-------FAB dispare din ABout-------


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

