package com.example.onlinegatepasssystem;

import java.util.HashMap;
import com.example.onlinegatepasssystem.Network;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ViewapplicationActivity extends Activity {

	ListView list;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewapplication);
		
list=(ListView)findViewById(R.id.list);
		
		HashMap<String, String> param = new HashMap<String, String>();

       
        param.put("uname",Network.id);
		String id = Network.connect("http://" + Network.IP
                + "/viewallchild.php", param);
        System.out.print("http://" + Network.IP
                + "/getEntry.php");
        id = id.trim();
        
        String [] data=id.split("#");
		
		 ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  data);
		 list.setAdapter(arrayAdapter);
		 
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
		
			
				
				String sep[]=list.getItemAtPosition(pos).toString().split("-");
				
			Intent in=new Intent(getApplicationContext(),TechperActivity.class);
		
				in.putExtra("id", sep[0]);
				in.putExtra("name", sep[1]);
				startActivity(in);
				Toast.makeText(getApplicationContext(), "Helloo"+list.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
				
			}
		});
		 
//		 lt.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//			@Override
//			public void onItemSelected(AdapterView<?> parent, View vw,
//					int pos, long arg3) {
//				
//				Toast.makeText(getApplicationContext(), "Helloo"+lt.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
//				
//				
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//			
//				
//			}
//		});
		
		
}

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewapplication, menu);
		return true;
	}

}
