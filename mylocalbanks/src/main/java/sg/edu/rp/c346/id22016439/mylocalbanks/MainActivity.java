package sg.edu.rp.c346.id22016439.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvdbs;
    TextView tvocbc;
    TextView tvuob;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvdbs = findViewById(R.id.textViewDBS);
        tvocbc = findViewById(R.id.textViewOCBC);
        tvuob = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvdbs);
        registerForContextMenu(tvocbc);
        registerForContextMenu(tvuob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");

        if (v == tvdbs) {
            wordClicked = "dbs";
        } else if (v == tvocbc) {
            wordClicked = "ocbc";
        } else if (v == tvuob) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                tvdbs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //byte, short, int, long
                        Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                        startActivity(intentView);
                    }
                });
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                tvdbs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //byte, short, int, long
                        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                        startActivity(intentCall);
                    }
                });
                return true; //menu item successfully handled
            }

        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                tvocbc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //byte, short, int, long
                        Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                        startActivity(intentView);
                    }
                });
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                tvocbc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                        startActivity(intentCall);
                    }
                });
                return true; //menu item successfully handled
            }
            } else if (wordClicked.equalsIgnoreCase("UOB")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    tvuob.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //byte, short, int, long
                            Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                            startActivity(intentView);
                        }
                    });
                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    tvuob.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                            startActivity(intentCall);
                        }
                    });
                    return true; //menu item successfully handled
                }

        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvdbs.setText("DBS");
            tvocbc.setText("OCBC");
            tvuob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvdbs.setText("星展銀行");
            tvocbc.setText("华侨银行");
            tvuob.setText("大华银行");
            return true;
        } else if (id == R.id.ToggleFavourite) {
            tvdbs.setTextColor(Color.parseColor("#000000"));
            tvocbc.setTextColor(Color.parseColor("#ff0000"));
            tvuob.setTextColor(Color.parseColor("#000000"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}