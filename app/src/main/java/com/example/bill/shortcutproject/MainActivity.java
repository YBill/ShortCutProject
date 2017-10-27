package com.example.bill.shortcutproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
        setLauncherLogo();
    }

    private void setLauncherLogo() {
        Intent intent = new Intent("com.example.bill.shortcutproject.TwoActivity");
        addShortcut(this, "Two", R.mipmap.ic_launcher_round, intent, false);

        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    /**
     * 创建快捷方式
     *
     * @param context
     * @param shortcutName
     * @param iconRes
     * @param actionIntent
     * @param allowRepeat
     */
    private void addShortcut(Context context, String shortcutName, int iconRes, Intent actionIntent, boolean allowRepeat) {
        Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        //是否允许重复创建
        shortcutintent.putExtra("duplicate", allowRepeat);
        //快捷方式的名称
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        //设置快捷方式图片
        Parcelable icon = Intent.ShortcutIconResource.fromContext(context.getApplicationContext(), iconRes);
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        //设置快捷方式动作
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, actionIntent);
        //向系统发送广播
        context.sendBroadcast(shortcutintent);
    }

}
