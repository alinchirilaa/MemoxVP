package com.example.alin.memoxvp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String htmlText = " %s ";
        String myData = "Aplicatia MemoX VP a fost conceputa pentru a usura activitatea persoanelor care activeaza in domeniul financiar contabil si nu numai. \n" +
                "Scopul acesteia este ca sa reduca timpul petrecut pe site-urile institutiilor publice pentru verificarea clientilor si furnizorilor unei organizatii in \n" +
                "vederea obtinerii de informatii cu privire la:  datele de identificare, status (activ/inactiv, insolventa), inregistrarea TVA / TVAI, cod VIES. Cum in \n" +
                "practica pot interveni destul de frecvent modificari ale datelor agentilor economici, un astfel de instrument reprezinta o necesitate.In acest scop oferim organizatiilor posibilitatea de a-si verifica in timp real si cu o economie de timp considerabila intreaga baza de \n" +
                "date de clienti si furnizori cu care acestea colaboreaza.Sursele de date utilizate sunt: Ministerul de Finante (MF), \n" +
                "Agentia Nationala de Administrare Fiscala (ANAF), Oficiul National al Registrului Comertului (ONRC) si Baze de date proprii. \n" +
                "Se verifica datele inregistrate la Ministerul de Finante (datele de identificare, TVA, TVAI), \n" +
                "in Registrul contribuabililor inactivi/reactivati, in Registrul persoanelor impozabile care aplica sistemul de TVA la incasare, \n" +
                "Buletinul Insolventei, iar pentru partenerii externi se valideaza numarul de inregistrare pentru TVA-VIES.";

        WebView webView = (WebView) findViewById(R.id.webView1);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}

