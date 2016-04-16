package com.ds.ads.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class Phone {

    @NotNull
    private String phoneCode;

    @NotNull
    private String phoneNumber;

    private String memo;

    public Phone() {
    }

    public Phone(String phoneCode, String phoneNumber) {
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
    }
}
