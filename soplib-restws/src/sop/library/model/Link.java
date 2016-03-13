package sop.library.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Link(String desc, String href) {
		super();
		this.desc = desc;
		this.href = href;
	}
	
	public Link() {
	}
	
	private String desc;

	private String href;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}