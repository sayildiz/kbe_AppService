package com.sayildiz.kbe_AppService.file_transfer;

import java.io.IOException;

public interface FileTransferService {
    boolean uploadFile(String localFilePath, String remoteFilePath) throws IOException;
    boolean downloadFile(String localFilePath, String remoteFilePath) throws IOException;
}
