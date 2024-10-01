package edu.up.customcoloringagleham;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView element = findViewById(R.id.element);
        SeekBar seekRed = findViewById(R.id.seekRed);
        SeekBar seekGreen = findViewById(R.id.seekGreen);
        SeekBar seekBlue = findViewById(R.id.seekBlue);
        MainCanvas myCanvas = findViewById(R.id.mainCanvas);
        myCanvas.setViewRefs(element, seekRed, seekGreen, seekBlue);

        SeekListener listener = new SeekListener(myCanvas, seekRed, seekGreen, seekBlue);
        myCanvas.setOnTouchListener(myCanvas);
        seekRed.setOnSeekBarChangeListener(listener);
        seekGreen.setOnSeekBarChangeListener(listener);
        seekBlue.setOnSeekBarChangeListener(listener);
    }
}