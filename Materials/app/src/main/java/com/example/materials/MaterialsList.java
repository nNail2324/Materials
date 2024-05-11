package com.example.materials;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MaterialsList extends Fragment {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materials_list, container, false);

        listView = view.findViewById(R.id.list_view);
        String[] materials = getResources().getStringArray(R.array.materials);

        TypedArray images = getResources().obtainTypedArray(R.array.image);
        int[] image_index = new int[images.length()];
        for (int i = 0; i < images.length(); i++) {
            image_index[i] = images.getResourceId(i, -1);
        }
        images.recycle();

        CustomArrayAdapter adapter = new CustomArrayAdapter(getContext(),R.layout.list_view_simple, R.id.name, materials, image_index);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(getContext(), Description.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        return view;
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
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.list_view_simple, parent, false);

            TextView textView = row.findViewById(R.id.name);
            ImageView imageView = row.findViewById(R.id.image_v);

            textView.setText(getItem(position));
            imageView.setImageResource(imageResourceIds[position]);

            return row;
        }
    }
}