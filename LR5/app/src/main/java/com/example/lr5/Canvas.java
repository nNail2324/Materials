package com.example.lr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class Canvas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Picture(this));
    }

    public class Picture extends View {
        int x = 0;
        Paint paint;
        public Picture(Context context) {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(@NonNull android.graphics.Canvas canvas) {
            super.onDraw(canvas);

            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(20);

            Rect rect1 = new Rect(50, 100, getWidth()-50, getHeight()-100);
            canvas.drawRect(rect1, paint);

            paint.setColor(Color.rgb(128, 128, 0));
            paint.setStyle(Paint.Style.FILL);

            Rect rect2 = new Rect(60, 110, getWidth()-60, getHeight()-110);
            canvas.drawRect(rect2, paint);

            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setTextSize(120);
            paint.setStrokeWidth(1);

            canvas.drawText("С днем Лягушки!", 250, getHeight()/2 - 800, paint);

            if (x >= 720) {
                canvas.rotate(0, getWidth()/2, getHeight()/2);
            } else {
                canvas.rotate(x+=2, getWidth()/2, getHeight()/2);
                invalidate();
            }
            // Туловище
            paint.setColor(Color.rgb(0, 128, 0));
            paint.setStyle(Paint.Style.FILL);
            RectF body = new RectF(getWidth()/2 - 300, getHeight()/2 - 150, getWidth()/2 + 300, getHeight()/2 + 150);
            canvas.drawOval(body, paint);

            // Глаза
            paint.setColor(Color.WHITE);
            canvas.drawCircle(getWidth()/2 - 200, getHeight()/2 - 150, 100, paint);
            canvas.drawCircle(getWidth()/2 + 200, getHeight()/2 - 150, 100, paint);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(getWidth()/2 - 200, getHeight()/2 - 150, 50, paint);
            canvas.drawCircle(getWidth()/2 + 200, getHeight()/2 - 150, 50, paint);

            // Улыбка
            paint.setColor(Color.rgb(176, 0, 0));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            RectF smile = new RectF(getWidth()/2 - 100, getHeight()/2 - 50, getWidth()/2 + 100, getHeight()/2 + 100);
            canvas.drawArc(smile, 0, 180, false, paint);

            // Ноги
            paint.setColor(Color.rgb(0, 128, 0));
            paint.setStyle(Paint.Style.FILL);
            RectF leg1 = new RectF(getWidth()/2 - 200, getHeight()/2 + 120, getWidth()/2 - 50, getHeight()/2 + 200);
            RectF leg2 = new RectF(getWidth()/2 + 200, getHeight()/2 + 120, getWidth()/2 + 50, getHeight()/2 + 200);
            canvas.drawOval(leg1, paint);
            canvas.drawOval(leg2, paint);
        }
    }
}