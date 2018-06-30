package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MyOnItemClickListener mMyOnItemClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // Create an array of words
        ArrayList<Word> words = new ArrayList<>();
            words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
            words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
            words.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
            words.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
            words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
            words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
            words.add(new Word("dusty yellow", "topiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
            words.add(new Word("mustard yellow", "hiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this,  words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listlayout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        mMyOnItemClickListener = new MyOnItemClickListener(this, words);
        listView.setOnItemClickListener(mMyOnItemClickListener);



    }

    @Override
    protected void onStop() {
        super.onStop();
        mMyOnItemClickListener.releaseMediaPlayer();
    }
}