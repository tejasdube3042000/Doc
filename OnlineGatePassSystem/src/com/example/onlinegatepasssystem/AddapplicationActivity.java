package com.example.onlinegatepasssystem;

import java.util.HashMap;


import com.example.onlinegatepasssystem.Network;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddapplicationActivity extends Activity {

	 CalendarView cal1,cal2;
	 Button btsubmit;
	TextView T_Reason;
	EditText et_reason,Leave,name;
	String fromDate ,toDate;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addapplication);
		
		btsubmit=(Button) findViewById(R.id.btsubmit);
//		T_Reason=(TextView)findViewById(R.id.T_Reason);
		et_reason=(EditText)findViewById(R.id.et_reason);
		Leave=(EditText)findViewById(R.id.Leave);
		name=(EditText)findViewById(R.id.name);
		
		
		 cal1 = (CalendarView) findViewById(R.id.cal1);
		 cal2 = (CalendarView) findViewById(R.id.cal2);
		 
		 cal1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			
			@Override
			public void onSelectedDayChange(CalendarView arg0, int i2, int i1,
					int i) {
			Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
				fromDate=(i2+","+i1+","+i);
			}
		});
		 cal2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			
			@Override
			public void onSelectedDayChange(CalendarView arg0, int l2, int l1,
					int l) {
			Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + l2 + "\n" + "Month = " + l1 + "\n" + "Year = " + l, Toast.LENGTH_LONG).show();
				
				toDate=(l2+","+l1+","+l);
			}
		});
		 
		 
		btsubmit.setOnClickListener(new OnClickListener() {
			
			
			
			public void onClick(View arg0) {
				
				   try {
	                    if (et_reason.getText().toString().trim().equalsIgnoreCase("")) {

	                        Toast.makeText(getApplicationContext(), "Please fill data", Toast.LENGTH_LONG).show();
	                    } else {
	                        HashMap<String, String> param = new HashMap<String, String>();

	                        param.put("reason", et_reason.getText().toString().trim());
	                        param.put("leave", Leave.getText().toString().trim());
	                        param.put("username", name.getText().toString().trim());
	                        param.put("date", fromDate.trim());
	                        param.put("date1", toDate.trim());
                        param.put("id", Network.id.trim());
	                        //********id and uid== take param.put("id", Network.id);**************
	                       // param.put("pass", et_pass_hod.getText().toString().trim());
	                       // param.put("dpt",dpt.trim());
//	                      
	                        String id = Network.connect("http://" + Network.IP
	                                + "/StudLeave.php", param);
//	                        System.out.print("http://" + Network.IP
//	                                + "/getEntry.php");
	                        id = id.trim();
//	                        Toast.makeText(getApplicationContext(), " Login " + id + " ",
//	                                Toast.LENGTH_LONG).show();
	                        if (id.equals("0")) {
	                            Toast.makeText(getApplicationContext(), "Record Save UnSuccessfully...",
	                                    Toast.LENGTH_SHORT).show();
	                        } else {
//	            String[] sep=id.split(",");
//	            String uid=sep[0].toString();
	                            Toast.makeText(getApplicationContext(), "Record Save Successfully...",
	                                    Toast.LENGTH_SHORT).show();


	                            finish();
	                        }
	                    }
	                } catch (Exception ex) {
	                	ex.printStackTrace();

//	                  //  Toast.makeText(getApplicationContext(), "Please start your Internate or WiFi...", Toast.LENGTH_LONG).show();
	                }
	            }



				
			
		});
				
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addapplication, menu);
		return true;
	}

}
