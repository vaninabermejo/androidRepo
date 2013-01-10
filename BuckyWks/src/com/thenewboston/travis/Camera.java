package com.thenewboston.travis;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements OnClickListener {

  ImageView iv;
  Button b;
  ImageButton ib;
  Intent i;
  final int cameraData = 0;
  Bitmap bmp;

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.photo);
    initializeVars();
    InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
    bmp = BitmapFactory.decodeStream(is);

  }

  private void initializeVars() {
    iv = (ImageView) findViewById(R.id.ivReturnedPic);
    b = (Button) findViewById(R.id.bSetWall);
    ib = (ImageButton) findViewById(R.id.ibTakePic);
    b.setOnClickListener(this);
    ib.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    // TODO Auto-generated method stub
    switch (v.getId()) {
      case R.id.bSetWall:
        try {
          getApplicationContext().setWallpaper(bmp);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      case R.id.ibTakePic:
        i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, cameraData);
        break;
    }

  }

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onActivityResult(int, int,
   * android.content.Intent)
   */
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // TODO Auto-generated method stub
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
      Bundle extras = data.getExtras();
      bmp = (Bitmap) extras.get("data");
      iv = setImageBitmap(bmp);
    }
  }

  private ImageView setImageBitmap(Bitmap bmp2) {
    // TODO Auto-generated method stub
    return null;
  }
}
