package com.xpf.android.tinker.download;

/**
 * Created by x-sir on 2019/6/9 :)
 * Function:下载的监听器
 */
public interface DownloadListener {
    /**
     * 进度更新
     * @param progress
     */
    void onProgress(int progress);

    /**
     * 下载成功
     */
    void onSuccess();

    /**
     * 下载失败
     */
    void onFailed();

    /**
     * 下载暂停
     */
    void onPaused();

    /**
     * 下载取消
     */
    void onCanceled();
}
