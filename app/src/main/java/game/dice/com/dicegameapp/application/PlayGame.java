package game.dice.com.dicegameapp.application;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.domain.Game;
import game.dice.com.dicegameapp.domain.Player;

public class PlayGame extends Activity {

    public Player player;
    GameController gameController;

/*    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);

        Bundle dades = getIntent().getExtras();

        TextView playerPlay = (TextView) findViewById(R.id.playerPlay);
        playerPlay.setText(dades.getString("name"));

    }*/


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);

        Bundle dades = getIntent().getExtras();

        player = new Player(dades.getString("name"));

        gameController = new GameController();
        gameController.createPlayer(player.getName());

        TextView playerPlay = (TextView) findViewById(R.id.playerPlay);
        playerPlay.setText(player.getName());

    }

    public void onPlayButton(View view){
        Game game = new Game();
        game.playGame();

        TextView dice1Result = (TextView) findViewById(R.id.dice1Result);
        dice1Result.setText("" + game.getDice1Value());
        TextView dice2Result = (TextView)findViewById(R.id.dice2Result);
        dice2Result.setText("" + game.getDice2Value());
        TextView sumaText = (TextView)findViewById(R.id.sumaText);
        sumaText.setText("TOTAL: " + game.getSumDices());

        //player.addGame(game);
        TextView resultText = (TextView)findViewById(R.id.resultText);

       if (game.hasWon()== true) {
            resultText.setText("You won!");
        } else {
            resultText.setText("You lost!");
        }

    }


    public void onStatsButton(View view){
        Intent intent = new Intent(this, ShowStats.class);
        startActivity(intent);
    }
}
