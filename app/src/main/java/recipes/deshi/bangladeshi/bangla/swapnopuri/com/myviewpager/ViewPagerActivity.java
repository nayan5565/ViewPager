package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/26/2017.
 */
public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout footerTab;
    Toolbar toolbar;
    private static ArrayList<Integer> footerIcons;
    private AdFooterTab adapterFooter;
    public static int selectTabPos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupFooter();
    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        footerTab = (TabLayout) findViewById(R.id.footerTab);
    }
    private void setupFooter() {
        adapterFooter = new AdFooterTab(getSupportFragmentManager());
        adapterFooter.addFragment(FragmentCategory.newInstance(), "Category");
        adapterFooter.addFragment(FragmentOrder.newInstance(), "Order");
        adapterFooter.addFragment(FragmentFloatingButton.newInstance(), "Floating");
        adapterFooter.addFragment(FragmentOne.newInstance(), "One");
        adapterFooter.addFragment(FragmentTwo.newInstance(), "Two");
        adapterFooter.addFragment(FragmentThree.newInstance(), "Three");
        adapterFooter.addFragment(FragmentFour.newInstance(), "Four");
        viewPager.setAdapter(adapterFooter);
        footerTab.setupWithViewPager(viewPager);
        footerTab.setSelectedTabIndicatorHeight(2);
        footerTab.setSelectedTabIndicatorColor(Color.GREEN);
        footerTab.setTabTextColors(Color.WHITE, Color.GREEN);

      /*  for (int i = 0; i < footerTab.getTabCount(); i++) {
            footerTab.getTabAt(i).setIcon(footerIcon(i, false));
        }*/
// footerTab getTabAt both method comment korar pore o kono prob hoi nai kn
        footerTab.getTabAt(selectTabPos).select();
        footerTab.getTabAt(selectTabPos).setIcon(footerIcon(selectTabPos, true));
        footerTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tab.setIcon(footerIcon(tab.getPosition(), true));

                //set current item kn use korsis. comment kore rakhar pore o kono change hoi nai kaj
                viewPager.setCurrentItem(tab.getPosition());
                footerTab.setTabTextColors(Color.WHITE, Color.GREEN);

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
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
            footerIcons.add(R.drawable.grrencoins);
        }

        return isActive ? footerIcons.get(pos) : footerIcons.get(pos);

    }
}
