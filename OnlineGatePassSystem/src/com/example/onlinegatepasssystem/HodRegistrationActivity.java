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

public class HodRegistrationActivity extends Activity {
	
	
	private String Name,Email,Mobile,Username,Password;
	EditText  hname,hmobile,hemail,husername,hpassword;
	Button hregister;
    Spinner spin_branch;
    String branch;
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hod_registration);
		
		hname= (EditText) findViewById(R.id.hname);
		hmobile = (EditText) findViewById(R.id.hmobile);
        hemail=(EditText)findViewById(R.id.hemail);
	    husername = (EditText) findViewById(R.id.husername);
         hpassword= (EditText) findViewById(R.id.hpassword);
         spin_branch= (Spinner) findViewById(R.id.spin_branch);
         hregister = (Button)findViewById(R.id.hregister);
         
         
         spin_branch.setOnItemSelectedListener(new OnItemSelectedListener() {

     		@Override
     		public void onItemSelected(AdapterView<?> pre, View arg1, int pos,
     				long arg3) {
     			// TODO Auto-generated method stub
//     			Toast.makeText(getApplicationContext(), "value"+pos, Toast.LENGTH_LONG).show();
//     			Toast.makeText(getApplicationContext(), "value"+pre.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
     		
     		branch=pre.getItemAtPosition(pos).toString();
     		}

     		@Override
     		public void onNothingSelected(AdapterView<?> arg0) {
     			
     			
     		}
     	});
         
         
         
      hregister.setOnClickListener(new OnClickListener() {
	         public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
                  Name = hname.getText().toString().trim();
				    Email = hemail.getText().toString().trim();
				    Mobile = hmobile.getText().toString().trim();
				    
				    Username=husername.getText().toString().trim();
				    Password=hpassword.getText().toString().trim();
				   
				   

				    if ( hname.getText().toString().trim().equalsIgnoreCase("") ||hemail.getText().toString().trim().equalsIgnoreCase("") || hmobile.getText().toString().trim().equalsIgnoreCase("")||husername.getText().toString().trim().equalsIgnoreCase("") ||hpassword.getText().toString().trim().equalsIgnoreCase("") )
				    {
				        Toast.makeText(getApplicationContext(), "please fill data", Toast.LENGTH_LONG).show();
				    }
				    else
				    {
				        HashMap<String, String> param = new HashMap<String, String>();

				        param.put("name",        hname.getText().toString().trim());
				        param.put("branch",        branch.trim());
				        param.put("mobile",       hmobile.getText().toString().trim());
				        param.put("email",    hemail.getText().toString().trim());
				        param.put("username", husername.getText().toString().trim());
				        param.put("password", hpassword.getText().toString().trim());
				       
				       
				       

				        
				     String id = Network.connect("http://" + Network.IP
				                + "/HodReg.php", param);
				        System.out.print("http://" + Network.IP
				                + "/getEntry.php");
				        id = id.trim();
				        Toast.makeText(getApplicationContext(), " Login " + id + " ",
				                Toast.LENGTH_LONG).show();

				        if (id.equals("0"))
				        {

				            Toast.makeText(getApplicationContext(), " HOD Registration  Not Successfully...",Toast.LENGTH_SHORT).show();
				        }
				        else {
				
				            Toast.makeText(getApplicationContext(), "HOD Registration  Successfully...",Toast.LENGTH_SHORT).show();


				            finish();
				        }
				    }

			
		}
		});
	
	
	
		
		
		
		
		
		
		
		
		
	}

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hod_registration, menu);
		return true;
	}

}
