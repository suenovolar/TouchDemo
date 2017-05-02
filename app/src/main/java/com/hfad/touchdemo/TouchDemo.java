package com.hfad.touchdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TouchDemo extends AppCompatActivity {
    private TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViews();
    }
    private void findViews(){
        tvMessage = (TextView)findViewById(R.id.tvMessage);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("frist pointer: (%.1f,%.1f),", event.getX(), event.getY()));
                sb.append("touch state: \n");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        sb.append("ACTION_DOWN\n");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        sb.append("ACTION_MOVE\n");
                        break;
                    case MotionEvent.ACTION_UP:
                        sb.append("ACTION_UP\n");
                        break;
                    default:
                        sb.append("\n");
                        break;
                }
                int pointerCount = event.getPointerCount();
                sb.append(String.format("pointer count: %d %n",pointerCount));
                for (int i = 0;i<pointerCount;i++){
                    sb.append(String.format("pointer %d: (%.1f,%.1f) %n"  ,event.getPointerId(i),event.getX(i),event.getY(i)));
                  // sb.append(String.format("pointer %d: (%.1f,%.1f) %n",event.getPointerId(i),event.getX(i),event.getY(i)));
                }
                tvMessage.setText(sb);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_touch_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
