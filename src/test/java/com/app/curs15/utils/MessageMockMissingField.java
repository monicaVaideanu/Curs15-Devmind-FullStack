package com.app.curs15.utils;

import com.app.curs15.models.Message;

import java.util.Date;

public class MessageMockMissingField {
    public static Message createInvalidMessage(){
        return Message.builder()
                .sender("")
                .receiver("Vasilevici Mihai")
                .text("hello")
                .seen(true)
                .sentDate(new Date())
                .build();
    }
}
