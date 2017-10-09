package com.bwie.zdyyuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
 
/**
 * Created by Mo on 2017/9/1.
 */


public class Zdyview extends View {
    private int ban=50;
    private int y;
    private int x;

    public Zdyview(Context context) {
        this(context,null);
    }

    public Zdyview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Zdyview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        x= (int) (this.getWidth()/2);
        y= (int) (this.getHeight()/2);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
// 绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint paint=new Paint();
        //设置画笔线宽
        paint.setStrokeWidth(2);
        //设置画笔颜色
        paint.setColor(Color.GREEN);
        //设置抗锯齿
        paint.setAntiAlias(true);

        canvas.drawCircle(x,y,ban,paint);
    }
    //设置触摸事件拖动小圆点


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                int ex = (int) event.getX();
                int ey = (int) event.getY();
                boolean b = onIsBall(ex, ey);
                if(b){
                    Toast.makeText(getContext(), "在范围内", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "在范围外", Toast.LENGTH_SHORT).show();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int emoveY= (int) event.getY();
                int emoveX= (int) event.getX();
            if(onIsBall(emoveX,emoveY)){
              x=emoveX;
             y=emoveY;
                //刷新
                postInvalidate();
            }

                break;
        }
        return true;
    }

    private boolean onIsBall(int ex, int ey) {
        double sqrt = Math.sqrt((ex - x) * (ex - x) + (ey - y) * (ey - y));
        if(sqrt<ban){
            return true;
        }
        return false;
    }
}
