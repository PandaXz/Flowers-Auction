package com.belykh.finalProj.entity;

import com.belykh.finalProj.entity.dbo.LotState;

import java.util.Date;

public class LotFull {
    private Long id;
    private Long buyerId;
    private String buyerLogin;
    private Long ownerId;
    private String ownerLogin;
    private Long flowerId;
    private String name;
    private Long addressId;
    private String street;
    private int houseNumber;
    private Long cityId;
    private String cityName;
    private Long countryId;
    private String countryName;
    private Double startPrice;
    private Double currentPrice;
    private LotState state;
    private int count;
    private Date end;
    private String description;

}
