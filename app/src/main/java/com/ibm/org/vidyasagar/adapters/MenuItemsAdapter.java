package com.ibm.org.vidyasagar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibm.org.vidyasagar.insurance_mobile.R;
import com.ibm.org.vidyasagar.utils.MenuItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vidyasagar Machupalli on 27/12/16.
 */

public class MenuItemsAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<MenuItem> menuItems;
    private static LayoutInflater inflater=null;

    public  MenuItemsAdapter(Context context) {
        this.mContext = context;
        this.menuItems = getMenuItems();
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return menuItems.size();
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    public class Holder
    {
        TextView textView;
        ImageView imageView;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.list_item, null);
        //TODO: Disable this
        if(position != 1) {
            rowView.setEnabled(false);
            rowView.setClickable(false);
            rowView.setAlpha(0.5f);
        }

        holder.textView=(TextView) rowView.findViewById(R.id.textview);
        holder.imageView=(ImageView) rowView.findViewById(R.id.imageview);

        holder.textView.setText(menuItems.get(position).getLabel());
        Picasso.with(mContext).load(menuItems.get(position).getIcon()).into(holder.imageView);
        //holder.imageView.setImageResource(Picasso.with(mContext).load(menuItems.get(position).getIcon()));

        return rowView;
    }

    // Menu Item List
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem()
                        .setLabel("HOME")
                        .setIcon(R.drawable.png_home2280)
        );
        items.add(new MenuItem()
                        .setLabel("HEALTH")
                        .setIcon(R.drawable.png_heart2570)
        );
        items.add(new MenuItem()
                        .setLabel("AUTO")
                        .setIcon(R.drawable.png_auo2321)
        );
        items.add(new MenuItem()
                        .setLabel("TRAVEL")
                        .setIcon(R.drawable.png_travel2458)
        );
        return items;
    }
}
