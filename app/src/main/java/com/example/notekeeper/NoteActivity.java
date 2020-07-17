package com.example.notekeeper;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //requesting reference to spinner
        Spinner spinnerCourses = findViewById(R.id.spinner_courses);

        //creating a generic list with a variable courses
        List<CourseInfo> courses = DataManager.getInstance().getCourses();
        //using an adapter to move the spinner data over(there are many adapters that can be used)
        //after new ArrayAdapter you can press ctr+ p to see the different overloads that are available; here we used one that -
        //required 3 parameters; a context(where we used our current activity;this), a resource and the list we want to pass in
        ArrayAdapter<CourseInfo> adapterCourses = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,courses);
        //the resource above will be used to format our selected course
        //below is our resource for the dropdown list of courses
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Link the spinner to our adapter
        spinnerCourses.setAdapter(adapterCourses);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}