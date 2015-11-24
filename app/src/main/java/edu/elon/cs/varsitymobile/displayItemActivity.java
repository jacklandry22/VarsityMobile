package edu.elon.cs.varsitymobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class displayItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        Intent intent = getIntent();
        String itemName = intent.getStringExtra("item");
        TextView textView = (TextView) findViewById(R.id.itemName);
        textView.setText(itemName);

    }

    public void goHome(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
