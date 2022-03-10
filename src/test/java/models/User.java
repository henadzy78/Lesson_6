package models;

import lombok.*;


@Data
@Builder
@ToString (exclude = "email")
public class User {
    private String email;
    private String password;
}
