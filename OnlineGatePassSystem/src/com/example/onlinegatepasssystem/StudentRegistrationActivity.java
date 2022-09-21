package com.example.onlinegatepasssystem;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class StudentRegistrationActivity extends Activity {

	private String Name,Email,Mobile,Username,Password,clg,addrss;
	
	EditText  studename,studemob,studeemail,studuname,studepass,studeclg1,studadd,etroll;
	Button studRegister;
	Spinner spinnyear,spinnbranch;
	String branch,year;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_registration);
		
		studename= (EditText) findViewById(R.id.studename);
		etroll=(EditText)findViewById(R.id.et_roll);
		studemob = (EditText) findViewById(R.id.studemob);
	 
	 studeemail=(EditText)findViewById(R.id.studeemail);
	 studuname = (EditText) findViewById(R.id.studuname);
	 studeclg1 = (EditText) findViewById(R.id.studeclg1);
	 studadd= (EditText) findViewById(R.id.studadd);
      studepass= (EditText) findViewById(R.id.studepass);
      spinnyear = (Spinner)findViewById(R.id.spinnyear);
      spinnbranch = (Spinner)findViewById(R.id.spinnyear);
         studRegister = (Button)findViewById(R.id.studRegister);
         
         spinnbranch.setOnItemSelectedListener(new OnItemSelectedListener() {

		 		@Override
		 		public void onItemSelected(AdapterView<?> pre, View arg1, int pos,
		 				long arg3) {
		 			// TODO Auto-generated method stub
//		 			Toast.makeText(getApplicationContext(), "value"+pos, Toast.LENGTH_LONG).show();
//		 			Toast.makeText(getApplicationContext(), "value"+pre.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
		 		
		 		branch=pre.getItemAtPosition(pos).toString();
		 		}

		 		
		 		public void onNothingSelected(AdapterView<?> arg0) {
		 			// TODO Auto-generated method stub
		 			
		 		}
		 	});
		     
		     spinnyear.setOnItemSelectedListener(new OnItemSelectedListener() {

			 		@Override
			 		public void onItemSelected(AdapterView<?> pre, View arg1, int pos,
			 				long arg3) {
			 			// TODO Auto-generated method stub
//			 			Toast.makeText(getApplicationContext(), "value"+pos, Toast.LENGTH_LONG).show();
//			 			Toast.makeText(getApplicationContext(), "value"+pre.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
			 		
			 		year=pre.getItemAtPosition(pos).toString();
			 		}

			 		
			 		public void onNothingSelected(AdapterView<?> arg0) {
			 			// TODO Auto-generated method stub
			 			
			 		}
			 	});
		
	   studRegister.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
			
			
                     Name = studename.getText().toString().trim();
				    Email = studeemail.getText().toString().trim();
				    Mobile = studemob.getText().toString().trim();
				     Username=studuname.getText().toString().trim();
				    Password=studepass.getText().toString().trim();
				    clg=studeclg1.getText().toString().trim();
				    addrss=studadd.getText().toString().trim();
				    String roll=etroll.getText().toString().trim();
				     branch=spinnbranch.getSelectedItem().toString();
				     year=spinnyear.getSelectedItem().toString();
				     
				    
  if (studename.getText().toString().trim().equalsIgnoreCase("") ||studadd.getText().toString().trim().equalsIgnoreCase("")||studeemail.getText().toString().trim().equalsIgnoreCase("") || studemob.getText().toString().trim().equalsIgnoreCase("")||studuname.getText().toString().trim().equalsIgnoreCase("") ||studepass.getText().toString().trim().equalsIgnoreCase("") ||studeclg1.getText().toString().trim().equalsIgnoreCase(""))
				    {
				        Toast.makeText(getApplicationContext(), "please fill data", Toast.LENGTH_LONG).show();
				    }
				    else
				    {
				        HashMap<String, String> param = new HashMap<String, String>();

				        param.put("name", studename.getText().toString().trim());
				        param.put("address", studadd.getText().toString().trim());
				      
				        param.put("mobile",   studemob.getText().toString().trim());
				        param.put("email",    studeemail.getText().toString().trim());
				        param.put("roll",    etroll.getText().toString().trim());
				        param.put("username", studuname.getText().toString().trim());
				        param.put("password", studepass.getText().toString().trim());
				        param.put("collegename", studeclg1.getText().toString().trim());
				        param.put("branch",spinnbranch.getSelectedItem().toString());
					     param.put("year",spinnyear.getSelectedItem().toString());
				       
				       

				        
				     String id = Network.connect("http://" + Network.IP
				                + "/StudentReg.php", param);
				        System.out.print("http://" + Network.IP
				                + "/getEntry.php");
				        id = id.trim();
			        Toast.makeText(getApplicationContext(), " Login " + id + " ",
			                Toast.LENGTH_LONG).show();

				        if (id.equals("0"))
				        {

				            Toast.makeText(getApplicationContext(), " Student  Registration  Not Successfully...",
				                    Toast.LENGTH_SHORT).show();
				        }
				        else {
				
				            Toast.makeText(getApplicationContext(), "Student Registration  Successfully...",
				                    Toast.LENGTH_SHORT).show();


				            finish();
				        }
				    }

			
		}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_registration, menu);
		return true;
	}

}
