package sg.edu.rp.c346.democontextmenutranslation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.TextviewTranslatedText);
        registerForContextMenu(tvTranslatedText);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

       // menu.add(0,0,2,"English");
       // menu.add(0,1,99,"Italian");

        getMenuInflater().inflate(R.menu.menu_main, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        //if( id == 0 ){
        if(id == R.id.EnglishSelection) { //check whether the selected menu item ID is 0
            //code for action
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            tvTranslatedText.setText("Hello");
            return true; //menu item successfully handled
        }
        //else if(id == 1) {
        else if(id == R.id.italianSelection) { //check if the selected menu item ID is 1
            //code for action
            Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
            tvTranslatedText.setText("Ciao");
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
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
            tvTranslatedText.setText("Hello ");
            return true;
        }else if (id == R.id.italianSelection) {
            tvTranslatedText.setText("Ciao");
            return true;
        }else  {
            tvTranslatedText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }



}
