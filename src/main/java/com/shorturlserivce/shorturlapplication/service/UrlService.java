package com.shorturlserivce.shorturlapplication.service;

import com.shorturlserivce.shorturlapplication.data.model.Url;
import com.shorturlserivce.shorturlapplication.dto.request.UrlRequest;
import com.shorturlserivce.shorturlapplication.dto.response.UrlResponse;
import com.shorturlserivce.shorturlapplication.validation.UrlErrorResponseException;

public interface UrlService {

    UrlResponse generateShortLink(UrlRequest urlRequest) throws UrlErrorResponseException;


    String getEncodedUrl(String encodedUrl) throws UrlErrorResponseException;

    void deleteShortUrl(Url urlLink);
}
