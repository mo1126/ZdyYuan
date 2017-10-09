package com.bwie.zdyyuan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kson.slidingmenu.SlidingMenu;
import com.kson.slidingmenu.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initmenu();
    }

    private void initmenu() {
            setBehindContentView(R.layout.left_tihuan);
            getSupportFragmentManager().beginTransaction().replace(R.id.left_tihuan,new Fragment1()).commit();
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        slidingMenu.setBehindOffset(200);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        slidingMenu.setSecondaryMenu(R.layout.right_tihuan);
        getSupportFragmentManager().beginTransaction().replace(R.id.right_tihuan,new Fragment2()).commit();
    }
}
