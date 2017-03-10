package downloader.hycoon.com.downloader;

import java.util.Observable;
import java.util.Observer;

/**
 * 类 名： downloader.hycoon.com.downloader
 * 功 能：
 * 作 者： Administrator
 * 时 间： 2016/12/14 09 58
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public abstract class DataWatcher implements Observer {
    private static DataChanger mInstance;

    private DataWatcher() {


    }


    public static DataChanger getInstance() {
        if (mInstance == null) {
            mInstance = new DataChanger();
        }
        return mInstance;
    }

    @Override
    public void update(Observable observable, Object data) {
        if (data instanceof DownloadEntry) {
            notifyUpdata((DownloadEntry) data);

        }
    }

    public abstract void notifyUpdata(DownloadEntry data);
}
