package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.R;
import recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.model.MNavDrawerItem;

/**
 * Created by NAYAN on 5/9/2017.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<MNavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<MNavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_raw, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MNavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
        if (position==4){
            holder.imageView.setImageResource(R.drawable.ic_photo_library_black_24dp);
        }if (position==5){
            holder.imageView.setImageResource(R.drawable.ic_local_movies_black_24dp);
        }if (position==6){
            holder.imageView.setImageResource(R.drawable.ic_settings_black_24dp);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.btnNavImg);
        }
    }
}
