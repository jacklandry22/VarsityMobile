package edu.elon.cs.varsitymobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MealActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meal, menu);
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

    public void goToDisplayItem(View view){
        Button button = (Button) view;
        String itemName = button.getText().toString();
        String itemDescription = "";

        for (int i = 0; i < ItemDescriptions.mealNames.length; i++) {
            if (itemName.equals(ItemDescriptions.mealNames[i])) {
                itemDescription = ItemDescriptions.mealDescriptions[i];
            }
        }

        Intent intent = new Intent(this, displayItemActivity.class);
        intent.putExtra("item", itemName);
        intent.putExtra("description", itemDescription);
        startActivity(intent);
        this.finish();

    }
    public void goHome(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
