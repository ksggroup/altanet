package com.ws.altanet.soap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DeletePostRequest")

public class DeletePostRequest  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "post_id", required = true)
	private Long post_id;

	public Long post_id() {
		return post_id;
	}

	public void setpost_id(Long post_id) {
		this.post_id = post_id;
	}

}
