//package com.shorturlserivce.shorturlapplication.service;
//
//import com.shorturlserivce.shorturlapplication.data.model.Url;
//import com.shorturlserivce.shorturlapplication.dto.request.UrlRequest;
//import com.shorturlserivce.shorturlapplication.validation.UrlErrorResponseException;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class UrlServicesTest {
//
//    @Autowired
//    private UrlService urlService;
//    @Test
//    public void testShortLinkURLCanBeGenerated() throws UrlErrorResponseException {
//        UrlRequest urlRequest = new UrlRequest();
//        urlRequest.setLongUrl("https://chat.openai.com/c/cc66c92e-09cc-4719-84d5-d66c5a338cc3");
////        urlRequest.setExpirationDate();
//       Url urlResponse =  urlService.generateShortLink(urlRequest);
//       assertNotNull(urlResponse);
//    }
//    @Test
//    public void testShorUrlCanBeFetch(){
//        Url url = urlService.getEncodedUrl("407410e2");
//        assertNotNull(url);
//    }
//    @Test
//    public void testShortUrlCanBeDeleted(){
////        urlService.deleteShortUrl("407410e2");
//
//
//    }
//
//
//
//
//}
