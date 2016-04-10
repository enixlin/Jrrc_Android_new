package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import linzhenhuan.jrrc_android_new.R;

/**
 * Created by linzhenhuan on 16/4/9.
 */
public class functionListAdapter extends BaseAdapter {

    private Context context;
    protected ArrayList<functionCell> list;


    public functionListAdapter(Context conext) {
        this.context=conext;
        this.list=new ArrayList<functionCell>();
    }

    public  void add(String title,String des,int imageId){
       functionCell celldate=null;
       list.add(new functionCell(des,imageId,title));

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<functionCell> getList() {
        return list;
    }

    public void setList(ArrayList<functionCell> list) {
        this.list = list;
    }




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
        LinearLayout ll = null;
        functionCell celldata = getItem(position);


        if (convertView != null) {
                ll= (LinearLayout) convertView;
        } else {
                ll= (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.functioncell,null);
        }

        ImageView iv= (ImageView) ll.findViewById(R.id.imageView);
        TextView tv_title= (TextView) ll.findViewById(R.id.tv_title);
        TextView tv_dec= (TextView) ll.findViewById(R.id.tv_description);


        iv.setImageResource(celldata.getImageId());
        tv_title.setText(celldata.getName());
        tv_dec.setText(celldata.getDescrition());

        return ll;
    }




}
