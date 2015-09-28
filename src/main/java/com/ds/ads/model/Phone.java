package com.ds.ads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="phones")
@XmlRootElement
public class Phone {
    @Id
    @GeneratedValue
    private long id;
    
    private String phoneCode;
    
    @NotNull
    private String phoneNumber;
    
    private String memo;
    
    @Override
    public String toString() {
	return "(" + phoneCode + ")" + phoneNumber + " [" + memo + "]";
    }
    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }
    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
   
    
    public Phone() {
    }
    
    public Phone(String phoneCode, String phoneNumber) {
	this.phoneCode = phoneCode;
	this.phoneNumber = phoneNumber;
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the phoneCode
     */
    public String getPhoneCode() {
        return phoneCode;
    }
    /**
     * @param phoneCode the phoneCode to set
     */
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
