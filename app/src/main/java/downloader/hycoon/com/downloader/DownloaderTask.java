package downloader.hycoon.com.downloader;

/**
 * 类 名： downloader.hycoon.com.downloader
 * 功 能：
 * 作 者： Administrator
 * 时 间： 2016/12/14 10 00
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public class DownloaderTask {
    private final DownloadEntry entry;
    private boolean isPaused;
    private boolean isCancelled;

    public DownloaderTask(DownloadEntry entry) {
        this.entry = entry;
    }

    public void pause() {
        isPaused = true;
    }

    public void cancel() {
        isCancelled = true;
    }

    public void start() {
        entry.mStatus = DownloadEntry.DownloadStatus.downloading;
        DataChanger.getInstance().postStatus(entry);
        entry.totalLength = 1024 * 100;
        for (int i = 0; i < entry.totalLength; ) {

            if (isPaused || isCancelled) {
                entry.mStatus=isPaused? DownloadEntry.DownloadStatus.paused: DownloadEntry.DownloadStatus.cancelled;
                DataChanger.getInstance().postStatus(entry);
                // TODO: 2016/12/21  if cancelled ,delete relate file

                return;
            }
            i += 1024;
            entry.currentLength += 1024;
            DataChanger.getInstance().postStatus(entry);
        }
        entry.mStatus = DownloadEntry.DownloadStatus.completed;
        DataChanger.getInstance().postStatus(entry);
    }
}
