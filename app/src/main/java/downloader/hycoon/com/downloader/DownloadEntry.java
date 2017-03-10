package downloader.hycoon.com.downloader;

import java.io.Serializable;

/**
 * 类 名： downloader.hycoon.com.downloader
 * 功 能：
 * 作 者： Administrator
 * 时 间： 2016/12/14 14 37
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public class DownloadEntry implements Serializable {
    public String id,//
            name,//
            url;

    public enum DownloadStatus {
        waiting, downloading,
        paused, resumed, cancelled, completed, idle
    }

    public DownloadStatus mStatus = DownloadStatus.idle;


    public int currentLength;
    public int totalLength;

    public DownloadEntry() {
    }

    public DownloadEntry(String url) {
        this.url = url;
        this.id = id;
        this.name = url.substring(url.lastIndexOf("/") + 1);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
