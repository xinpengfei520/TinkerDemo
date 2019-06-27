package com.xpf.android.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by x-sir on 2019-06-27 :)
 * Function:而这个类是真正的自定义的 application,别忘了在 AndroidManifest.xml 中使用，
 * 当构建完成时会自动生成 MyApplication 类
 */
@DefaultLifeCycle(application = ".MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = true)
public class MyApplicationLike extends ApplicationLike {

    private static final String TAG = "MyApplicationLike";

    /**
     * Constructor
     *
     * @param application
     * @param tinkerFlags
     * @param tinkerLoadVerifyFlag
     * @param applicationStartElapsedTime
     * @param applicationStartMillisTime
     * @param tinkerResultIntent
     */
    public MyApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                             long applicationStartElapsedTime, long applicationStartMillisTime,
                             Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        MultiDex.install(base);
        TinkerInstaller.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }
}
