package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentCategory;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentDrawer;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentFloatingButton;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentMovies;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentNotification;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentOrder;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment.FragmentPhoto;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ViewPager");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        displayView(2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (pos == 0) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        if (pos == 2) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new FragmentCategory();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new FragmentFloatingButton();
                title = getString(R.string.title_floating);
                break;
            case 2:
                fragment = new FragmentOrder();
                title = getString(R.string.title_Order);
                break;
            case 3:
                Intent intent = new Intent(this, ViewPagerActivity.class);
                startActivity(intent);
                break;
            case 4:
                fragment = new FragmentPhoto();
                title = getString(R.string.title_photo);
                break;
            case 5:
                fragment = new FragmentMovies();
                title = getString(R.string.title_Order);
                break;
            case 6:
                fragment = new FragmentNotification();
                title = getString(R.string.title_Order);
                break;
            case 7:
                Intent intent1 = new Intent(this, NavigationGroupViewActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

        pos = position;
    }
}
