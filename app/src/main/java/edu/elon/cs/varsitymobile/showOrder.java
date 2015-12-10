package edu.elon.cs.varsitymobile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class showOrder extends Activity {
    protected String emailBody ="";
    protected TextView orderName;
    protected String name;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);

        TextView textView = (TextView) findViewById(R.id.orderBody);

        orderName = (TextView) findViewById(R.id.nameBox);


        for (String item : displayItemActivity.order){
            textView.append(item + "\n");

        }

    }

    public void submitOrder(View view) {

        if (displayItemActivity.notEmpty == false) {
            Toast.makeText(getApplicationContext(), "You must add an item to your " +
                            "order before you can submit the oder",
                    Toast.LENGTH_SHORT).show();
        } else {
            name = orderName.getText().toString();

            if (name.trim().equals("")) {
                Toast.makeText(getApplicationContext(), "Enter your name to submit order",
                        Toast.LENGTH_SHORT).show();
            } else {


                for (String item : displayItemActivity.order) {
                    if (!item.equals(null)) {
                        emailBody += item + "\n";
                    }

                }


                Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));

                // prompts email clients only
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"dpetroni@elon.edu"});
                email.putExtra(Intent.EXTRA_SUBJECT, "New Order for " + name);
                email.putExtra(Intent.EXTRA_TEXT, "ORDER: " + "\n" + emailBody);
                try {
                    // the user can choose the email client
                    startActivity(Intent.createChooser(email, "Choose an email client from..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "No email client installed.",
                            Toast.LENGTH_LONG).show();
                }
                displayItemActivity.order.clear();
            }


        }
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
