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

public class HodLoginActivity extends Activity {
	
	EditText huname,hpass;
	Button hlogin,hRegister;
	
	
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hod_login);
		
		
		huname=(EditText)findViewById(R.id.huname);
        hpass=(EditText)findViewById(R.id.hpass);
        
         hlogin=(Button)findViewById(R.id.hlogin);
         hRegister=(Button)findViewById(R.id.hRegister);
        
       
			hlogin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					
					 try {
		                    if (huname.getText().toString().trim().equalsIgnoreCase("") ||  hpass.getText().toString().trim().equalsIgnoreCase("")) {

		                        Toast.makeText(getApplicationContext(), "Please fill data", Toast.LENGTH_LONG).show();
		                    } else {
		                        HashMap<String, String> param = new HashMap<String, String>();

		                        param.put("username",huname.getText().toString().trim());
		                        param.put("password", hpass.getText().toString().trim());

		                      
		                        String id = Network.connect("http://" + Network.IP
		                                + "/hodlog.php", param);
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
                            Intent in1=new Intent(getApplicationContext(),ViewapplicationActivity.class);	                            startActivity(in1);

		                            finish();
		                        }
		                    }
		                } catch (Exception ex) {

//		                    Toast.makeText(getApplicationContext(), "Please start your Internate or WiFi...", Toast.LENGTH_LONG).show();
		                }
		            }	
					
					
					
					
		
			});
	    
					
					
					
					
	 hRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent i=new Intent(getApplicationContext(),HodRegistrationActivity.class);
				startActivity(i);
						
				
				
	}
		});
		
			
		
		
			
        }	
	
		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hod_login, menu);
		return true;
	}

}
