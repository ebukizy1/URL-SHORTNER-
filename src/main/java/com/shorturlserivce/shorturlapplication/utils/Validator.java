package com.shorturlserivce.shorturlapplication.utils;

import com.shorturlserivce.shorturlapplication.data.model.Url;
import com.shorturlserivce.shorturlapplication.validation.UrlErrorResponseException;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class Validator {




    public static void validateUrlIsNotNUll(Url foundUrl) throws UrlErrorResponseException {
        if(foundUrl == null){
            throw new UrlErrorResponseException(400, "URL does not exist it might have expire");
        }
    }

    public static void validateIsNotEmpty(String encodedUrl) throws UrlErrorResponseException {
        if(StringUtils.isEmpty(encodedUrl)){
            throw new UrlErrorResponseException(400, "invalid Url");
        }
    }
}
