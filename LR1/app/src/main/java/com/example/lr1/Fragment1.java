package com.example.lr1;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    final String name = "fragment";

    public void onAttach (Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), name + " is attached", Toast.LENGTH_SHORT).show();
        Log.d(name, "attach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), name + " is created", Toast.LENGTH_SHORT).show();
        Log.d(name, "create");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        Toast.makeText(getContext(), name + " is create view", Toast.LENGTH_SHORT).show();
        Log.d(name, "createview");
        return inflater.inflate(R.layout.fragment_1, null);
    }

    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        Toast.makeText(getContext(), name + " is activity created", Toast.LENGTH_SHORT).show();
        Log.d(name, "activitycreate");
    }

    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), name + " is started", Toast.LENGTH_SHORT).show();
        Log.d(name, "start");
    }

    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), name + " is resumed", Toast.LENGTH_SHORT).show();
        Log.d(name, "resume");
    }

    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), name + " is paused", Toast.LENGTH_SHORT).show();
        Log.d(name, "pause");
    }

    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), name + " is stoped", Toast.LENGTH_SHORT).show();
        Log.d(name, "stop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), name + " is destroied view", Toast.LENGTH_SHORT).show();
        Log.d(name, "destroyview");
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), name + " is destroied", Toast.LENGTH_SHORT).show();
        Log.d(name, "destroy");
    }

    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), name + " is detached", Toast.LENGTH_SHORT).show();
        Log.d(name, "detach");
    }
}