package com.example.neven.dim_oficial_neven.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.neven.dim_oficial_neven.R;
import com.example.neven.dim_oficial_neven.storage.MyApplication;
import com.example.neven.dim_oficial_neven.storage.SinglePlayer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    private MyApplication app = MyApplication.getInstance();
    private String urlString = "https://www.eclecticasoft.com/dim/content/DIM_Borut.xml";
    private SinglePlayer player;
    private List<SinglePlayer> listOfPlayers = new ArrayList<SinglePlayer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();


        try {


            if (activeNetwork.isConnectedOrConnecting()) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {


                            parseXML();


                        } catch (Exception e) {

                            e.printStackTrace();
                            Intent intent = new Intent(getApplicationContext(), SomethingWentWrong.class);
                            startActivity(intent);


                        }


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();


                    }
                }).start();


            } else {

                Toast.makeText(SplashScreen.this, "Internet connection must be ON", Toast.LENGTH_LONG).show();
                finishAffinity();


            }


        } catch (Exception e) {


            Toast.makeText(SplashScreen.this, "Internet connection must be ON", Toast.LENGTH_LONG).show();
            finishAffinity();


        }


    }


    public void parseXML() {


        int event;


        String getText = null;


        try {


            //__________________dohvati_____________________


            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();


            InputStream stream = conn.getInputStream();


            XmlPullParserFactory xmlFactoryObject;
            XmlPullParser myparser;

            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myparser = xmlFactoryObject.newPullParser();


            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(stream, null);


            //_____________________________


            event = myparser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {

                String tagname = myparser.getName();


                switch (event) {
                    case XmlPullParser.START_TAG:

                        if (tagname.equalsIgnoreCase("singlePlayer")) {

                            player = new SinglePlayer();


                        }


                        break;

                    case XmlPullParser.TEXT:


                        getText = myparser.getText();


                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equals("playerFieldPos")) {

                            String playerinfo = getText;
                            player.setPlayerFieldPosition(playerinfo);


                        }

                        if (tagname.equals("playerID")) {


                            String playerID = getText;
                            player.setPlayerID(playerID);


                        }

                        if (tagname.equals("playerName")) {


                            String playerName = getText;
                            player.setPlayerName(playerName);


                        }

                        if (tagname.equals("playerNation")) {


                            String playerNation = getText;
                            player.setPlayerNation(playerNation);


                        }

                        if (tagname.equals("playerAge")) {


                            String playerAge = getText;
                            player.setPlayerAge(playerAge);


                        }

                        if (tagname.equals("playerPosition")) {


                            String playerPosition = getText;
                            player.setPlayerPosition(playerPosition);


                        }

                        if (tagname.equals("playerNumber")) {


                            String playerNumber = getText;
                            player.setPlayerNumber(playerNumber);


                        }

                        if (tagname.equals("playerDominantHand")) {


                            String playerDominantHand = getText;
                            player.setPlayerDominantHand(playerDominantHand);


                        }

                        if (tagname.equals("Speed")) {


                            String Speed = getText;
                            player.setPlayerSpeed(Speed);


                        }

                        if (tagname.equals("Defense")) {


                            String Defense = getText;
                            player.setPlayerDefense(Defense);


                        }

                        if (tagname.equals("Attack")) {


                            String Attack = getText;
                            player.setPlayerAttack(Attack);


                        }

                        if (tagname.equals("Strength")) {


                            String Strength = getText;
                            player.setPlayerStrength(Strength);


                        }

                        if (tagname.equals("Technique")) {


                            String Technique = getText;
                            player.setPlayerTechnique(Technique);


                        }

                        if (tagname.equals("Punch")) {


                            String Punch = getText;
                            player.setPlayerPunch(Punch);


                        }

                        if (tagname.equals("prevPicture") && myparser.getAttributeValue(0).equals("768") && myparser.getAttributeName(1).equals("picURL")) {


                            String prevPicture = myparser.getAttributeValue(1);
                            player.setPlayerPicture(prevPicture);


                        }

                        if (tagname.equalsIgnoreCase("singlePlayer")) {


                            listOfPlayers.add(player);
                            app.setPlayers(listOfPlayers);


                        }


                        break;
                }
                event = myparser.next();
            }

            stream.close();


        } catch (Exception e) {


            Intent intent = new Intent(getApplicationContext(), SomethingWentWrong.class);
            startActivity(intent);


        }


    }


}
