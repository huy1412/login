package com.example.jewelry;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private Set<XUser> users = new HashSet<>();

    @GetMapping("/users")
    public Set<XUser> getUsers() {
        return this.users;
    }

    @PostMapping("/register")
    public XUser register(@RequestBody XUser user) {
        var persistingUser = XUser.builder()
                .userId(Long.valueOf(users.size() + 1))
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();

        users.add(persistingUser);
        return persistingUser;
    }

    @PostMapping("login")
    public boolean login(@RequestBody Credential credential) {
        var username = credential.getUsername();
        var password = credential.getPassword();
        boolean flag = false;
        for( XUser user: users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                flag=true;
                return flag;
            }
        }
        return flag;
    }

}
