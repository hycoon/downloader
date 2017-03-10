package downloader.hycoon.com.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.HashMap;

/**
 * 类 名： downloader.hycoon.com.downloader
 * 功 能：
 * 作 者： Administrator
 * 时 间： 2016/12/14 09 59
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public class DownloaderService extends Service {

    private HashMap<String, DownloaderTask> mDownloaderTaskHashMap = new HashMap<>();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DownloadEntry entry = (DownloadEntry) intent.getSerializableExtra(Constants.KEY_DOWNLOAD_VALUE);
        int action = intent.getIntExtra(Constants.KEY_DOWNLOAD_ACTION, -1);

        doAction(action, entry);
        return super.onStartCommand(intent, flags, startId);
    }

    private void doAction(int action, DownloadEntry entry) {
        //check action ,do relate action

        switch (action) {
            case Constants.KEY_DOWNLOAD_ACTION_ADD:
                startDownload(entry);
                break;
            case Constants.KEY_DOWNLOAD_ACTION_PAUSE:
                pauseDownload(entry);
                break;
            case Constants.KEY_DOWNLOAD_ACTION_RESUME:
                resumeDownload(entry);
                break;
            case Constants.KEY_DOWNLOAD_ACTION_CANCEL:
                cancelDownload(entry);
                break;


        }


    }

    private void cancelDownload(DownloadEntry entry) {
        DownloaderTask task = mDownloaderTaskHashMap.remove(entry.id);
        if (task != null) {
            task.cancel();

        }

    }

    private void resumeDownload(DownloadEntry entry) {
        startDownload(entry);


    }

    private void pauseDownload(DownloadEntry entry) {
        DownloaderTask task = mDownloaderTaskHashMap.remove(entry.id);
        if (task != null) {
            task.pause();

        }


    }

    private void startDownload(DownloadEntry entry) {

        DownloaderTask task = new DownloaderTask(entry);
        task.start();
        mDownloaderTaskHashMap.put(entry.id, task);



    }
}
