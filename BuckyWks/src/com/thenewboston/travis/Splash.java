package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {

  private MediaPlayer ourSong;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    SharedPreferences shpref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    Boolean music = shpref.getBoolean("checkbox", true);
    ourSong = MediaPlayer.create(Splash.this, R.raw.gallina);
    if (music) {

      ourSong.start();
    }

    Thread timer = new Thread() {

      public void run() {
        try {
          sleep(5000);

        } catch (InterruptedException e) {
          e.printStackTrace();

        } finally {
          // Intent openStartingPoint= new
          // Intent("com.thenewboston.travis.STARTINGPOINT");
          // startActivity(openStartingPoint);
          startActivity(new Intent(Splash.this, Menu.class));

        }
      }
    };
    timer.start();
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    ourSong.release();
    finish();
  }
}
