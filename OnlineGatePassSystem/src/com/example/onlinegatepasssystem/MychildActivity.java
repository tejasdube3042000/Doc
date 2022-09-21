package com.example.onlinegatepasssystem;

import java.util.HashMap;

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

public class MychildActivity extends Activity {

	ListView listview;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mychild);
		
		
listview=(ListView)findViewById(R.id.listview);
		
		HashMap<String, String> param = new HashMap<String, String>();

       param.put("username",ParentLoginActivity.pname);

        
		String id = Network.connect("http://" + Network.IP
                + "/viewpchild.php", param);
        System.out.print("http://" + Network.IP
                + "/getEntry.php");
        id = id.trim();
        
        String [] data=id.split("#");
		
		 ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  data);
		 listview.setAdapter(arrayAdapter);
		 
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
		
			
				
				String sep[]=listview.getItemAtPosition(pos).toString().split("-");
				
			Intent in=new Intent(getApplicationContext(),MychildActivity.class);
		
				in.putExtra("id", sep[0]);
			in.putExtra("name", sep[1]);
				startActivity(in);
				Toast.makeText(getApplicationContext(), "Helloo"+listview.getItemAtPosition(pos), Toast.LENGTH_LONG).show();
				
			}
		});
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mychild, menu);
		return true;
	}

}
