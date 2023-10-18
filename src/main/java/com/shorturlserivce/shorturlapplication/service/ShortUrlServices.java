package com.shorturlserivce.shorturlapplication.service;


import com.shorturlserivce.shorturlapplication.data.model.Url;
import com.shorturlserivce.shorturlapplication.data.repositories.UrlRepository;
import com.shorturlserivce.shorturlapplication.dto.request.UrlRequest;
import com.shorturlserivce.shorturlapplication.dto.response.UrlResponse;
import com.shorturlserivce.shorturlapplication.utils.Hasher;
import com.shorturlserivce.shorturlapplication.utils.Validator;
import com.shorturlserivce.shorturlapplication.validation.UrlErrorResponseException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.shorturlserivce.shorturlapplication.utils.Mapper.*;

@Service
@RequiredArgsConstructor
public class ShortUrlServices implements UrlService {
    private final UrlRepository urlRepository;
    private final ModelMapper modelMapper;
    @Override
    public UrlResponse generateShortLink(UrlRequest urlRequest) throws UrlErrorResponseException {
        checkForEmptyInput(urlRequest);
        String encodedUrl = Hasher.hashedEncodeUrl(urlRequest.getOriginalUrl());
        Url urlCreated = new Url();
        urlRequestCollected(urlRequest, urlCreated, encodedUrl);
        Url savedUrl = urlRepository.save(urlCreated);
        return generatedUrlResponse(urlRequest, savedUrl);
    }




    private static void checkForEmptyInput(UrlRequest urlRequest) throws UrlErrorResponseException {
        if(StringUtils.isEmpty(urlRequest.getOriginalUrl())){
            throw new UrlErrorResponseException(404, "there was an Error processing the request, please try again");
        }
    }


    @Override
    public String getEncodedUrl(String encodedUrl) throws UrlErrorResponseException {
        Validator.validateIsNotEmpty(encodedUrl);
        var foundUrl = urlRepository.findByShortLinkUrl(encodedUrl);
        Validator.validateUrlIsNotNUll(foundUrl);
         validateUrlHasNotExpired(foundUrl);
        return foundUrl.getOriginalUrl();
    }

    public void validateUrlHasNotExpired(Url foundUrl) throws UrlErrorResponseException {
        if(foundUrl.getExpirationDate().isBefore(LocalDateTime.now())){
            deleteShortUrl(foundUrl);
            throw new UrlErrorResponseException(400, "URL expired. Please try generating fresh one.");
        }
    }
    @Override
    public void deleteShortUrl(Url urlLink) {
        urlRepository.delete(urlLink);
    }






}
