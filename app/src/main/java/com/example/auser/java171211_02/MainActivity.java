package com.example.auser.java171211_02;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    JobScheduler jobScheduler;
    JobInfo.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        builder = new JobInfo.Builder(123,
                new ComponentName(getPackageName(), MyJob.class.getName()));
        builder.setPeriodic(3000);
    }

    public void btn1(View v)
    {
        jobScheduler.schedule(builder.build());
    }
    public void btn2(View v)
    {
        jobScheduler.cancelAll();
    }
}
