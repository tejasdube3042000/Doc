package com.example.onlinegatepasssystem;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecurityRegistrationActivity extends Activity {

	private String Name,Email,Mobile,Username,Password;
	EditText  sname,smobile,semail,secuname,spass;
	Button sRegister1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_security_registration);
		
		
		 sname= (EditText) findViewById(R.id.sname);
			
			smobile = (EditText) findViewById(R.id.smobile);
		 
		 semail=(EditText)findViewById(R.id.semail);
		 secuname = (EditText) findViewById(R.id.secuname);
       spass= (EditText) findViewById(R.id.spass);
			
          sRegister1= (Button)findViewById(R.id.sRegister1);
		
		   sRegister1.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
	                  Name = sname.getText().toString().trim();
					    Email = semail.getText().toString().trim();
					    Mobile = smobile.getText().toString().trim();
					   
					    Username=secuname.getText().toString().trim();
					    Password=spass.getText().toString().trim();
					   
					   

					    if ( sname.getText().toString().trim().equalsIgnoreCase("") ||semail.getText().toString().trim().equalsIgnoreCase("") || smobile.getText().toString().trim().equalsIgnoreCase("")||secuname.getText().toString().trim().equalsIgnoreCase("") ||spass.getText().toString().trim().equalsIgnoreCase("") )
					    {
					        Toast.makeText(getApplicationContext(), "please fill data", Toast.LENGTH_LONG).show();
					    }
					    else
					    {
					        HashMap<String, String> param = new HashMap<String, String>();

					        param.put("name",        sname.getText().toString().trim());
					        
					        param.put("mobile",       smobile.getText().toString().trim());
					        param.put("email",    semail.getText().toString().trim());
					        param.put("username", secuname.getText().toString().trim());
					        param.put("password", spass.getText().toString().trim());
					       
					       
					       

					        
					     String id = Network.connect("http://" + Network.IP
					                + "/SecurityReg.php", param);
					        System.out.print("http://" + Network.IP
					                + "/getEntry.php");
					        id = id.trim();
					        Toast.makeText(getApplicationContext(), " Login " + id + " ",
					                Toast.LENGTH_LONG).show();

					        if (id.equals("0"))
					        {

					            Toast.makeText(getApplicationContext(), "Security Registration  Not Successfully...",
					                    Toast.LENGTH_SHORT).show();
					        }
					        else {
					
					            Toast.makeText(getApplicationContext(), "Security  Registration  Successfully...",
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
		getMenuInflater().inflate(R.menu.security_registration, menu);
		return true;
	}

}
