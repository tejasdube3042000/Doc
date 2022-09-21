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

public class SecurityLoginActivity extends Activity {

	EditText susername,spassword;
	Button slogin,sregister;
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_security_login);
		
		
		 susername=(EditText)findViewById(R.id.susername);
	      spassword=(EditText)findViewById(R.id.spassword);
	        
	         slogin=(Button)findViewById(R.id.slogin);
	         sregister=(Button)findViewById(R.id.sregister);
	        
	        slogin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					 try {
		                    if (susername.getText().toString().trim().equalsIgnoreCase("") ||  spassword.getText().toString().trim().equalsIgnoreCase("")) {

		                        Toast.makeText(getApplicationContext(), "Please fill data", Toast.LENGTH_LONG).show();
		                    } else {
		                        HashMap<String, String> param = new HashMap<String, String>();

		                        param.put("username",susername.getText().toString().trim());
		                        param.put("password", spassword.getText().toString().trim());

		                      
		                        String id = Network.connect("http://" + Network.IP
		                                + "/SecurityLog.php", param);
		                        System.out.print("http://" + Network.IP
		                                + "/getEntry.php");
		                        id = id.trim();
//		                        Toast.makeText(getApplicationContext(), " Login " + id + " ",
//		                                Toast.LENGTH_LONG).show();
		                        if (id.equals("0")) {
		                            Toast.makeText(getApplicationContext(), "Login     UnSuccessfully...",
		                                    Toast.LENGTH_SHORT).show();
		                        } else {
//		            String[] sep=id.split(",");
//		            String uid=sep[0].toString();
		                            Toast.makeText(getApplicationContext(), "Login  Successfully...",
		                                    Toast.LENGTH_SHORT).show();
//	                            Intent in1=new Intent(getApplicationContext(),ViewapplicationActivity.class);
//	                            startActivity(in1);

		                            finish();
		                        }
		                    }
		                } catch (Exception ex) {

		                    Toast.makeText(getApplicationContext(), "Please start your Internate or WiFi...", Toast.LENGTH_LONG).show();
		                }
		            }	
					
					
					
					
		
			});
	    
	       
	       sregister.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					
					Intent i=new Intent(getApplicationContext(),SecurityRegistrationActivity.class);
					startActivity(i);
							
					
					
		}
			});
	        
	     
	        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.security_login, menu);
		return true;
	}

}
