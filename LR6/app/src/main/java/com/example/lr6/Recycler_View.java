package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recycler_View extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Country> arrayList = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        String[] countries = getResources().getStringArray(R.array.countries);
        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.icons8};
        setInitialData(countries, images);
        recyclerView = findViewById(R.id.rv);
        Adapter adapter = new Adapter(this,arrayList);

        recyclerView.setAdapter(adapter);
    }


    private void setInitialData(String[] countries, int[] images){
        for (int i = 0; i < countries.length; i++){
            if (i > 4)
                arrayList.add(new Country (countries[i], R.drawable.ic_launcher_foreground));
            else
                arrayList.add(new Country (countries[i], images[i]));
            if (i == 16) {
                arrayList.add(new Country(countries[16], images[5]));
            }
        }
    }

    public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{

        private final LayoutInflater inflater;
        private final List<Country> states;

        Adapter(Context context, List<Country> states) {
            this.states = states;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.list_view_country, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
            Country country = states.get(position);
            holder.imageView.setImageResource(country.getFlagResource());
            holder.textView.setText(country.getName());
        }

        @Override
        public int getItemCount() {
            return states.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView imageView;
            final TextView textView;
            ViewHolder(View view){
                super(view);
                imageView = view.findViewById(R.id.image_v);
                textView = view.findViewById(R.id.name);
            }
        }
    }
}
