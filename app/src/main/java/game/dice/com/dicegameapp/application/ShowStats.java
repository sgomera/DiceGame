package game.dice.com.dicegameapp.application;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import game.dice.com.dicegameapp.R;

public class ShowStats  extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_stats);

        Bundle dades = getIntent().getExtras();

        TextView successRate = (TextView)findViewById(R.id.successRate);
        successRate.setText(dades.getString("ranking"));

        TextView gameArray = (TextView)findViewById(R.id.gameArray);
        gameArray.setText(dades.getString("games"));


    }
}
