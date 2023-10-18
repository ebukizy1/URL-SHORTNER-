package com.shorturlserivce.shorturlapplication.data.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Url")
public class Url {
    @Id
    private String id;
    private String originalUrl;
    private String shortLinkUrl;
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;

}
