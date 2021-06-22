package com.crs.domain.guest.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name="GUEST")
public class Guest implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 7615287143643842200L;
	
	  @Id
	  @Column(name = "ID")
	  @GeneratedValue(generator = "system-uuid")
	  @GenericGenerator(name = "system-uuid", strategy = "uuid")
	  private String id;

	  @Column(name="MOBILE_NO")
	  private String mobileNumber;
	  
	  @Column(name="NAME")
	  private String name;
	  
	  @Column(name="EMAIL_ID")
	  private String emailId;
	  
	  @Column(name="DOCUMENT_TYPE")
	  private String documentType;
	  
	  @Column(name="DOCUMENT_ID")
	  private String documentId;
	  
	  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	  @JoinColumn(name="ADDRESS_ID")
	  private Address address;
	  
	  @Column(name="STATUS")
	  private String status;

}
