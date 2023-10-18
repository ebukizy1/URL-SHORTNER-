package com.shorturlserivce.shorturlapplication.controller;

import com.shorturlserivce.shorturlapplication.dto.request.UrlRequest;
import com.shorturlserivce.shorturlapplication.dto.response.UrlResponse;
import com.shorturlserivce.shorturlapplication.service.UrlService;
import com.shorturlserivce.shorturlapplication.validation.UrlErrorResponseException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlService urlService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/generateShortLink")
    public ResponseEntity<UrlResponse> generateShortLink(@RequestBody UrlRequest request) throws UrlErrorResponseException {
        UrlResponse urlResponse = urlService.generateShortLink(request);
        return ResponseEntity.status(HttpStatus.OK).body(urlResponse);
    }
    @GetMapping("/{shortLink}")
    public void redirectToOriginalUrl(@PathVariable String shortLink,  HttpServletResponse response) throws UrlErrorResponseException, IOException {
      String originalUrlRedirect =  urlService.getEncodedUrl(shortLink);
        response.sendRedirect(originalUrlRedirect);
    }

}
