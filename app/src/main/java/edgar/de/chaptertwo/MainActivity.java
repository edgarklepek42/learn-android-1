package edgar.de.chaptertwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private int points;
    private int round;
    private int countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame();
        showStartFragment();
    }

    private void newGame() {
        points=0;
        round=1;
        initRound();
    }

    private void initRound() {
        countdown=10;
        update();
    }

    // Fill TextViews with standard values
    private void fillTextView(int id, String text) {
        TextView tv = (TextView)findViewById(id);
        tv.setText(text);
    }

    // Update TextViews with new content
    private void update() {
        fillTextView(R.id.points, Integer.toString(points));
        fillTextView(R.id.round, Integer.toString(round));
        fillTextView(R.id.countdown, Integer.toString(countdown));
    }

    // Startscreen
    private void showStartFragment() {
        ViewGroup container = (ViewGroup)findViewById(R.id.container);
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.fragment_start, null));
        container.findViewById(R.id.start).setOnClickListener(this);
    }

    // Failscreen
    private void showGameOverFragment() {
        ViewGroup container = (ViewGroup)findViewById(R.id.container);
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.fragment_gameover, null));
        container.findViewById(R.id.playAgain).setOnClickListener(this);
    }

    // Just for testing purpose
    private void showGame() {
        ViewGroup container = (ViewGroup)findViewById(R.id.container);
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.activity_main, null));
    }

    private void startGame() {
        newGame();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.start) {
            //showGameOverFragment();
            startGame();
        }
        else if(view.getId() == R.id.playAgain) {
            showStartFragment();
        }
    }
}
