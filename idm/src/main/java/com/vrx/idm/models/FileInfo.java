package com.vrx.idm.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileInfo {

	private StringProperty index  = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty url = new SimpleStringProperty();
	private StringProperty status = new SimpleStringProperty(); // 'DOWNLOADING','DONE','STARTING'
	private StringProperty action = new SimpleStringProperty();
	private StringProperty path = new SimpleStringProperty();

	public FileInfo(String index, String name, String url, String status, String action, String path) {
		this.index.set(index);
		this.name.set(name);
		this.url.set(url);;
		this.status.set(status);
		this.action.set(action);
		this.path.set(path);
	}

	public String getPath() {
		return path.get();
	}

	public void setPath(String path) {
		this.path.set(path);
	}

	public String getIndex() {
		return index.get();
	}

	public void setIndex(String index) {
		 this.index.set(index);
		;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
		;
	}

	public String getUrl() {
		return url.get();
	}

	public void setUrl(String url) {
		this.url.set(url);;
	}

	public String getStatus() {
		return status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
		;
	}

	public String getAction() {
		return action.get();
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
