package edu.elon.cs.varsitymobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AppetizerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appetizer, menu);
        return true;
    }



    public void goToDisplayItem(View view){
        Button button = (Button) view;
        String itemName = button.getText().toString();
        String itemDescription = "";

        for (int i = 0; i < ItemDescriptions.appetizerNames.length; i++) {
            if (itemName.equals(ItemDescriptions.appetizerNames[i])) {
                itemDescription = ItemDescriptions.appetizerDescriptions[i];
            }
        }

        //Do the same for description

        Intent intent = new Intent(this, displayItemActivity.class);
        intent.putExtra("item", itemName);
        intent.putExtra("description", itemDescription);
        //Do the same for description
        startActivity(intent);
        this.finish();

    }
    public void goHome(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
