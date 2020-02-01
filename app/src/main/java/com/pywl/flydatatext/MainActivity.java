package com.pywl.flydatatext;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_main_sensor)
    TextView tvMainSensor;
    @BindView(R.id.tv_secondary_sensor)
    TextView tvSecondarySensor;
    @BindView(R.id.iv_battery)
    ImageView ivBattery;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .titleBar(toolbarMain)
                .init();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder = null;
    }

    @OnClick({R.id.iv_back, R.id.tv_calibrate, R.id.tv_main_sensor, R.id.tv_secondary_sensor, R.id.tv_capture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_calibrate:

                break;
            case R.id.tv_main_sensor:
                tvMainSensor.setTextSize(18);
                tvMainSensor.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_333333));
                tvSecondarySensor.setTextSize(14);
                tvSecondarySensor.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_666666));
                break;
            case R.id.tv_secondary_sensor:
                tvMainSensor.setTextSize(14);
                tvMainSensor.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_666666));
                tvSecondarySensor.setTextSize(18);
                tvSecondarySensor.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_333333));
                break;
            case R.id.tv_capture:

                break;
        }
    }
}
