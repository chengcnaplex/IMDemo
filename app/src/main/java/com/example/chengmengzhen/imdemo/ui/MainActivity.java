package com.example.chengmengzhen.imdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

/**
 * Created by chengmengzhen on 16/7/11.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            List<String> usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
            Log.e("user",usernames.toString());
            for (String s : usernames){
                Log.e("user",s);
            }

        } catch (HyphenateException e) {
            e.printStackTrace();
        }
    }
}
