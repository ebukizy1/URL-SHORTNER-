package com.shorturlserivce.shorturlapplication.data.repositories;


import com.shorturlserivce.shorturlapplication.data.model.Url;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
Url findByShortLinkUrl(String shortUrl);

//    void delete(String urlLink);
}
