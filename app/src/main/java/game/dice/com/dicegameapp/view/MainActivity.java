package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.PlayGame;
import game.dice.com.dicegameapp.domain.Player;

public class MainActivity extends AppCompatActivity {
    public Player player;
    EditText playerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //mètode per quan apreti el botó de registre
    public void registerPlayer(View view){
        EditText playerName = (EditText)findViewById(R.id.playerName);
        player = new Player(playerName.getText().toString());

        Toast.makeText(this, "Player Registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PlayGame.class);
        startActivity(intent);
    }

    //============================PERSISTÈNCIA AMB BUNDLE========================================
    //mètode que s'activa sol quan es surt de l'activitat. Guarda a un bundle anomenat "playerData"
    //el parell de valors key= cuenta i value = contador. I després el guarda en l'activitat
    //pare, per això posa super.
    public void onSaveInstanceState(Bundle playerData) {
        playerData.putString("name",player.getName());
        super.onSaveInstanceState(playerData);
    }

    // mètode que recupera el valor del bundle playerData que estava guardat en el pare (super),
    // quan es reïnicia una activitat. Guarda a la variable Player Name, el valor del bundle playerData
    // que té per key "name" i després el posa a la vista playerName.
    // després de sobreescriure aquests dos mètodes, quan canviem l'orientació del dispositiu,
    // ja no es perd la informació del contador.
    public void onRestoreInstanceState(Bundle playerData){
        super.onRestoreInstanceState(playerData);
        player.setName(playerData.getString("name"));
        playerName.setText("" + player.getName());
    }
    //===========================================================================================

    //-------------------------PERSISTENCE WITH SHAREDPREFERENCES-----------------------------
/*//-----------stores the data in sharedpreferences.xml (even when app i restarted)---------
    public void onPause() {
        super.onPause();

        //recupera el sharedPreferences que ja té per defecte tota app Android, i el guarda a datos:
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        //fer editable l'objecte tipus SharedPreferences del sistema:
        //el mètode edit de SharedPreferences, retorna un objecte SharedPreferences.editor:
        SharedPreferences.Editor miEditor = datos.edit();

        //establir la informació a emmagatzemar:
        miEditor.putString("name", player.getName());

        //transferir la informació a l'objecte SharedPreferences.
        miEditor.apply();

    }

    public void onResume() {
        super.onResume();
        //recuperar la informació que hi ha emmagatzemada en el SharedPreferences
        //accedir al SharedPreferences per defecte:
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        player = new Player(datos.getString("name",""));
        EditText playerName = (EditText)findViewById(R.id.playerName);

        playerName.setText("" + player.getName());

    }*/

}
