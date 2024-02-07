package com.app.curs15.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @NotBlank(message = "sender cannot be blank")
    @Size(min = 5, message = "sender must be at least 5 characters long")
    private String sender;
    @Size(min = 5, message = "receiver must be at least 5 characters long")
    @NotBlank(message = "receiver cannot be blank")
    private String receiver;
    @Size(min = 3, max = 250, message = "text must be between 3 and 250 characters long")
    @NotBlank(message = "text cannot be blank")
    private String text;
    @NotNull(message = "seen cannot be blank")
    private Boolean seen;
    @NotNull(message = "sentDate cannot be blank")
    private Date sentDate;
}
