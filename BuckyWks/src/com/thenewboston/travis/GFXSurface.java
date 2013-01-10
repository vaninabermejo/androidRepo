package com.thenewboston.travis;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

  MyBringBackSurface ourSurfaceView;
  float x , y;

  /*
   * (non-JaSvadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    ourSurfaceView = new MyBringBackSurface(this);
    ourSurfaceView.setOnTouchListener(this);
    x = 0;
    y = 0;
    setContentView(ourSurfaceView);
  }

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onPause()
   */
  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    ourSurfaceView.pause();
  }

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onResume()
   */
  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    ourSurfaceView.resune();
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    // TODO Auto-generated method stub
    x = event.getX();
    y = event.getY();
    return true;
  }

  public class MyBringBackSurface extends SurfaceView implements Runnable {

    SurfaceHolder ourHolder;
    Thread ourThread = null;
    boolean isRunning = false;

    public MyBringBackSurface(GFXSurface gfxSurface) {
      super(gfxSurface);
      ourHolder = getHolder();

    }

    @Override
    public void run() {
      // TODO Auto-generated method stub
      while (isRunning) {
        if (!ourHolder.getSurface().isValid()) {
          continue;
        }
        Canvas canvas = ourHolder.lockCanvas();
        canvas.drawRGB(2, 2, 150);
        if (x != 0 && y != 0) {
          Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
          canvas.drawBitmap(test, x - (test.getWidth() / 2), y - (test.getHeight() / 2), null);
        }
        ourHolder.unlockCanvasAndPost(canvas);
      }

    }

    public void pause() {
      isRunning = false;
      while (true) {
        try {
          ourThread.join();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      }
      ourThread = null;
    }

    public void resune() {
      isRunning = true;
      ourThread = new Thread(this);
      ourThread.start();

    }

  }

}
