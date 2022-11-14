package com.example.mqtt_boat.choosepoints;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mqtt_boat.R;

import java.util.List;
import java.util.Map;

public class PathPointAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public PathPointAdapter(Context context, List<Map<String, String>> listData, int layout_path_item, String[] strings, int[] ints){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {   //列表长度
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class PathHolder{
        public ImageView imageView;
        public TextView tvID,tvLon,tvLat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PathPointAdapter.PathHolder holder = null;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.layout_path_item,null);
            holder = new PathPointAdapter.PathHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvID = convertView.findViewById(R.id.tv_ID);
            holder.tvLon = convertView.findViewById(R.id.tv_lon);
            holder.tvLat = convertView.findViewById(R.id.tv_lat);
            convertView.setTag(holder);
        }else {
            holder = (PathPointAdapter.PathHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvID.setText("采样点①");
        holder.tvLon.setText("经度：");
        holder.tvLat.setText("纬度：");
        holder.imageView.setImageResource(R.drawable.pot);
        return convertView;
    }
}
