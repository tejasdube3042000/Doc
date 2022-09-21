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

public class StudentLoginActivity extends Activity {

	
	EditText  studname,studpass;
	Button studregister,studlogin;
	public static String name;
	
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_login);
		
		 studname=(EditText)findViewById(R.id.studname);
	      studpass=(EditText)findViewById(R.id.studpass);
	        

        studlogin=(Button)findViewById(R.id.studlogin);
        studregister=(Button)findViewById(R.id.studregister);
       
       studlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 try {
	                    if (studname.getText().toString().trim().equalsIgnoreCase("") ||  studpass.getText().toString().trim().equalsIgnoreCase("")) {

	                        Toast.makeText(getApplicationContext(), "Please fill data", Toast.LENGTH_LONG).show();
	                    } else {
	                        HashMap<String, String> param = new HashMap<String, String>();

	                        param.put("username",studname.getText().toString().trim());
	                        param.put("password", studpass.getText().toString().trim());

	                      name=studname.getText().toString().trim();
	                        String id = Network.connect("http://"+Network.IP+"/StudLogin.php", param);

	                        System.out.print("http://"+Network.IP+"/getEntry.php");
	                               
	                        id = id.trim();
//	                        Toast.makeText(getApplicationContext(), " Login " + id + " ",
//	                                Toast.LENGTH_LONG).show();
	                        if (id.equals("0")) {
	                            Toast.makeText(getApplicationContext(), "LoginUnSuccessfully...",Toast.LENGTH_SHORT).show();
	                        } else {
//	            String[] sep=id.split(",");
//	            String uid=sep[0].toString();
	                            Toast.makeText(getApplicationContext(), "Login  Successfully...",Toast.LENGTH_SHORT).show();
	                            Intent in1=new Intent(getApplicationContext(),Stud_dashboard.class);
	                            
	                            
	                            startActivity(in1);

	                            finish();
	                        }
	                    }
	                } catch (Exception ex) {

//	                    Toast.makeText(getApplicationContext(), "Please start your Internate or WiFi...", Toast.LENGTH_LONG).show();
	                }
	            }	
				
				
				
				
	
		});
   
      
      studregister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent i=new Intent(getApplicationContext(),StudentRegistrationActivity.class);
				startActivity(i);
						
				
				
	}
		});
       
    
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_login, menu);
		return true;
	}

}
