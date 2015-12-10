package edu.elon.cs.varsitymobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class displayItemActivity extends Activity {

    protected static ArrayList<String> order = new ArrayList<String>();
    protected String itemName;
    protected TextView optionsBox;
    protected Spinner sideSelector;
    protected static boolean notEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        Intent intent = getIntent();
        itemName = intent.getStringExtra("item");
        TextView itemTitle = (TextView) findViewById(R.id.itemName);
        itemTitle.setText(itemName);

        String itemDescription = intent.getStringExtra("description");
        TextView itemDescriptionBox = (TextView) findViewById(R.id.itemDescription);
        itemDescriptionBox.setText(itemDescription);

        TextView optionsTitle = (TextView) findViewById(R.id.optionsTitle);
        optionsBox = (TextView) findViewById(R.id.options);

        if(Arrays.asList(ItemDescriptions.optionItems).contains(itemName)) {
            optionsBox.setVisibility(View.VISIBLE);
            optionsTitle.setVisibility(View.VISIBLE);
        }

        TextView sideTitle = (TextView) findViewById(R.id.sideSelect);
        sideSelector = (Spinner) findViewById(R.id.side);

        if(Arrays.asList(ItemDescriptions.sideItems).contains(itemName)) {
            sideTitle.setVisibility(View.VISIBLE);
            sideSelector.setVisibility(View.VISIBLE);
        }

    }

    public void goHome(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.finish();
    }
    public void addToOrder(View view){

        notEmpty = true;


        order.add(itemName);
        if(!optionsBox.getText().toString().equals("")){

            String options = optionsBox.getText().toString();
            order.add("*" + options);
        }
        if(Arrays.asList(ItemDescriptions.sideItems).contains(itemName)) {
            String side = String.valueOf(sideSelector.getSelectedItem());
            order.add("*" + side);
        }
        order.add("\n");


//        String options = optionsBox.getText().toString();
//        if(!options.equals(null)) {
//            order.add("*" + options + "\n");
//        }

        Toast.makeText(getApplicationContext(), itemName + " has been added to your order",
                Toast.LENGTH_SHORT).show();

    }

    public void placeOrder(View view){




            Intent intent = new Intent(this, showOrder.class);
            intent.putExtra("order", order);

            startActivity(intent);
            this.finish();


    }
}


