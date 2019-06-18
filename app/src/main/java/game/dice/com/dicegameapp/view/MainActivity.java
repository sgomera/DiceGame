package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.application.PlayGame;
import game.dice.com.dicegameapp.domain.Player;

public class MainActivity extends AppCompatActivity {
    public Player player;
    EditText playerName;
    GameController gameController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Registry button
   public void registerPlayer(View view){
        EditText playerName = (EditText)findViewById(R.id.playerName);
        gameController = new GameController();
        gameController.createPlayer(playerName.getText().toString());

        Toast.makeText(this, "Player Registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra("name", gameController.getPlayerName());

        startActivity(intent);
    }


}
