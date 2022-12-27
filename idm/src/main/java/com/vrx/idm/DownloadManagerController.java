package com.vrx.idm;

import java.io.File;
import java.util.Observable;

import com.vrx.idm.config.AppConfig;
import com.vrx.idm.models.FileInfo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DownloadManagerController {

	@FXML
	private Button downloadButton;

	@FXML
	private TextField urlTextField;

	@FXML
	private TableView<FileInfo> tableView;

	private ObservableList<FileInfo> data = FXCollections.observableArrayList();

	public int index = 0;

	private FileInfo initData() {
		String url = this.urlTextField.getText().trim();
		String filename = url.substring(url.lastIndexOf("/") + 1);
		System.out.println("File name: " + filename);
		String status = "STARTING";
		String action = "OPEN";
		String path = AppConfig.DOWNLOAD_PATH + File.separator + filename;
		FileInfo fileInfo = new FileInfo((index + 1) + "", filename, url, status, action, path);
		System.out.println("File Info:" + fileInfo.toString());
		this.index = this.index + 1;
		return fileInfo;
	}

	@FXML
	void downloadButtonClicked(ActionEvent event) {
		FileInfo fileInfo = initData();
		DownloadThread thread = new DownloadThread(fileInfo, this);
		this.tableView.getItems().add(Integer.parseInt(fileInfo.getIndex())-1, fileInfo);
		thread.start();

	}

	public void updateUI(FileInfo fileInfo) {
		System.out.println("Update UI: " + fileInfo);
		FileInfo metaInfo = this.tableView.getItems().get(Integer.parseInt(fileInfo.getIndex())-1);
		fileInfo.setStatus(metaInfo.getStatus());
		this.tableView.refresh();
		System.out.println("___________________________________");
	}

	@FXML
	public void initialize() {
		System.out.println("View Initialized");
		TableColumn<FileInfo, String> index = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(0);
		index.setCellValueFactory(p -> {
			return new SimpleStringProperty(Integer.parseInt(p.getValue().getIndex()) + 1 + "");
		});
		TableColumn<FileInfo, String> fileName = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(1);
		fileName.setCellValueFactory(p -> {
			return new SimpleStringProperty(p.getValue().getName());
		});
		TableColumn<FileInfo, String> url = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(2);
		url.setCellValueFactory(p -> {
			return new SimpleStringProperty(p.getValue().getUrl());
		});
		TableColumn<FileInfo, String> status = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(3);
		status.setCellValueFactory(p -> {
			return new SimpleStringProperty(p.getValue().getStatus());
		});
		TableColumn<FileInfo, String> action = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(4);
		action.setCellValueFactory(p -> {
			return new SimpleStringProperty(p.getValue().getAction());
		});
	}
}
