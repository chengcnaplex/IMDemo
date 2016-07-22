package com.example.chengmengzhen.imdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chengmengzhen.imdemo.R;
import com.example.chengmengzhen.imdemo.bean.Device;

import java.util.List;

/**
 * Created by APLEX on 2016/7/22.
 */
public class DeviceAdapter extends BaseAdapter{
    private List<Device.EntitiesBean> mdatas;
    private Context mContext;
    public DeviceAdapter(List<Device.EntitiesBean> datas,Context context){
        this.mdatas = datas;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mdatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mdatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_device,null);
            viewHolder.deviceName = (TextView) convertView.findViewById(R.id.devce_name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.deviceName.setText(mdatas.get(position).username);
        return convertView;
    }
    static class ViewHolder{
        TextView deviceName;
    }
}
