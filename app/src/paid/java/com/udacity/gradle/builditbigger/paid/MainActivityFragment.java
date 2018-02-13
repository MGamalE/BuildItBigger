package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bakingapp.jokeandroidlibrary.JokeActivity;
import com.udacity.gradle.builditbigger.AsyncTask;
import com.udacity.gradle.builditbigger.IAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainActivityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityFragment extends Fragment  implements IAsyncTask{

    public String joke = null;
    public boolean flag = false;

    Context context;
    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        Button button = (Button) root.findViewById(R.id.joke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });


        return root;
    }

    public void getJoke() {
        new AsyncTask(this).execute(context);
    }
/*
    public void launchDisplayJokeActivity() {

    }
    */


    @Override
    public void IAsyncTask(String result) {
        if (!flag) {
            Context context = getActivity();
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra(context.getString(R.string.jokecontent), joke);
            context.startActivity(intent);
        }
    }
}
