package com.example.onlinegatepasssystem;

import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherLoginActivity extends Activity {

	EditText tusername,tpassword;
	Button tlogin,tregister;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_login);
		
		
		
		  tusername=(EditText)findViewById(R.id.tusername);
	        tpassword=(EditText)findViewById(R.id.tpassword);
	        
	         tlogin=(Button)findViewById(R.id.tlogin);
	         tregister=(Button)findViewById(R.id.tregister);
	        
	        tlogin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					 try {
		                    if (tusername.getText().toString().trim().equalsIgnoreCase("") ||tpassword.getText().toString().trim().equalsIgnoreCase("")) {

		                        Toast.makeText(getApplicationContext(), "Please fill data", Toast.LENGTH_LONG).show();
		                    } else {
		                        HashMap<String, String> param = new HashMap<String, String>();

		                        param.put("username",tusername.getText().toString().trim());
		                        param.put("password",tpassword.getText().toString().trim());

		                      
		                        String id = Network.connect("http://"+Network.IP+"/teacherLog.php", param);
		                        System.out.print("http://" + Network.IP
		                                + "/teacherLog.php");
		                        Toast.makeText(getApplicationContext(), "http://"+Network.IP+"/teacherLog.php", Toast.LENGTH_LONG).show();
		                        id = id.trim();
		                        Toast.makeText(getApplicationContext(), " Login " + id + " ",
		                        		Toast.LENGTH_LONG).show();
		                        if (id.equals("0")) {
		                            Toast.makeText(getApplicationContext(), "Login UnSuccessfully...",
		                                    Toast.LENGTH_SHORT).show();
		                        } else {
//		            String[] sep=id.split(",");
//		            String uid=sep[0].toString();
		                            Toast.makeText(getApplicationContext(), "Login  Successfully...",
		                                    Toast.LENGTH_SHORT).show();
                            Intent in1=new Intent(getApplicationContext(),ViewapplicationActivity.class);
                            startActivity(in1);

		                            finish();
		                        }
		                    }
		                } catch (Exception ex) {

//		                    Toast.makeText(getApplicationContext(), "Please start your Internate or WiFi...", Toast.LENGTH_LONG).show();
		                }
		            }	
					
					
					
					
		
			});
	    
	       
	       tregister.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					
					Intent i=new Intent(getApplicationContext(),TeacherRegistrationActivity.class);
					startActivity(i);
							
					
					
		}
			});
	        
	     
	        
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_login, menu);
		return true;
	}

}
