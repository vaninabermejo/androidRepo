package com.thenewboston.travis;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		Button chkCmd=(Button) findViewById(R.id.bResults);
		final ToggleButton  passTog= (ToggleButton)findViewById(R.id.tbPassword);
		final EditText input= (EditText)findViewById(R.id.etCommands);
		final TextView display=(TextView)findViewById(R.id.tvResults);
		passTog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(passTog.isChecked()){
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}else{
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		} );
		chkCmd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String check= input.getText().toString();
				if (check.equalsIgnoreCase("left")){
					display.setGravity(Gravity.LEFT);
				}else if (check.equalsIgnoreCase("center")){
					display.setGravity(Gravity.CENTER);
				}else if (check.equalsIgnoreCase("right")){
					display.setGravity(Gravity.RIGHT);
				}else if (check.equalsIgnoreCase("blue")){
					display.setBackgroundColor(Color.BLUE);
				
				}
			}
		});
	}
	

}
