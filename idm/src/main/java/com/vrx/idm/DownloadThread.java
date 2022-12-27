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
					Paths.get(this.fileInfo.getPath()));
		}catch (Exception e) {
			this.fileInfo.setStatus("FAILED");
			System.out.println("Downloading Error...");
			e.printStackTrace();
		}
		this.downloadManager.updateUI(this.fileInfo);
		System.out.println("DONE");
		this.fileInfo.setAction("COMPLETED");
		this.fileInfo.setStatus("DONE");
	}

}
