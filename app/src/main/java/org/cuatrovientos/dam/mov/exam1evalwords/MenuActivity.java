package org.cuatrovientos.dam.mov.exam1evalwords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            String[] items = { "","","" };

            ListView menuLista = (ListView) findViewById(R.id.ListView_Menu);
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                    R.layout.menu_item, items);

            menuLista.setAdapter(adaptador);


            menuLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View itemClicked,
                                        int position, long id) {
                    TextView textView = (TextView) itemClicked;
                    switch(position) {
                        case 0:
                           startActivity(new Intent(MenuActivity.this,
                                    WordsActivity.class));
                            break;
                        case 1:

                        startActivity(new Intent(MenuActivity.this,
                                WordsCustomActivity.class));
                            break;
                        case 2:

                            startActivity(new Intent(MenuActivity.this,
                                    SettingsActivity.class));
                            break;
                        case 3:

                            startActivity(new Intent(MenuActivity.this,
                                    AboutActivity.class));
                            break;
                        default:
                            break;
                    }
                }
            });


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
}
