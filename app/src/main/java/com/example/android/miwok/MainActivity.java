/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        attachActivityToViewOnClickListener(R.id.numbers, NumbersActivity.class);
        attachActivityToViewOnClickListener(R.id.colors, ColorsActivity.class);
        attachActivityToViewOnClickListener(R.id.family, FamilyActivity.class);
        attachActivityToViewOnClickListener(R.id.phrases, PhrasesActivity.class);

    }

    /**
     * Attach an Activity to open to the OnClickListener of a View
     * @param id The id of the clicked View
     * @param cls The Activity Class to open when the View is clicked
     */
        public void attachActivityToViewOnClickListener(int id, final Class<?> cls){
            // Find the View from the given id
            View category =  findViewById(id);

            // Set a click listener on that View
            if (category != null) {
                category.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Create an explicit intent for the given activity
                        Intent intent = new Intent(MainActivity.this, cls);
                        startActivity(intent);
                    }


                });
            }
    }




}
