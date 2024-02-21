package com.example.lr4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Task3 extends AppCompatActivity {
    int count = 0;
    Button button;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);
        button = findViewById(R.id.bt_count);
        Context context = getApplicationContext();
        File internalFolder = context.getFilesDir();

        try {
            file = new File(internalFolder, "file.txt");
            if (file.createNewFile()) {
                Toast.makeText(this,"Файл создан", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Файл уже существует", Toast.LENGTH_SHORT).show();
                Scanner scanner = new Scanner(file);

                count = scanner.nextInt();
                button.setText(count + "");
                scanner.close();
            }
        } catch (IOException e) {
            Toast.makeText(this, "Ошибка при создании файла", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void onClickButton(View view) {
        count++;
        button.setText(count + "");
    }

    public void onSave(View view) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("file.txt", MODE_PRIVATE)));
            bufferedWriter.write(count + "");
            bufferedWriter.close();
            Toast.makeText(this, "Результат сохранен", Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e) {
            Toast.makeText(this, "Файл не найден", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        catch (IOException e) {
            Toast.makeText(this, "Ошибка при сохранении", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}