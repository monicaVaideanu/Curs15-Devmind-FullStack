package com.app.curs15.utils;

import com.app.curs15.models.Message;

import java.util.Date;

public class MessageMockValid {
    public static Message createValidMockedMessage(){
        return Message.builder()
                .sender("Ion Popescu")
                .receiver("Vasilevici Mihai")
                .text("hello")
                .seen(true)
                .sentDate(new Date())
                .build();
    }
}
