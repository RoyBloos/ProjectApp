package hr.dinfnot;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity{
    private String[] menuItemNames;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        menuItemNames = new String[2];
        menuItemNames[0] = "Notities";
        menuItemNames[1] = "Todo's";

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setDivider(this.getResources().getDrawable(R.drawable.dividerColor));
        mDrawerList.setAdapter(new ArrayAdapter(this, R.layout.drawer_list_item, menuItemNames));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        selectItem(0);
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        String fragmentName = menuItemNames[position];
        Fragment fragment = null;
        if(fragmentName == "Notities") {
            fragment = new NotitiesOverzichtFragment();
        } else if(fragmentName == "Todo's"){
            fragment = new TodosOverzichtFragment();
        }

        if(fragment != null){
            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            setTitle(menuItemNames[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

      private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }
}
