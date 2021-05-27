package sg.edu.rp.c346.id20006949.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textdbs;
    TextView textocbc;
    TextView textuob;
    boolean favdbs = false;
    boolean favocbc = false;
    boolean favuob = false;
    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textdbs = findViewById(R.id.textdbs);
        textocbc = findViewById(R.id.textocbc);
        textuob = findViewById(R.id.textuob);
        registerForContextMenu(textdbs);
        registerForContextMenu(textuob);
        registerForContextMenu(textocbc);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
        if (view == textdbs) {
            wordClicked = "dbs";
        } if (view == textocbc) {
            wordClicked = "ocbc";
        }else if(view == textuob){
            wordClicked = "uob";
        }
    }

    @Override

    public boolean onContextItemSelected(MenuItem item) {
    int id = item.getItemId();
    if(wordClicked.equalsIgnoreCase("DBS")) {
        if (id == R.id.WebsiteSelection) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsurl)));
            startActivity(intent);
            return true;
        } else if (id == R.id.ContactSelection) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + (getString(R.string.dbsno))));
            startActivity(intentCall);
            return true;
        }else{
            if (!favdbs ){
                favdbs = true;
                textdbs.setTextColor(Color.RED);
            }else {
                favdbs = false;
                textdbs.setTextColor(Color.BLACK);
            }
        }
    }
    else  if(wordClicked.equalsIgnoreCase("OCBC")) {
        if (id == R.id.WebsiteSelection) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcurl)));
            startActivity(intent);
            return true;
        } else if (id == R.id.ContactSelection) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + (getString(R.string.ocbcno))));
            startActivity(intentCall);
            return true;
        }else{
            if (!favocbc){
                favocbc = true;
                textocbc.setTextColor(Color.RED);
            }else {
                favocbc = false;
                textocbc.setTextColor(Color.BLACK);
            }
        }
    }
    else   if(wordClicked.equalsIgnoreCase("UOB")) {
        if (id == R.id.WebsiteSelection) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uoburl)));
            startActivity(intent);
            return true;
        } else if (id == R.id.ContactSelection) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobno)));
            startActivity(intentCall);
            return true;
        }else{
            if (!favuob){
                favuob = true;
                textuob.setTextColor(Color.RED);
            }else {
                favuob = false;
                textuob.setTextColor(Color.BLACK);
            }
        }
    }

    return super.onContextItemSelected(item);

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textdbs.setText(getString(R.string.dbs));
            textocbc.setText(getString(R.string.ocbc));
            textuob.setText(getString(R.string.uob));
        } else if (id == R.id.ChineseSelection) {
            textdbs.setText(getString(R.string.dbsc));
            textocbc.setText(getString(R.string.ocbcc));
            textuob.setText(getString(R.string.uobc));

        } else {
            textdbs.setText("Error translation");
            textocbc.setText("Error translation");
            textuob.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

}


