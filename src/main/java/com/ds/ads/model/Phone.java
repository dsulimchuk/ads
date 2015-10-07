package com.ds.ads.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Phone {
    
    @NotNull
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
