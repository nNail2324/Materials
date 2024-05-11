package com.example.lr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkManagerInitializer;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.lang.Runnable;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    Button button;
    MainThread mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBt1(View view) {
        Toast.makeText(this, ++count + "", Toast.LENGTH_SHORT).show();
    }

    public void onClickBt2(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("thread", "start_thread");
//                button = findViewById(R.id.bt2);
                long f = 0;

                for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; f += i++);
//                button.setText("Готово\n" + f);
                Log.d("thread", "finish");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void onClickAsync(View view) {
//        mt = new MainThread();
//        mt.execute();
        WorkRequest wr = new OneTimeWorkRequest.Builder(WManager.class).build();
        WorkManager.getInstance(MainActivity.this).enqueue(wr);
    }
    public class MainThread extends AsyncTask<Void, Void, Long> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d("thread", "start_thread");
            Toast.makeText(MainActivity.this, "Запуск", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Long doInBackground(Void... voids) {
            long f = 0;
            button = findViewById(R.id.bt2);

            for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; f += i++);
            button.setText("Готово " + f);
            return null;
        }

        @Override
        protected void onPostExecute(Long unused) {
            super.onPostExecute(unused);

            Log.d("thread", "start_thread");
            Toast.makeText(MainActivity.this, "Готово", Toast.LENGTH_SHORT).show();
        }
    }

    public class WManager extends Worker {
        public WManager(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        @NonNull
        @Override
        public Result doWork() {
            long f = 0;
            Log.d("manager", "start");
            for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; f += i++);
            button = findViewById(R.id.bt2);
            button.setText("Готово " + f);
            return Result.success();
        }

    }
    public void onClickCanvas(View view) {
        startActivity(new Intent(this, Canvas.class));
    }

    public void onClickSurface(View view) {
        startActivity(new Intent(this, Surface.class));
    }
}