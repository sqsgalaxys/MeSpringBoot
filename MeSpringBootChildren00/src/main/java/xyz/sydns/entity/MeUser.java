package xyz.sydns.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;

/**
 * @author sqsgalaxys
 */
@Data
@Entity
public class MeUser implements UserDetails {

    /// todo private static final long serialVersionUID = 1L;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long meId;
    private String meName;
    private String mePassword;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /// return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ONE"));
    }

    @Override
    public String getPassword() {
        return this.mePassword;
    }

    @Override
    public String getUsername() {
        return this.meName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
