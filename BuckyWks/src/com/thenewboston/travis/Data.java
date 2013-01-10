package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

  EditText sendET;
  Button start , startFor;
  TextView gotAnswer;

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.get);
    initializeVars();

  }

  private void initializeVars() {
    sendET = (EditText) findViewById(R.id.etSend);
    start = (Button) findViewById(R.id.bSA);
    startFor = (Button) findViewById(R.id.bSAFR);
    gotAnswer = (TextView) findViewById(R.id.tvGot);
    start.setOnClickListener(this);
    startFor.setOnClickListener(this);

  }

  @Override
  public void onClick(View arg0) {
    // TODO Auto-generated method stub
    switch (arg0.getId()) {
      case R.id.bSA:
        String bread = sendET.getText().toString();
        Bundle basket = new Bundle();
        basket.putString("key", bread);
        Intent a = new Intent(this, OpenedClass.class);
        a.putExtras(basket);
        startActivity(a);
        break;
      case R.id.bSAFR:
        Intent i = new Intent(this, OpenedClass.class);
        startActivityForResult(i, 0);
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
    if (RESULT_OK == resultCode) {
      Bundle basket = data.getExtras();
      gotAnswer.setText(basket.getString("answer"));
    }
  }
}
