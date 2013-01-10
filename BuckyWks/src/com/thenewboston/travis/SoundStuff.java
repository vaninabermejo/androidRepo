package com.thenewboston.travis;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener {

  int explosion;
  SoundPool sP;
  MediaPlayer mP;

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    View v = new View(this);
    v.setOnClickListener(this);
    v.setOnLongClickListener(this);
    sP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    explosion = sP.load(this, R.raw.explosion, 1);
    mP = MediaPlayer.create(this, R.raw.gallina);
    setContentView(v);
  }

  @Override
  public void onClick(View arg0) {
    // TODO Auto-generated method stub
    if (explosion != 0) {
      sP.play(explosion, 1, 1, 0, 0, 1);
    }
  }

  @Override
  public boolean onLongClick(View arg0) {
    // TODO Auto-generated method stub\
    mP.start();
    return false;
  }

}
