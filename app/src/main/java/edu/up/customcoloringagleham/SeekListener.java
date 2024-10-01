package edu.up.customcoloringagleham;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.SeekBar;

public class SeekListener implements SeekBar.OnSeekBarChangeListener {
    SeekBar redSeek;
    SeekBar greenSeek;
    SeekBar blueSeek;
    MainCanvas main;

    public SeekListener(MainCanvas m, SeekBar red, SeekBar green, SeekBar blue){
        redSeek = red;
        greenSeek = green;
        blueSeek = blue;
        main = m;
    }

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
