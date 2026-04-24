package edu.hebut.broadcastreceiverdemo;




import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewLog;
    private Button btnSendCustomBroadcast;
    private DynamicBroadcastReceiver dynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLog = findViewById(R.id.textViewLog);
        btnSendCustomBroadcast = findViewById(R.id.btnSendCustomBroadcast);

        // 注册动态广播接收器
        registerDynamicReceiver();

        // 发送自定义广播按钮点击事件
        btnSendCustomBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCustomBroadcast();
            }
        });
    }

    // 注册动态广播接收器
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void registerDynamicReceiver() {
        dynamicReceiver = new DynamicBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction("com.example.CUSTOM_BROADCAST");
        registerReceiver(dynamicReceiver, filter);
        appendLog("动态广播接收器已注册");
    }

    // 发送自定义广播
    private void sendCustomBroadcast() {
        Intent intent = new Intent("com.example.CUSTOM_BROADCAST");
        intent.putExtra("message", "这是一条来自物联网222于治豪225228的自定义广播消息");
        sendBroadcast(intent);
        appendLog("已发送自定义广播");
    }

    // 动态广播接收器内部类
    public class DynamicBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String message = "";

            if (action != null) {
                switch (action) {
                    case Intent.ACTION_BATTERY_LOW:
                        message = "接收到系统广播：电量低";
                        break;
                    case "com.example.CUSTOM_BROADCAST":
                        String customMessage = intent.getStringExtra("message");
                        message = "接收到自定义广播：" + customMessage;
                        break;
                }
                appendLog(message);
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    // 更新日志显示
    private void appendLog(String message) {
        textViewLog.append(message + "\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 注销动态广播接收器
        if (dynamicReceiver != null) {
            unregisterReceiver(dynamicReceiver);
            appendLog("动态广播接收器已注销");
        }
    }
}