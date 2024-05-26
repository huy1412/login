package com.example.jewelry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class XUser {
    private Long userId;
    private String username;
    private String password;
    private String email;
}
