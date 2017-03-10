package downloader.hycoon.com.downloader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;


/**
 * 类 名： downloader.hycoon.com.downloader
 * 功 能： 程序入口，收集用户的动作333333333333
 * <p/>
 * 作 者： Administrator
 * 时 间： 2016/12/14 09 59
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public class DownloaderManager {


    private static DownloaderManager mInstance;

    private final Context context;

    public DownloaderManager(Context context) {
        this.context = context;
    }

    public synchronized DownloaderManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DownloaderManager(context);
        }
        return mInstance;
    }


    public void add(Context context, DownloadEntry entry) {
        Intent intent = new Intent(context, DownloaderService.class);
        intent.putExtra(Constants.KEY_DOWNLOAD_VALUE, (Serializable) entry);
        intent.putExtra(Constants.KEY_DOWNLOAD_ACTION, Constants.KEY_DOWNLOAD_ACTION_ADD);
        context.startService(intent);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void cancel() {
    }

    public void addObserver(DataWatcher watcher) {
        DataWatcher.getInstance().addObserver(watcher);
    }

    public void removeObserver(DataWatcher watcher) {
        DataWatcher.getInstance().deleteObserver(watcher);
    }


}
