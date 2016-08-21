package com.epam.filedirectoryinfo;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Полина on 21.08.2016.
 */
public class DirectoryReader extends RecursiveTask<FileDirectoryInfo> {

    private final File fileList;

    public DirectoryReader(File file) {
        this.fileList = file;
    }

    @Override
    protected FileDirectoryInfo compute() {
        List<DirectoryReader> directoryReaders = new LinkedList<DirectoryReader>();
        FileDirectoryInfo fileDirectoryInfo = new FileDirectoryInfo();

        if (fileList.isDirectory()) {
            for (File file : fileList.listFiles()) {
                DirectoryReader directoryReader = new DirectoryReader(file);
                directoryReader.fork();
                directoryReaders.add(directoryReader);
                if (file.isDirectory()) {
                    fileDirectoryInfo.setDirectoryCount(fileDirectoryInfo.getDirectoryCount() + 1);
                }
            }
        } else {
            if (fileList.exists()) {
                fileDirectoryInfo.setFileCount(fileDirectoryInfo.getFileCount() + 1);
                fileDirectoryInfo.setFileSizes(fileList.length());
            }
        }

        for(DirectoryReader directoryReader: directoryReaders) {
            FileDirectoryInfo fileDirectoryInfoPre = directoryReader.join();

            fileDirectoryInfo.setDirectoryCount(fileDirectoryInfo.getDirectoryCount() + fileDirectoryInfoPre.getDirectoryCount());
            fileDirectoryInfo.setFileCount(fileDirectoryInfo.getFileCount() + fileDirectoryInfoPre.getFileCount());
            fileDirectoryInfo.setFileSizes(fileDirectoryInfo.getFileSizes() + fileDirectoryInfoPre.getFileSizes());
        }

        return fileDirectoryInfo;
    }
}
