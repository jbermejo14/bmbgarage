package org.bmbgarage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    private int id;
    private String username;
    private String email;
    private String phonenumber;
    private String userpassword;
    private String role;
}
