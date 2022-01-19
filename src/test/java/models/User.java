package models;

import lombok.*;

@Data
@Builder
public class User {
    private String email;
    private String password;
}
