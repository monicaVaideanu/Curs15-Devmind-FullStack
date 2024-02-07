package com.app.curs15.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @NotBlank(message = "sender cannot be blank")
    private String sender;
    @NotBlank(message = "receiver cannot be blank")
    private String receiver;
    @NotBlank(message = "text cannot be blank")
    private String text;
    @NotNull(message = "seen cannot be blank")
    private Boolean seen;
    @NotNull(message = "sentDate cannot be blank")
    private Date sentDate;
}
