package com.shorturlserivce.shorturlapplication.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UrlRequest {
    private String originalUrl;
    private String expirationDate;

}
