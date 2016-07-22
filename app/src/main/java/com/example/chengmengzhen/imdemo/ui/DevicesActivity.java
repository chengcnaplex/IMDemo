package com.example.chengmengzhen.imdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chengmengzhen.imdemo.R;
import com.example.chengmengzhen.imdemo.adapter.DeviceAdapter;
import com.example.chengmengzhen.imdemo.bean.Device;
import com.example.chengmengzhen.imdemo.url.DeviceUrl;
import com.example.chengmengzhen.imdemo.utils.RetrofitClient;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by chengmengzhen on 16/7/11.
 */
public class DevicesActivity extends AppCompatActivity {
    private ListView mListView;
    private Device mDevices = new Device();
    private DeviceAdapter mDeviceAdapter;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_devices);
        initview();
        initData();
        initListener();
    }

    private void initListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DevicesActivity.this,DeviceChatActivity.class);
                intent.putExtra("username",mDevices.entities.get(position).username);
                startActivity(intent);
            }
        });
    }

    private void initview() {
        mListView = (ListView) findViewById(R.id.device);
    }

    private void initData() {

        DeviceUrl url = RetrofitClient.getRetrofit().create(DeviceUrl.class);
        Call<Device> call = url.Devices();
        call.enqueue(new Callback<Device>() {
                         /****************************************************************************
                          *
                          * 在Retrofit 1.9中，如果获取的 response 不能背解析成定义好的对象，则会调用failure。
                          * 但是在Retrofit 2.0中，不管 response 是否能被解析。onResponse总是会被调用。
                          * 但是在结果不能被解析的情况下，response.body()会返回null。别忘了处理这种情况。
                          *
                          ****************************************************************************/
                         @Override
                         public void onResponse(Response<Device> response, Retrofit retrofit) {
                             //已经回到主线程
                             mDevices = response.body();
                             if (mDevices == null) {
                                 Log.e("DevicesActivity", "解析错误");
                             } else {
                                 Log.e("DevicesActivity", mDevices.toString());
                                 mDeviceAdapter = new DeviceAdapter(mDevices.entities, DevicesActivity.this);
                                 mListView.setAdapter(mDeviceAdapter);
                             }
                         }

                         @Override
                         public void onFailure(Throwable t) {
                             ///Log.e("", t.toString());
                         }
                     }
        );
    }


}
