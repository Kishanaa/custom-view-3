package com.aurorasphere.customview3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class CircleView extends View {

    private Paint paint;
    private Random random;
    private int circleColor;    // store custom color

    public CircleView(Context context){
        super(context);
        init(null);
    }
    public CircleView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(attrs);
    }
    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        paint = new Paint();
        paint.setAntiAlias(true);
        random=new Random();

        if (attrs !=null){
            TypedArray typedArray= getContext().obtainStyledAttributes(attrs,R.styleable.CircleView);
            circleColor= typedArray.getColor(R.styleable.CircleView_circleColor, Color.BLUE);   //Default to blue
            typedArray.recycle();   //prevent memory leaks
        }else {
            circleColor=Color.BLUE;
        }
        paint.setColor(circleColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(width / 2, height / 2, radius, paint);
    }

    public void setCircleColor(int color){
        circleColor =color;
        paint.setColor(circleColor);
        invalidate();   // Redraw the view
    }
}
