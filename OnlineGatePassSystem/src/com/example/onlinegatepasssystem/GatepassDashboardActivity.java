package com.example.onlinegatepasssystem;



import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class GatepassDashboardActivity extends Activity {

	ImageView stud,teacher,parent,Security,hod;
	
	
	
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gatepass_dashboard);
		
		
       stud=(ImageView)findViewById(R.id.stud1);
        teacher=(ImageView)findViewById(R.id.teacher);
      hod=(ImageView)findViewById(R.id.hod);
     parent  =(ImageView)findViewById(R.id.parent);
     Security  =(ImageView)findViewById(R.id.secimm);
     
     
     
        
       stud.setOnClickListener(new OnClickListener() {
		
	
		public void onClick(View v) {
		Intent in1=new Intent(getApplicationContext(),StudentLoginActivity.class);
			
			startActivity(in1);
			
			
			
		}
	});
 teacher.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View arg0) {
				
				Intent in1=new Intent(getApplicationContext(),TeacherLoginActivity.class);
				startActivity(in1);
				
				
			}
		});
		
 hod.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
			Intent in1=new Intent(getApplicationContext(),HodLoginActivity.class);
			startActivity(in1);
			
		
			
		}
	});
	
 Security.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
			
			Intent in1=new Intent(getApplicationContext(),SecurityLoginActivity.class);
			startActivity(in1);
			
			
		}
	});
// 
// 
 parent.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
		
			Intent in1=new Intent(getApplicationContext(),ParentLoginActivity.class);
			startActivity(in1);
			
			
			
		}
	});
//	
	
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gatepass_dashboard, menu);
		return true;
	}

}
