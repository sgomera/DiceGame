package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.domain.Player;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //mètode per quan apreti el botó de registre
    public void registerPlayer(View view){
        EditText playerName = (EditText)findViewById(R.id.playerName);
        Player player = new Player(playerName.getText().toString());
    }
}
