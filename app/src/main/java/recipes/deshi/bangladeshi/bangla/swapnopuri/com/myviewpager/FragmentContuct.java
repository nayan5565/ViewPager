package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.ngs.floatingactionbutton.FloatingActionButton;

/**
 * Created by NAYAN on 5/8/2017.
 */
public class FragmentContuct extends Fragment {
    private FloatingActionButton fab;
    @Nullable
    public static FragmentContuct newInstance() {
        return new FragmentContuct();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contuct, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Message", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
