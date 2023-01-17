package edu.ucsd.cse110.lab2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button button1 = activity.findViewById(R.id.btn_one);
            Button button_plus = activity.findViewById(R.id.btn_plus);
            Button button_equals = activity.findViewById(R.id.btn_equals);
            button1.performClick();
            button_plus.performClick();
            button1.performClick();
            button_equals.performClick();

            TextView display = (TextView) activity.findViewById(R.id.display);
            assertEquals("2", display.getText().toString());
        });
    }
}
