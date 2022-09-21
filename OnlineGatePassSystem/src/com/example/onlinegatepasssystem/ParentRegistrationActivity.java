package com.example.onlinegatepasssystem;

import java.util.HashMap;


import com.example.onlinegatepasssystem.Network;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ParentRegistrationActivity extends Activity {

	private String Name,Email,Mobile,Username,Password,Child;
	EditText  pname,pchild,pmobile,pemail,pusername,ppassword;
	Button pRegister;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parent_registration);
		
		
		 pname= (EditText) findViewById(R.id.pname);
		
			pmobile = (EditText) findViewById(R.id.pmobile);
		 pchild = (EditText)  findViewById(R.id.pchild);
		 pemail=(EditText)findViewById(R.id.pemail);
		 pusername = (EditText) findViewById(R.id.pusername);
          ppassword= (EditText) findViewById(R.id.ppassword);
			
             pRegister = (Button)findViewById(R.id.pRegister);
  		
		   pRegister.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
	                  Name = pname.getText().toString().trim();
					    Email = pemail.getText().toString().trim();
					    Mobile = pmobile.getText().toString().trim();
					    Child = pchild.getText().toString().trim();
					    Username=pusername.getText().toString().trim();
					    Password=ppassword.getText().toString().trim();
					   
					   

					    if ( pname.getText().toString().trim().equalsIgnoreCase("") || pchild.getText().toString().trim().equalsIgnoreCase("")||pemail.getText().toString().trim().equalsIgnoreCase("") || pmobile.getText().toString().trim().equalsIgnoreCase("")||pusername.getText().toString().trim().equalsIgnoreCase("") ||ppassword.getText().toString().trim().equalsIgnoreCase("") )
					    {
					        Toast.makeText(getApplicationContext(), "please fill data", Toast.LENGTH_LONG).show();
					    }
			
					    else
					    {
					        HashMap<String, String> param = new HashMap<String, String>();

					        param.put("name",        pname.getText().toString().trim());
					        param.put("child_name",   pchild.getText().toString().trim());
					        param.put("mobile",       pmobile.getText().toString().trim());
					        param.put("email",    pemail.getText().toString().trim());
					        param.put("username", pusername.getText().toString().trim());
					        param.put("password", ppassword.getText().toString().trim());
					       
					       
					       

					        
					     String id = Network.connect("http://" + Network.IP
					                + "/ParentReg.php", param);
					        System.out.print("http://" + Network.IP
					                + "/getEntry.php");
					        id = id.trim();
					        Toast.makeText(getApplicationContext(), " Login " + id + " ",
					                Toast.LENGTH_LONG).show();

					        if (id.equals("0"))
					        {

					            Toast.makeText(getApplicationContext(), " Parent Registration  Not Successfully...",
					                    Toast.LENGTH_SHORT).show();
					        }
					        else {
					
					            Toast.makeText(getApplicationContext(), "Parent Registration  Successfully...",
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
		getMenuInflater().inflate(R.menu.parent_registration, menu);
		return true;
	

	}
}
