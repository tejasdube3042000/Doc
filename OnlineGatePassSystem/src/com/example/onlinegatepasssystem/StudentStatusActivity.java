package com.example.onlinegatepasssystem;

import java.util.HashMap;

import com.example.onlinegatepasssystem.Network;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;

public class StudentStatusActivity extends Activity {

	ListView ltview;
	 CalendarView calendarview,calenderView1;
		ListView ltv;
		String fromDate ,toDate;
		
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewstatus);
		ltview=(ListView)findViewById(R.id.ltview);

      HashMap<String, String> param = new HashMap<String, String>();

	       
      param.put("username",StudentLoginActivity.name);
//      param.put("id",Network.id);
//      param.put("date1", toDate.trim());
//     param.put("id", Network.id);
		String id = Network.connect("http://"+Network.IP1
              + "/OnlineGatePassSystem/viewallchild.php", param);
      System.out.print("http://" + Network.IP
              + "/getEntry.php");
      id = id.trim();
      
      String [] data=id.split("#");
		
		 ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  data);
		 ltview.setAdapter(arrayAdapter);
		
		
		
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewstatus, menu);
		return true;
	}

}
