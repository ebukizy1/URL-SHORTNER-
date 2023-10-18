package com.shorturlserivce.shorturlapplication.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UrlErrorResponseException extends Exception {
    private  int  status;
    private String message;


}
