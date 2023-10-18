package com.shorturlserivce.shorturlapplication.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UrlResponse {
    private String originalUrl;
    private String shortLinkUrl;
    private LocalDateTime expirationDate;
}
