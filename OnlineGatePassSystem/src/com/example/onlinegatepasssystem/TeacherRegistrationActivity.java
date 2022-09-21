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

public class TeacherRegistrationActivity extends Activity {
	
	private String Name,Email,Mobile,Username,Password;
	EditText tname,temail,tuname,tpass,tmobile;
	Spinner spinbranch;
	Button tRegister;
     String dpt;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_registration);
		
		tname= (EditText) findViewById(R.id.tname);
		 spinbranch= (Spinner) findViewById(R.id.spinbranch);
		tmobile = (EditText) findViewById(R.id.tmobile);
	
	 temail=(EditText)findViewById(R.id.temail);
	 tuname = (EditText) findViewById(R.id.tuname);
      tpass= (EditText) findViewById(R.id.tpass);
		
         tRegister = (Button)findViewById(R.id.tRegister);
         
         
         spinbranch.setOnItemSelectedListener(new OnItemSelectedListener() {

      		@Override
      		public void onItemSelected(AdapterView<?> pre, View arg1, int pos,
      				long arg3) {
      			// TODO Auto-generated method stub
//      			Toast.makeText(getApplicationContext(), "value"+pos, Toast.LENGTH_LONG).show();
//      			Toast.makeText(getApplicationContext(), "value"+pre.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
      		
      		dpt=pre.getItemAtPosition(pos).toString();
      		}

      		@Override
      		public void onNothingSelected(AdapterView<?> arg0) {
      			
      			
      		}
      	});
          
         
         
         
     tRegister.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
                  Name = tname.getText().toString().trim();
				    Email = temail.getText().toString().trim();
				    Mobile = tmobile.getText().toString().trim();
				    
				  
				    Username=tuname.getText().toString().trim();
				    Password=tpass.getText().toString().trim();
				   
				   

				    if ( tname.getText().toString().trim().equalsIgnoreCase("") ||temail.getText().toString().trim().equalsIgnoreCase("") || tmobile.getText().toString().trim().equalsIgnoreCase("")||tuname.getText().toString().trim().equalsIgnoreCase("") ||tpass.getText().toString().trim().equalsIgnoreCase("") )
				    {
				        Toast.makeText(getApplicationContext(), "please fill data", Toast.LENGTH_LONG).show();
				    }
		
			    else
				    {
			        HashMap<String, String> param = new HashMap<String, String>();

			        param.put("name",        tname.getText().toString().trim());
			        param.put("dpt",         dpt.trim());
			        param.put("mobile",     tmobile.getText().toString().trim());
				        param.put("email",    temail.getText().toString().trim());
				        param.put("username", tuname.getText().toString().trim());
				        param.put("password", tpass.getText().toString().trim());
				       
				       
				      String id = Network.connect("http://" + Network.IP
				                + "/TeacherReg.php", param);
				        System.out.print("http://" + Network.IP
			                + "/getEntry.php");
			        id = id.trim();
				        Toast.makeText(getApplicationContext(), " Login " + id + " ",
			                Toast.LENGTH_LONG).show();

				        if (id.equals("0"))
				        {

				            Toast.makeText(getApplicationContext(), " Teacher  Registration  Not Successfully...",
				                    Toast.LENGTH_SHORT).show();
				        }
				        else {

				
				            Toast.makeText(getApplicationContext(), "Teacher Registration  Successfully...",
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
		getMenuInflater().inflate(R.menu.teacher_registration, menu);
		return true;
	}

}
