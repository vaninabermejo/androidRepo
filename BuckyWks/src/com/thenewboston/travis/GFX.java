package com.thenewboston.travis;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {

  MyBringBack ourView;
  WakeLock wL;

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    // wake lock
    PowerManager pW = (PowerManager) getSystemService(Context.POWER_SERVICE);
    wL = pW.newWakeLock(PowerManager.FULL_WAKE_LOCK, "wakelock");

    super.onCreate(savedInstanceState);
    wL.acquire();
    ourView = new MyBringBack(this);
    setContentView(ourView);

  }
}
