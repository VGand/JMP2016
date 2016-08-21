package com.epam.filedirectoryinfo;

/**
 * Created by Полина on 21.08.2016.
 */
public class FileDirectoryInfo {
    private Long fileSizes = new Long(0);
    private Long fileCount = new Long(0);
    private Long directoryCount = new Long(0);

    public Long getFileSizes() {
        return fileSizes;
    }

    public void setFileSizes(Long fileSizes) {
        this.fileSizes = fileSizes;
    }

    public Long getFileCount() {
        return fileCount;
    }

    public void setFileCount(Long fileCount) {
        this.fileCount = fileCount;
    }

    public Long getDirectoryCount() {
        return directoryCount;
    }

    public void setDirectoryCount(Long directoryCount) {
        this.directoryCount = directoryCount;
    }
}
