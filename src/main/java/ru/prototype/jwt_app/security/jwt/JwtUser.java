package ru.prototype.jwt_app.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.prototype.jwt_app.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            Long id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password, Collection<? extends GrantedAuthority> authorities,
            boolean enabled,
            Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
