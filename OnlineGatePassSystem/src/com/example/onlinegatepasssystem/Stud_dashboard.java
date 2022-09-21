package com.example.onlinegatepasssystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Stud_dashboard extends Activity {
	Button bt_addapp, bt_Viewstate,help;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stud_dashboard);
		bt_addapp=(Button)findViewById(R.id.bt_addapp);
		bt_Viewstate=(Button)findViewById(R.id.bt_Viewstate);
		help=(Button)findViewById(R.id.btnhelp);
		bt_addapp.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),AddapplicationActivity.class);
				startActivity(i);
			}
		});
		
		help.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Help.class);
				startActivity(i);
			}
		});
		bt_Viewstate.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View arg0) {
				Intent i=new Intent(getApplicationContext(),StudentStatusActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stud_dashboard, menu);
		return true;
	}

}
