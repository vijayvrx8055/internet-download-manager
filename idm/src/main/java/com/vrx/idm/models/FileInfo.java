package com.vrx.idm.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileInfo {

	private SimpleIntegerProperty index  = new SimpleIntegerProperty();
	private SimpleStringProperty name = new SimpleStringProperty();
	private String url = "";
	private SimpleStringProperty status = new SimpleStringProperty(); // 'DOWNLOADING','DONE','STARTING'
	private SimpleStringProperty action = new SimpleStringProperty();
	private SimpleStringProperty path = new SimpleStringProperty();

	public FileInfo(int index, String name, String url, String status, String action, String path) {
		this.index.set(index);
		this.name.set(name);
		this.url = url;
		this.status.set(status);
		this.action.set(action);
		this.path.set(path);
	}

	public SimpleStringProperty getPath() {
		return path;
	}

	public void setPath(SimpleStringProperty path) {
		this.path = path;
	}

	public SimpleIntegerProperty getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index.set(index);
		;
	}

	public SimpleStringProperty getName() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
		;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SimpleStringProperty getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status.set(status);
		;
	}

	public SimpleStringProperty getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action.set(action);
		;
	}

	@Override
	public String toString() {
		return "FileInfo [index=" + index + ", name=" + name + ", url=" + url + ", status=" + status + ", action="
				+ action + ", path=" + path + "]";
	}

	
}
