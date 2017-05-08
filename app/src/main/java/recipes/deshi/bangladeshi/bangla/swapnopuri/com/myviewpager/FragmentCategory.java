package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NAYAN on 5/8/2017.
 */
public class FragmentCategory extends Fragment {
    @Nullable

    public static FragmentCategory newInstance() {
        return new FragmentCategory();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }
}
