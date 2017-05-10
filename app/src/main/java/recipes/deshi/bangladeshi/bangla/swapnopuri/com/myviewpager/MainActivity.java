package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout footerTab;
    private FragmentDrawer drawerFragment;
    private static ArrayList<Integer> footerIcons;
    private AdFooterTab adapterFooter;
    public static int selectTabPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ViewPager");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        footerTab = (TabLayout) findViewById(R.id.footerTab);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setupFooter();
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        displayView(2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
                fragment = new FragmentOrder();
                title = getString(R.string.title_friends);
                break;
            case 2:
                fragment = new FragmentContuct();
                title = getString(R.string.title_messages);
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
    }

    private void setupFooter() {
        adapterFooter = new AdFooterTab(getSupportFragmentManager());
        adapterFooter.addFragment(FragmentCategory.newInstance(), "Category");
        adapterFooter.addFragment(FragmentOrder.newInstance(), "Order");
        adapterFooter.addFragment(FragmentContuct.newInstance(), "Contuct");
        adapterFooter.addFragment(FragmentOne.newInstance(), "One");
        adapterFooter.addFragment(FragmentTwo.newInstance(), "Two");
        adapterFooter.addFragment(FragmentThree.newInstance(), "Three");
        adapterFooter.addFragment(FragmentFour.newInstance(), "Four");
        viewPager.setAdapter(adapterFooter);
        footerTab.setupWithViewPager(viewPager);
        footerTab.setSelectedTabIndicatorHeight(20);
        footerTab.setSelectedTabIndicatorColor(Color.RED);
        footerTab.setTabTextColors(Color.WHITE, Color.parseColor("#6C4878"));

      /*  for (int i = 0; i < footerTab.getTabCount(); i++) {
            footerTab.getTabAt(i).setIcon(footerIcon(i, false));
        }*/

        footerTab.getTabAt(selectTabPos).select();
        footerTab.getTabAt(selectTabPos).setIcon(footerIcon(selectTabPos, true));
        footerTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tab.setIcon(footerIcon(tab.getPosition(), true));

                viewPager.setCurrentItem(tab.getPosition());
                footerTab.setTabTextColors(Color.WHITE, Color.parseColor("#6C4878"));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(footerIcon(tab.getPosition(), false));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                tab.setIcon(footerIcon(tab.getPosition(), true));
            }
        });
    }

    private int footerIcon(int pos, boolean isActive) {
        if (footerIcons == null) {
            footerIcons = new ArrayList<>();
            footerIcons.add(R.drawable.icon_cat);
            footerIcons.add(R.drawable.icon_order);
            footerIcons.add(R.drawable.icon_contact);

            footerIcons.add(R.drawable.green_star1);
            footerIcons.add(R.drawable.green_star_base);
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
        }

        return isActive ? footerIcons.get(pos + 3) : footerIcons.get(pos);

    }
}
