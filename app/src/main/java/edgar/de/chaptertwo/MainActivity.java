package edgar.de.chaptertwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
    private int points;
    private int round;
    private int countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void newGame() {
        points = 0;
        round = 1;
        initRound();
    }

    private void initRound() {
       countdown = 10;
    }
}
