package sop.library.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String details;

	public ResponseMessage() {
	}

	public ResponseMessage(String details) {
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}