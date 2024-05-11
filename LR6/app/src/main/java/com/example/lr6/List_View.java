package com.example.lr6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class List_View extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);
        String[] countries = getResources().getStringArray(R.array.countries);
        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.icons8};
        CustomArrayAdapter adapter = new CustomArrayAdapter(this,R.layout.list_view_country, R.id.name, countries, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                if (position == 16)
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public class CustomArrayAdapter extends ArrayAdapter<String> {
        private Context context;
        private int[] imageResourceIds;

        public CustomArrayAdapter(Context context, int resource, int textViewResourceId, String[] objects, int[] imageResourceIds) {
            super(context, resource, textViewResourceId, objects);
            this.context = context;
            this.imageResourceIds = imageResourceIds;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.list_view_country, parent, false);

            TextView textView = row.findViewById(R.id.name);
            ImageView imageView = row.findViewById(R.id.image_v);

            textView.setText(getItem(position));

            if (position > 4)
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
            else
                imageView.setImageResource(imageResourceIds[position]);
            if (position == 16)
                imageView.setImageResource(imageResourceIds[5]);

            return row;
        }
    }


}