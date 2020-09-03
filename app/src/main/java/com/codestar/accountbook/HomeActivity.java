package com.codestar.accountbook;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class HomeActivity extends AppCompatActivity {

    MeowBottomNavigation meowBottomNavigation;
    private final static int ID_HOME=1;
    private final static int ID_ADD=2;
    private final static int ID_MORE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       meowBottomNavigation=findViewById(R.id.meow_bar);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_add));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_more));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentHome()).commit();

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment=null;
                switch (item.getId()){
                    case ID_HOME:
                        select_fragment=new FragmentHome();
                        break;
                    case ID_ADD:
                        select_fragment=new FragmentAdd();
                        break;
                    case ID_MORE:
                        select_fragment=new FragmentMore();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,select_fragment).commit();
            }
        });

       meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });

    }
}