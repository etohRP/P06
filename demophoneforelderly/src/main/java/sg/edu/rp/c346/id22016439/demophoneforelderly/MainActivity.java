package sg.edu.rp.c346.id22016439.demophoneforelderly;

import static android.content.Intent.ACTION_DIAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button peterbutton;
    Button marybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peterbutton = findViewById(R.id.buttonCallSon);
        marybutton = findViewById(R.id.buttonCallDaughter);

        registerForContextMenu(peterbutton);
        registerForContextMenu(marybutton);

        peterbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+92240336));
            startActivity(intentCall);
        }
         });
        marybutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+89675543));
            startActivity(intentCall);
        }
        });
        }
        }