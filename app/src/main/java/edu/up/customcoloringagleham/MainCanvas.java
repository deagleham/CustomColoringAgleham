package edu.up.customcoloringagleham;

import static java.lang.Math.sqrt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

//@author De'Ante Agleham

public class MainCanvas extends SurfaceView implements View.OnTouchListener {

    //For our favorite color
    private Paint ketchupPaint;
    private Paint eggPaint;
    private Paint baconPaint1;
    private Paint baconPaint2;
    private Paint baconPaint3;
    private Paint platePaint;


    //references to the Views you plan to interact with
    TextView currObjTV = null;
    SeekBar redSeek = null;
    SeekBar greenSeek = null;
    SeekBar blueSeek = null;

    public MainCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        ketchupPaint = new Paint();
        ketchupPaint.setColor(0xFFFF0000);
        ketchupPaint.setStyle(Paint.Style.FILL);

        eggPaint = new Paint();
        eggPaint.setColor(0xFFFFFF00);
        eggPaint.setStyle(Paint.Style.FILL);

        baconPaint1 = new Paint();
        baconPaint1.setColor(0xFF954535);
        baconPaint1.setStyle(Paint.Style.FILL);

        baconPaint2 = new Paint();
        baconPaint2.setColor(0xFF954535);
        baconPaint2.setStyle(Paint.Style.FILL);

        baconPaint3 = new Paint();
        baconPaint3.setColor(0xFF954535);
        baconPaint3.setStyle(Paint.Style.FILL);

        platePaint = new Paint();
        platePaint.setColor(0xFFF1F1F1);
        platePaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(0xFFFFFFFF);  //white background

        setOnTouchListener(this);
    }

    //use this method to setup the view references
    public void setViewRefs(TextView tv, SeekBar sbRed, SeekBar sbGreen, SeekBar sbBlue) {
        this.currObjTV = tv;
        this.redSeek = sbRed;
        this.greenSeek = sbGreen;
        this.blueSeek = sbBlue;
    }

    /**
     * returns the Paint associated with the currently selected object
     */
    public Paint getPaint() {
        //step 1:  get the text of the currObjTV
        String tempT = currObjTV.getText().toString();
        Paint tempP = null;

        //step 2:  use an if-else chain to figure out which paint it uses
        if(tempT.equals("Plate")){
            tempP = platePaint;
        }
        else if(tempT.equals("Egg")){
            tempP = eggPaint;
        }
        else if(tempT.equals("Ketchup")){
            tempP = ketchupPaint;
        }
        else if(tempT.equals("Bacon #1")){
            tempP = baconPaint1;
        }
        else if(tempT.equals("Bacon #2")){
            tempP = baconPaint2;
        }
        else if(tempT.equals("Bacon #3")){
            tempP = baconPaint3;
        }

        //step 3:  return that paint
        return tempP;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(550,500,500, platePaint);
        canvas.drawCircle(550,470,400, eggPaint);
        canvas.drawCircle(550,450,300, ketchupPaint);
        canvas.drawRect(400, 200, 500, 1000, baconPaint1);
        canvas.drawRect(200, 200, 300, 1000, baconPaint3);
        canvas.drawRect(700, 200, 800, 1000, baconPaint2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent){
        float xLoc = motionEvent.getX();
        float yLoc = motionEvent.getY();
        int bacColor;

        //check if in bacon #1
        if ((xLoc >= 400)  && (xLoc <= 500) && (yLoc >= 200) && (yLoc <= 1000)){
            currObjTV.setText("Bacon #1");
            bacColor = baconPaint1.getColor();
            int redComp = Color.red(bacColor);
            int greenComp = Color.green(bacColor);
            int blueComp = Color.blue(bacColor);
            redSeek.setProgress(redComp);
            greenSeek.setProgress(greenComp);
            blueSeek.setProgress(blueComp);
        }

        //check if in bacon #2
        else if ((xLoc >= 700)  && (xLoc <= 800) && (yLoc >= 200) && (yLoc <= 1000)){
            currObjTV.setText("Bacon #2");
            bacColor = baconPaint2.getColor();
            int redComp = Color.red(bacColor);
            int greenComp = Color.green(bacColor);
            int blueComp = Color.blue(bacColor);
            redSeek.setProgress(redComp);
            greenSeek.setProgress(greenComp);
            blueSeek.setProgress(blueComp);
        }

        //check if in bacon #3
        else if ((xLoc >= 200)  && (xLoc <= 300) && (yLoc >= 200) && (yLoc <= 1000)){
            currObjTV.setText("Bacon #3");
            bacColor = baconPaint3.getColor();
            int redComp = Color.red(bacColor);
            int greenComp = Color.green(bacColor);
            int blueComp = Color.blue(bacColor);
            redSeek.setProgress(redComp);
            greenSeek.setProgress(greenComp);
            blueSeek.setProgress(blueComp);
        }

        //check if ketchup
        else if(sqrt(Math.pow((550-xLoc),2) + Math.pow((450-yLoc),2))<300){
            currObjTV.setText("Ketchup");
            bacColor = ketchupPaint.getColor();
            int redComp = Color.red(bacColor);
            int greenComp = Color.green(bacColor);
            int blueComp = Color.blue(bacColor);
            redSeek.setProgress(redComp);
            greenSeek.setProgress(greenComp);
            blueSeek.setProgress(blueComp);
        }

        //check if egg
        else if(sqrt(Math.pow((550-xLoc),2) + Math.pow((470-yLoc),2))<400){
            currObjTV.setText("Egg");
            bacColor = eggPaint.getColor();
            int redComp = Color.red(bacColor);
            int greenComp = Color.green(bacColor);
            int blueComp = Color.blue(bacColor);
            redSeek.setProgress(redComp);
            greenSeek.setProgress(greenComp);
            blueSeek.setProgress(blueComp);
        }

        //check if plate
        else if(sqrt(Math.pow((550-xLoc),2) + Math.pow((500-yLoc),2))<500){
            currObjTV.setText("Plate");
            bacColor = platePaint.getColor();
            int redComp = Color.red(bacColor);
            int greenComp = Color.green(bacColor);
            int blueComp = Color.blue(bacColor);
            redSeek.setProgress(redComp);
            greenSeek.setProgress(greenComp);
            blueSeek.setProgress(blueComp);
        }

        else {
            currObjTV.setText("??");
            bacColor = 0;
            redSeek.setProgress(0);
            greenSeek.setProgress(0);
            blueSeek.setProgress(0);
        }

        return true;
    }
}
