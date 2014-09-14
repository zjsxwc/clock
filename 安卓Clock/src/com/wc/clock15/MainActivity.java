package com.wc.clock15;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.provider.AlarmClock;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

       Button btn1, btn2;
       TextView tv1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
              setContentView(R.layout. activity_main);

               if (savedInstanceState == null) {
                     getSupportFragmentManager().beginTransaction()
                                  .add(R.id. container, new PlaceholderFragment()).commit();
              }
       }

       
        public void onStart(){
               super.onStart();
              link_refs();
              set_listeners();
              
       }

        public void link_refs(){
               btn1=(Button) findViewById(R.id. button1);
               btn2=(Button) findViewById(R.id. button2);
               tv1=(TextView) findViewById(R.id. textView1);
       }
       
        public void set_listeners(){
              Log. d("A0", "set_listeners");
              
               if (btn1 ==null){Log.d ("A0" ,"btn1 not exist return" ); return;}
              Log. d("A0", "set_listeners 2");
               btn1.setOnClickListener(
                      new View.OnClickListener() {                           
                            @Override
                            public void onClick(View v) {
                                  Log. d("A0", "btn1 click");
                                  Intent intent2 = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
                                   final Calendar c = Calendar.getInstance();
                             int  intHour = c.get(Calendar.HOUR_OF_DAY);
                             int intMinute = c.get(Calendar.MINUTE);
                             Log.d("A0", ">>>>>"+Integer.toString(intHour)+ ":"+Integer.toString(intMinute));
                                  intent2.putExtra( AlarmClock.EXTRA_HOUR, intHour);
                                  intent2.putExtra( AlarmClock.EXTRA_MINUTES,intMinute+15);
                                  startActivity(intent2);
    
                           }
                     }             
              );
              
              
               if (btn2 ==null){Log.d ("A0" ,"btn2 not exist return" ); return;}
              Log. d("A0", "set_listeners 3");
               btn2.setOnClickListener(
                      new View.OnClickListener() {                           
                            @Override
                            public void onClick(View v) {
                                  Log. d("A0", "btn2 click");
    
                           }
                     }             
              );
              
              
       }
       
       
       
       
       
       
       
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

               // Inflate the menu; this adds items to the action bar if it is present.
              getMenuInflater().inflate(R.menu. main, menu);
               return true ;
       }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
               // Handle action bar item clicks here. The action bar will
               // automatically handle clicks on the Home/Up button, so long
               // as you specify a parent activity in AndroidManifest.xml.
               int id = item.getItemId();
               if (id == R.id.action_settings) {
                      return true ;
              }
               return super .onOptionsItemSelected(item);
       }

        /**
        * A placeholder fragment containing a simple view.
        */
        public static class PlaceholderFragment extends Fragment {

               public PlaceholderFragment() {
              }

               @Override
               public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
                     View rootView = inflater.inflate(R.layout. fragment_main, container,
                                   false);
                      return rootView;
              }
       }

}