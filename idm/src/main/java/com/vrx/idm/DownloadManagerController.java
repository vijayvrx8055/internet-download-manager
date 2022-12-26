package com.vrx.idm;

import java.io.File;

import com.vrx.idm.config.AppConfig;
import com.vrx.idm.models.FileInfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class DownloadManagerController {

	@FXML
	private Button downloadButton;

	@FXML
	private TextField urlTextField;

	@FXML
	private TableColumn<?, ?> fileName;

	public int index = 0;

	@FXML
	void downloadButtonClicked(ActionEvent event) {
		String url = this.urlTextField.getText().trim();
		String filename= url.substring(url.lastIndexOf("/")+1);
		String status = "STARTING";
		String action = "OPEN";
		String path = AppConfig.DOWNLOAD_PATH + File.separator+filename;
		FileInfo fileInfo = new FileInfo((index+1), filename, url, status, action,path);
		System.out.println(fileInfo.toString());
		DownloadThread thread = new DownloadThread(fileInfo, this);
		thread.start();
	}

	public void updateUI(FileInfo fileInfo) {
		System.out.println(fileInfo);
		System.out.println("___________________________________");
	}

}
