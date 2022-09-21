package com.example.onlinegatepasssystem;
import java.util.HashMap;
import com.example.onlinegatepasssystem.Network;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent; 
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;

public class TechperActivity extends Activity {

	Button parcal,childcall;
	
	EditText msg,no;
	RadioButton rd1;
RadioGroup rdgrp;
String username,status_from_teacher;
Button submit;
TextView tv;
Bundle bnd;
String st;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_techper);
		
		parcal=(Button)findViewById(R.id.pcall);
		childcall=(Button)findViewById(R.id.childcall);
		no=(EditText)findViewById(R.id.no);
		msg=(EditText)findViewById(R.id.msg);
		rdgrp=(RadioGroup)findViewById(R.id.radioGroup1);
		tv=(TextView)findViewById(R.id.recttvnm);
		bnd=getIntent().getExtras();
		
		tv.setText(bnd.getString("id"));
		
//		tv=(TextView)findViewById(R.id.recttvnm);
		bnd=getIntent().getExtras();
		
//		tv.setText(bnd.getString("id"));
		
		
		HashMap<String, String> param = new HashMap<String, String>();
		 param.put("username", bnd.getString("id"));
//        param.put("status_from_teacher", rd1.getText().toString()); 

        
		String id = Network.connect("http://"+ Network.IP
                + "/getmobile1.php", param);
		
		no.setText(id);
		int sel=rdgrp.getCheckedRadioButtonId();
		rd1=(RadioButton)findViewById(sel);
		
		
		
		
		
		
		
		
		
		
		
//		int sel=rdgrp.getCheckedRadioButtonId();
//		Toast.makeText(getApplicationContext(), "sel"+sel, Toast.LENGTH_LONG).show();
//		rd1=(RadioButton)findViewById(sel);
		
		int selectedId = rdgrp.getCheckedRadioButtonId();

		// find the radiobutton by returned id
		rd1= (RadioButton) findViewById(selectedId);
//		Toast.makeText(getApplicationContext(), "sel"+rd1.getText().toString(), Toast.LENGTH_LONG).show();
		submit=(Button)findViewById(R.id.submit);
		
		
	parcal.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			
			 String number=no.getText().toString();  
             Intent callIntent = new Intent(Intent.ACTION_CALL);  
             callIntent.setData(Uri.parse("tel:"+number));  
             startActivity(callIntent);  
		}
			
	});
			
			
	childcall.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			 String num=no.getText().toString();  
             String msag=msg.getText().toString();  
               
             //Getting intent and PendingIntent instance  
             Intent intent=new Intent(getApplicationContext(),TechperActivity.class);  
             PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
               
             //Get the SmsManager instance and call the sendTextMessage method to send message  
             SmsManager p=SmsManager.getDefault(); 
             
        p.sendTextMessage(num, null,msag, pi, null);
             
               Toast.makeText(getApplicationContext(), "Message Sent successfully!",  Toast.LENGTH_LONG).show();  
         }  
			 
			
		

		
		
	});
	

	
	
	
//			childcall.setOnClickListener(new View.OnClickListener() {
//				
//				public void onClick(View v) {
//					
//					 String num=no.getText().toString();  
//		                String msag=msg.getText().toString();  
//		                  
//		                //Getting intent and PendingIntent instance  
//		                Intent intent=new Intent(getApplicationContext(),TechperActivity.class);  
//		                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
//		                  
//		                //Get the SmsManager instance and call the sendTextMessage method to send message  
//		                SmsManager sms=SmsManager.getDefault();  
//		                sms.sendTextMessage(num, null, msg, pi,null);  
//		                  
//		                Toast.makeText(getApplicationContext(), "Message Sent successfully!",  
//		                    Toast.LENGTH_LONG).show();  
//		            }  
//					 
					
//				}
					
				
				
		
	            
	        

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				int selectedId = rdgrp.getCheckedRadioButtonId();

				// find the radiobutton by returned id
				rd1= (RadioButton) findViewById(selectedId);
				Toast.makeText(getApplicationContext(), "sel"+rd1.getText().toString(), Toast.LENGTH_LONG).show();
//				name = tv.getText().toString().trim();
//				   status = rd1.getText().toString().trim();
//				   if ( tv.getText().toString().trim().equalsIgnoreCase("") ||rd1.getText().toString().trim().equalsIgnoreCase(""))
//				    {
//				        Toast.makeText(getApplicationContext(), "please fill data", Toast.LENGTH_LONG).show();
//				    }
//				    else
//				    {
				    	HashMap<String, String> param = new HashMap<String, String>();
				    	int i=rdgrp.getCheckedRadioButtonId();
				        rd1=(RadioButton)findViewById(i);
				        
						 param.put("name", bnd.getString("id"));
				        param.put("status_from_teacher", rd1.getText().toString()); 

				        
						String id = Network.connect("http://"+ Network.IP
				                + "/Tpermission.php", param);
						
						Toast.makeText(getApplicationContext(), ""+"http://"+ Network.IP
				                + "/Tpermission.php", Toast.LENGTH_LONG).show();
				        System.out.print("http://" + Network.IP
				                + "/getEntry.php");
				        id = id.trim();
				        if(id.contentEquals("1")){
				        	
				        	Toast.makeText(getApplicationContext(), "Permission Updated Successfully", Toast.LENGTH_SHORT).show();
		        Intent in=new Intent(getApplicationContext(),ViewapplicationActivity.class);
				        
		        startActivity(in);
				        }
				        else{
				        	Toast.makeText(getApplicationContext(), "Permission Not Updated Successfully", Toast.LENGTH_SHORT).show();
				        	
				        }
//				
//				    }
				
				
			}
			

		});		

}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.techper, menu);
		return true;
	}

}
