package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Anas on 09/07/2018.
 * This Activity is used as a parent activity for the Miwok Words activity, this will reduce the
 * code repetition in the child classes, child classes must implement the getWords() method to
 * return an ArrayList(Word) that returns their own words list, and the getListItemColor() to
 * return their list item color
 */
public abstract class WordsParentActivity extends AppCompatActivity {
    AdapterViewOnItemClickListener mMyOnItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words = getWords();

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =  new WordAdapter(this,  words,getListItemColor());


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listlayout file.
        ListView listView = (ListView) findViewById(R.id.list);


        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        mMyOnItemClickListener = new AdapterViewOnItemClickListener(this, words);
        listView.setOnItemClickListener(mMyOnItemClickListener);



    }

    @Override
    protected void onStop() {
        super.onStop();
        mMyOnItemClickListener.releaseMediaPlayer();
    }

    public abstract int getListItemColor();
    public abstract ArrayList<Word> getWords();

}
