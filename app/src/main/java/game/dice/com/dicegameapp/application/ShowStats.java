package game.dice.com.dicegameapp.application;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import game.dice.com.dicegameapp.R;

public class ShowStats  extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_stats);
    }
}
