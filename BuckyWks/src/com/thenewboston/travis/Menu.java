package com.thenewboston.travis;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

  ArrayList<String> classes = new ArrayList<String>();
  {
    classes.add("StartingPoint");
    classes.add("TextPlay");
    classes.add("Email");
    classes.add("Camera");
    classes.add("Data");
    classes.add("GFX");
    classes.add("GFXSurface");
    classes.add("SoundStuff");
    classes.add("Slider");
    classes.add("SQLiteExample");
  }

  /*
   * (non-Javadoc)
   * @see
   * android.app.ListActivity#onListItemClick(android.widget.ListView,
   * android.view.View, int, long)
   */
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    String mainClass = classes.get(position);
    try {
      Class ourClass = Class.forName("com.thenewboston.travis." + mainClass);
      Intent ourIntent = new Intent(Menu.this, ourClass);
      startActivity(ourIntent);

    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));

  }

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
   */
  @Override
  public boolean onCreateOptionsMenu(android.view.Menu menu) {
    // TODO Auto-generated method stub
    super.onCreateOptionsMenu(menu);
    MenuInflater blowup = getMenuInflater();
    blowup.inflate(R.menu.cool_menu, menu);
    return true;

  }

  /*
   * (non-Javadoc)
   * @see
   * android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
   */
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // TODO Auto-generated method stub
    switch (item.getItemId()) {
      case R.id.aboutUs:
        Intent i = new Intent(this, AboutUs.class);
        startActivity(i);
        break;
      case R.id.preferences:
        Intent p = new Intent(this, Prefs.class);
        startActivity(p);
        break;
      case R.id.exit:
        finish();
        break;

    }
    return false;
  }
}
