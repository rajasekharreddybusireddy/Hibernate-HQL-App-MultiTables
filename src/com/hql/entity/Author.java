package com.hql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORS_TBL")
public class Author {

	@Id
	@Column(name = "AUTHOR_ID")
	private Integer authorId;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "AUTHOR_EMAIL")
	private String authorEmail;

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName
				+ ", authorEmail=" + authorEmail + "]";
	}

}
