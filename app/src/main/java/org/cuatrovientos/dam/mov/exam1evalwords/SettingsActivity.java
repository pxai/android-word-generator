package org.cuatrovientos.dam.mov.exam1evalwords;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;


/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends PreferenceActivity {
    Button botonmenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
        setContentView(R.layout.preferences_layout);
        botonmenu = (Button) this.findViewById(R.id.botonmenu);
        botonmenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent miIntent = new Intent(SettingsActivity.this, MenuActivity.class);
                startActivity(miIntent);
                SettingsActivity.this.finish();
            }
        });
    }
}