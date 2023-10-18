package com.shorturlserivce.shorturlapplication.utils;

import com.shorturlserivce.shorturlapplication.data.model.Url;
import com.shorturlserivce.shorturlapplication.dto.request.UrlRequest;
import com.shorturlserivce.shorturlapplication.dto.response.UrlResponse;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static LocalDateTime getExpirationDate(String expirationDate, LocalDateTime createdDate) {
        if(StringUtils.isBlank(expirationDate)){
            return createdDate.plusSeconds(120);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime expireDate = LocalDateTime.parse(expirationDate, formatter);
        return expireDate;
    }
    public static UrlResponse generatedUrlResponse(UrlRequest urlRequest, Url savedUrl) {
        UrlResponse response = new UrlResponse();
        response.setOriginalUrl(urlRequest.getOriginalUrl());
        response.setShortLinkUrl(savedUrl.getShortLinkUrl());
        response.setExpirationDate(savedUrl.getExpirationDate());
        return response;
    }
    public static void urlRequestCollected(UrlRequest urlRequest, Url urlCreated, String encodedUrl) {
        urlCreated.setCreatedDate(LocalDateTime.now());
        urlCreated.setOriginalUrl(urlRequest.getOriginalUrl());
        urlCreated.setShortLinkUrl(encodedUrl);
        urlCreated.setExpirationDate(getExpirationDate(urlRequest.getExpirationDate(), urlCreated.getCreatedDate()));
    }

}
