package com.example.lr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

public class Surface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_holder);

        // Создание объекта Animation и добавление его на экран
        Animation animation = new Animation(this);
        addContentView(animation, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    class Animation extends SurfaceView implements SurfaceHolder.Callback {
        private DrawThread drawThread;

        public Animation(Context context) {
            super(context);
            getHolder().addCallback(this);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            // Создание потока
            drawThread = new DrawThread(getHolder());
            drawThread.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            // Изменение SurfaceView
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            // Уничтожение SurfaceView
            boolean retry = true;
            drawThread.setRunning(false);
            while (retry) {
                try {
                    drawThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class DrawThread extends Thread {
        private boolean isRunning;
        private SurfaceHolder surfaceHolder;
        private Paint bubble1, bubble2, bubble3;
        private int position1 = 0, position2 = 0, position3 = 0; // Поле для хранения текущей позиции кругов

        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
            isRunning = true;

            // Выбор стиля и цвета для каждого объекта
            bubble1 = new Paint();
            bubble1.setColor(Color.YELLOW);
            bubble1.setStyle(Paint.Style.FILL);

            bubble2 = new Paint();
            bubble2.setColor(Color.RED);
            bubble2.setStyle(Paint.Style.FILL);

            bubble3 = new Paint();
            bubble3.setColor(Color.GREEN);
            bubble3.setStyle(Paint.Style.FILL);
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }
        int v1 = 50, v2 = 20, v3 = 100;
        @Override
        public void run() {
            while (isRunning) {
                Canvas canvas = null;

                try {
                    canvas = surfaceHolder.lockCanvas();
                    int height = canvas.getHeight();
                    if (canvas != null) {
                        canvas.drawColor(Color.WHITE);
                        if (position1 >= height && v1 > 0 || position1 <= 0 && v1 < 0) {
                            v1 = -v1;
                        }
                        if (position2 >= height && v2 > 0 || position2 <= 0 && v2 < 0) {
                            v2 = -v2;
                        }
                        if (position3 >= height && v3 > 0 || position3 <= 0 && v3 < 0) {
                            v3 = -v3;
                        }
                        drawCircle(canvas, 200, 100, 50, position1 += v1, bubble1);
                        drawCircle(canvas, 550, 150, 150, position2 += v2, bubble2);
                        drawCircle(canvas, 780, 200, 100, position3 += v3, bubble3);

                    }
                } finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void drawCircle(Canvas canvas, int X, int Y, int radius, int position, Paint style) {
            canvas.drawCircle(X, Y + position, radius, style);
        }
    }
}
