package com.pywl.flydatatext.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class CircleView extends ViewGroup {
    private Paint mCircleRedPaint;
    private Paint mCircleGreenPaint;
    private Paint mLinePaint;
    private float mCenterX;
    private float mCenterY;
    private float mWidth;
    private float mHeight;
    private float mDistance = 0.5f;//最小园代表的距离
    private float rate;//比率，表示l距离所代表的宽
    private int circleCount;//圆的数量

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private void initPaint() {
        mCircleGreenPaint = new Paint();
        mCircleGreenPaint.setAntiAlias(true);
        mCircleGreenPaint.setStyle(Paint.Style.STROKE);
        mCircleGreenPaint.setStrokeWidth(8);
        mCircleGreenPaint.setColor(Color.argb(1, 184, 173, 0));

        mCircleRedPaint = new Paint();
        mCircleRedPaint.setAntiAlias(true);
        mCircleRedPaint.setStyle(Paint.Style.STROKE);
        mCircleGreenPaint.setStrokeWidth(1.0f);
        mCircleRedPaint.setColor(Color.parseColor("#D20000"));

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStrokeWidth(1.0f);
        mLinePaint.setColor(Color.parseColor("#D20000"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mCenterX = mWidth / 2;
        mCenterY = mHeight / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rate = mWidth * 0.5f / mDistance;
        circleCount = (int) (10 / rate);
        Log.e("1111111111","rate="+rate+"----circleCount=="+circleCount);
        for (int i = 0; i < circleCount; i++) {
            canvas.drawCircle(mCenterX, mCenterY, rate + rate * i, mCircleRedPaint);
        }
        float angle = (float) (Math.PI * 2 / 12);
        for (int i = 0; i < 12; i++) {
            float x = (float) (mCenterX + Math.sin(angle * i) * mWidth);
            float y = (float) (mCenterY - Math.cos(angle * i) * mHeight);
            canvas.drawLine(mCenterX, mCenterY, x, y, mLinePaint);
        }
    }

}
