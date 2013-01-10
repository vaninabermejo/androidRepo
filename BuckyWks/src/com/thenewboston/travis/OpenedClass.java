package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener {

  TextView question , test;
  Button returnData;
  RadioGroup selectionList;
  String gotBread = null;
  String setData = null;

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.send);
    initializeVars();
    getData();
  }

  private void getData() {
    // TODO Auto-generated method stub
    Bundle gotBasket = getIntent().getExtras();
    if (gotBasket != null) {

      gotBread = gotBasket.getString("key");
      question.setText(gotBread);
    }
  }

  private void initializeVars() {

    returnData = (Button) findViewById(R.id.bReturn);
    question = (TextView) findViewById(R.id.tvQuestion);
    test = (TextView) findViewById(R.id.tvText);
    returnData.setOnClickListener(this);
    selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
    selectionList.setOnCheckedChangeListener(this);

  }

  @Override
  public void onClick(View v) {
    // TODO Auto-generated method stub
    Intent person = new Intent();
    Bundle backpack = new Bundle();
    backpack.putString("answer", setData);
    person.putExtras(backpack);
    setResult(RESULT_OK, person);
    finish();

  }

  @Override
  public void onCheckedChanged(RadioGroup arg0, int arg1) {
    // TODO Auto-generated method stub

    switch (arg1) {
      case R.id.rCrazy:
        setData = "probably right!!";
        break;
      case R.id.rSexy:
        setData = "sure!!";
        break;
      case R.id.rBoth:
        setData = "je totally right!!";
        break;
    }
    test.setText(setData);
  }

}
