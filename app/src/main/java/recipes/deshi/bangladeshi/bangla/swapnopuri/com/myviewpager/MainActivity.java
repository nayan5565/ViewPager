package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout footerTab;
    private AdFooterTab adapterFooter;

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
    }

    @Override
    public void onClick(View v) {

    }
}
