package com.example.lostfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {
    private TextView textViewType, textViewName, textViewDescription, textViewDate, textViewLocation;
    private Button buttonRemove;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Initialize views
        textViewType = findViewById(R.id.textViewType);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewDate = findViewById(R.id.textViewDate);
        textViewLocation = findViewById(R.id.textViewLocation);
        buttonRemove = findViewById(R.id.buttonRemove);

        // Get item details passed from the previous activity
        itemId = getIntent().getIntExtra("ITEM_ID", 0);
        textViewType.setText(getIntent().getStringExtra("ITEM_TYPE"));
        textViewName.setText(getIntent().getStringExtra("ITEM_NAME"));
        textViewDescription.setText(getIntent().getStringExtra("ITEM_DESCRIPTION"));
        textViewDate.setText(getIntent().getStringExtra("ITEM_DATE"));
        textViewLocation.setText(getIntent().getStringExtra("ITEM_LOCATION"));

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem();
            }
        });
    }

    private void removeItem() {
        DatabaseHelper db = new DatabaseHelper(this);
        db.deleteItem(itemId);
        Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
        startActivity(intent);
        finish(); // Close this activity after the item is deleted
    }
}
