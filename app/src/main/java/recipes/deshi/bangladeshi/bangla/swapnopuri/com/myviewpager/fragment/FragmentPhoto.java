package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.R;

/**
 * Created by NAYAN on 5/10/2017.
 */
public class FragmentPhoto extends Fragment {
    @Nullable
    public static FragmentPhoto newInstance() {
        return new FragmentPhoto();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        return view;
    }
}
