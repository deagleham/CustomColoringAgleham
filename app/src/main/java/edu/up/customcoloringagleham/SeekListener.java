package edu.up.customcoloringagleham;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.SeekBar;

//@author De'Ante Agleham

public class SeekListener implements SeekBar.OnSeekBarChangeListener {
    SeekBar redSeek;
    SeekBar greenSeek;
    SeekBar blueSeek;
    MainCanvas main;

    //Constructor for SeekListener
    public SeekListener(MainCanvas m, SeekBar red, SeekBar green, SeekBar blue){
        redSeek = red;
        greenSeek = green;
        blueSeek = blue;
        main = m;
    }

    //Check if seek bar progress for red, green, and/or blue changed, then update color of selected element
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int red = redSeek.getProgress();
        int green = greenSeek.getProgress();
        int blue = blueSeek.getProgress();

        int color = Color.rgb(red, green, blue);
        Paint curr = main.getPaint();
        if (curr == null) {
            return;
        }
        else {
            curr.setColor(color);
        }

        main.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}
