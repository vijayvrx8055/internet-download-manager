package com.vrx.idm;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.vrx.idm.models.FileInfo;

public class DownloadThread extends Thread {

	private FileInfo fileInfo;
	private DownloadManagerController downloadManager;

	public DownloadThread(FileInfo fileInfo, DownloadManagerController downloadManagerController) {
		this.fileInfo = fileInfo;
		this.downloadManager = downloadManagerController;
	}

	@Override
	public void run() {
		
		this.fileInfo.setStatus("DOWNLOADING");
		// download logic
		try {
			Files.copy(new URL(this.fileInfo.getUrl()).openStream(),
					Paths.get(this.fileInfo.getPath().get()));
		}catch (Exception e) {
			this.fileInfo.setStatus("FAILED");
			e.printStackTrace();
		}
		this.downloadManager.updateUI(this.fileInfo);
		
	}

}
