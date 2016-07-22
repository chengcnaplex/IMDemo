package com.example.chengmengzhen.imdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cengalabs.flatui.views.FlatToggleButton;
import com.example.chengmengzhen.imdemo.R;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;

import java.util.List;

/**
 * Created by APLEX on 2016/7/22.
 */
public class DeviceChatActivity extends AppCompatActivity {
    private FlatToggleButton mToggleButton;
    private boolean mIsChecked = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_chatctl);
        mToggleButton = (FlatToggleButton) mToggleButton.findViewById(R.id.ctl_toggle);
        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToggleButton.setChecked(mIsChecked =!mToggleButton.isChecked());
                EMMessage message = EMMessage.createTxtSendMessage(mIsChecked+"", getIntent().getStringExtra("username"));
                //如果是群聊，设置chattype，默认是单聊
                // if (chatType == CHATTYPE_GROUP)
                //    message.setChatType(ChatType.GroupChat);
                //发送消息
                EMClient.getInstance().chatManager().sendMessage(message);
            }
        });
        initListener();
    }

    private void initListener() {

        EMMessageListener msgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
//                if (messages.get(0).getBody().)

            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                //收到透传消息
            }

            @Override
            public void onMessageReadAckReceived(List<EMMessage> messages) {
                //收到已读回执
            }

            @Override
            public void onMessageDeliveryAckReceived(List<EMMessage> message) {
                //收到已送达回执
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                //消息状态变动
            }
        };
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
        //记得在不需要的时候移除listener，如在activity的onDestroy()时
       // EMClient.getInstance().chatManager().removeMessageListener(msgListener);
    }
}
