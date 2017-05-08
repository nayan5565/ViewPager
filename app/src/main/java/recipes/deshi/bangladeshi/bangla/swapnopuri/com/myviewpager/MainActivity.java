package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout footerTab;
    private static ArrayList<Integer> footerIcons;
    private AdFooterTab adapterFooter;
    public static int selectTabPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("ViewPager");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        footerTab = (TabLayout) findViewById(R.id.footerTab);
        setupFooter();
    }

    private void setupFooter() {
        adapterFooter = new AdFooterTab(getSupportFragmentManager());
        adapterFooter.addFragment(FragmentCategory.newInstance(), "Category");
        adapterFooter.addFragment(FragmentOrder.newInstance(), "Order");
        adapterFooter.addFragment(FragmentContuct.newInstance(), "Contuct");
        viewPager.setAdapter(adapterFooter);
        footerTab.setupWithViewPager(viewPager);
        footerTab.setSelectedTabIndicatorHeight(20);
        footerTab.setSelectedTabIndicatorColor(Color.RED);
        footerTab.setTabTextColors(Color.WHITE, Color.parseColor("#6C4878"));

        for (int i = 0; i < footerTab.getTabCount(); i++) {
            footerTab.getTabAt(i).setIcon(footerIcon(i, false));
        }

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
                tab.setIcon(footerIcon(tab.getPosition(), true));
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
        }

        return isActive ? footerIcons.get(pos + 3) : footerIcons.get(pos);

    }

    @Override
    public void onClick(View v) {

    }
}
