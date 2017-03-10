package downloader.hycoon.com.downloader;

import android.content.Context;

import java.util.Observable;

/**
 * 类 名： downloader.hycoon.com.downloader
 * 功 能：
 * 作 者： Administrator
 * 时 间： 2016/12/14 09 57
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public class DataChanger extends Observable {
    private static DataChanger mInstance;


    public DataChanger() {

    }

    public static synchronized DataChanger getInstance() {
        if (mInstance == null) {
            mInstance = new DataChanger();
        }
        return mInstance;
    }




    public void postStatus(DownloadEntry entry) {
        setChanged();
        notifyObservers(entry);

    }


}
