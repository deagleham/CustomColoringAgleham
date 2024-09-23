package edu.up.customcoloringagleham;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

//@author De'Ante Agleham

public class MainCanvas extends SurfaceView {

    //For our favorite color
    private Paint redPaint;
    private Paint yellowPaint;
    private Paint brownPaint;
    private Paint blackPaint;

    public MainCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        redPaint = new Paint();
        redPaint.setColor(0xFFFF0000);
        redPaint.setStyle(Paint.Style.FILL);

        yellowPaint = new Paint();
        yellowPaint.setColor(0xFFFFFF00);
        yellowPaint.setStyle(Paint.Style.FILL);

        brownPaint = new Paint();
        brownPaint.setColor(0xFF954535);
        brownPaint.setStyle(Paint.Style.FILL);

        blackPaint = new Paint();
        blackPaint.setColor(0xFF000000);
        blackPaint.setStyle(Paint.Style.STROKE);

        setBackgroundColor(0xFFFFFFFF);  //white background
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(550,500,500,blackPaint);
        canvas.drawCircle(550,470,400,yellowPaint);
        canvas.drawCircle(550,450,300,redPaint);
        canvas.drawRect(400, 200, 500, 1000, brownPaint);
        canvas.drawRect(200, 200, 300, 1000, brownPaint);
        canvas.drawRect(700, 200, 800, 1000, brownPaint);
    }
}
