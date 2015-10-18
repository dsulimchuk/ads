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
    
    public Phone() {
    }
    
    public Phone(String phoneCode, String phoneNumber) {
	this.phoneCode = phoneCode;
	this.phoneNumber = phoneNumber;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((memo == null) ? 0 : memo.hashCode());
	result = prime * result + ((phoneCode == null) ? 0 : phoneCode.hashCode());
	result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Phone))
	    return false;
	Phone other = (Phone) obj;
	if (memo == null) {
	    if (other.memo != null)
		return false;
	} else if (!memo.equals(other.memo))
	    return false;
	if (phoneCode == null) {
	    if (other.phoneCode != null)
		return false;
	} else if (!phoneCode.equals(other.phoneCode))
	    return false;
	if (phoneNumber == null) {
	    if (other.phoneNumber != null)
		return false;
	} else if (!phoneNumber.equals(other.phoneNumber))
	    return false;
	return true;
    }
    
    
    
}
