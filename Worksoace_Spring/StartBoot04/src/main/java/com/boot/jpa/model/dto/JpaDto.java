package com.boot.jpa.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MYBOARD")
public class JpaDto {

	@Id
	@Column
	private int myno;
	@Column
	private String myname;
	@Column
	private String mytitle;
	@Column
	private String mycontent;
	@Temporal(TemporalType.DATE)
	@Column(updatable = false) // 수정 안되게
	private Date myDate;
	
	public JpaDto() {

	}

	public JpaDto(int myno, String myname, String mytitle, String mycontent, Date myDate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.myDate = myDate;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	
	
}
