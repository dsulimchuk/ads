package com.ds.ads.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;


/**
 * @author ds
 *         Main Ad class
 */
@Data
public class Ad {
    private Long id;
    private String caption;
    private ZonedDateTime createDay;
    private Category category;
    private User user;
    private String adress;
    private String phone;
    private String email;
    private String description;
    private List<String> photos;
}