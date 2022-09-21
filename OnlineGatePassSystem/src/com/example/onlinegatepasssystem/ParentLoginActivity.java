package com.example.onlinegatepasssystem;

import java.util.HashMap;
import com.example.onlinegatepasssystem.Network;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParentLoginActivity extends Activity {
	EditText parentname,parentpassword;
	Button plogin,pregister;
public static String pname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        
        parentname=(EditText)findViewById(R.id.parentname);
        parentpassword=(EditText)findViewById(R.id.parentpassword);
        
         plogin=(Button)findViewById(R.id.plogin);
         pregister=(Button)findViewById(R.id.pregister);
        
        plogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 try {
	                    if (parentname.getText().toString().trim().equalsIgnoreCase("") ||  parentpassword.getText().toString().trim().equalsIgnoreCase("")) {

	                        Toast.makeText(getApplicationContext(), "Please fill data", Toast.LENGTH_LONG).show();
	                    } else {
	                        HashMap<String, String> param = new HashMap<String, String>();

	                        param.put("username", parentname.getText().toString().trim());
	                        param.put("password", parentpassword.getText().toString().trim());

	                      pname=parentname.getText().toString().trim();
	                        String id = Network.connect("http://" + Network.IP
	                                + "/ParentLog.php", param);
	                        System.out.print("http://" + Network.IP
	                                + "/getEntry.php");
	                        id = id.trim();
	                        
                       Toast.makeText(getApplicationContext(), " Login " + id + " ",Toast.LENGTH_LONG).show();
                       
	                        if (id.equals("0")) {
	                            Toast.makeText(getApplicationContext(), "Login UnSuccessfully...",
	                                    Toast.LENGTH_SHORT).show();
	                        } else {
//	            String[] sep=id.split(",");
//            String id=sep[0].toString();
	                            Toast.makeText(getApplicationContext(), "Login  Successfully...",
	                                    Toast.LENGTH_SHORT).show();
                     Intent in1=new Intent(getApplicationContext(),MychildActivity.class);	
                         startActivity(in1);

	                            finish();
	                        }
	                    }
	                } catch (Exception ex) {

	                    Toast.makeText(getApplicationContext(), "Please start your Internate or WiFi...", Toast.LENGTH_LONG).show();
	                }
	            }	
				
				
				
});
    
       
       pregister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent i=new Intent(getApplicationContext(),ParentRegistrationActivity.class);
				startActivity(i);
						
				
				
	}
		});
        
     
        
        
        
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parent_login, menu);
        return true;
    }
    
}
