package edu.elon.cs.varsitymobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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

    public void goToAppetizers(View view){
        Intent intent = new Intent(this, AppetizerActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void goToMeals(View view){
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void goToDesserts(View view){
        Intent intent = new Intent(this, DessertActivity.class);
        startActivity(intent);
        this.finish();
    }
}
