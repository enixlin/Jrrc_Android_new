package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.dao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

import linzhenhuan.jrrc_android_new.R;

/**
 * Created by linzhenhuan on 16/4/9.
 */
public class functionListAdapter  extends BaseAdapter{
    private ArrayList<functionCell> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public functionCell getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            Inflater in;
            in = LayoutInflater.from(functionCell.class);
        }

        return null;
    }
}
