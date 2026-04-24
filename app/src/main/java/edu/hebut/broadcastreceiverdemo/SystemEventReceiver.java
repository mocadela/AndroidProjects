package edu.hebut.broadcastreceiverdemo;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class SystemEventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
            // 获取电池电量
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPct = level * 100 / (float)scale;

            Toast.makeText(context, "电池电量: " + batteryPct + "%", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
            Toast.makeText(context, "电源已连接", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
            Toast.makeText(context, "电源已断开", Toast.LENGTH_SHORT).show();
        }
    }
}