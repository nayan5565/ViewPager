package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by NAYAN on 5/8/2017.
 */
public class FragmentContuctWithFloatingButton extends Fragment {
    private FloatingActionButton fab;

    @Nullable
    public static FragmentContuctWithFloatingButton newInstance() {
        return new FragmentContuctWithFloatingButton();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contuct, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "floating button click", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
