package game.dice.com.dicegameapp.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.domain.Game;
import game.dice.com.dicegameapp.domain.Player;

public class PlayGame extends Activity {

    public Player player;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);
    }

    public void onPlayButton(View view){
        Game game = new Game();
        game.playGame();

        TextView dice1Result = (TextView) findViewById(R.id.dice1Result);
        TextView dice2Result = (TextView)findViewById(R.id.dice2Result);
        dice1Result.setText("" + game.getDice1Value());
        dice2Result.setText("" + game.getDice2Value());

        TextView sumaText = (TextView)findViewById(R.id.sumaText);
        sumaText.setText("TOTAL: " + game.getSumDices());

        TextView resultText = (TextView)findViewById(R.id.resultText);

        if (game.hasWon()== true) {
            resultText.setText("You won!");
        } else {
            resultText.setText("You lost!");
        }

        //falta emmagatzemar el resultat en algun lloc

    }



   //no sé què estic fent
/*    public void onRestoreInstanceState(Bundle playerData){
        super.onRestoreInstanceState(playerData);
        player = new Player(playerData.getString("name"));
    }*/

    public void onStatsButton(View view){
        Intent intent = new Intent(this, ShowStats.class);
        startActivity(intent);
    }
}
