package habsida.spring.boot_security.demo.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String name;
    private String LastName;
    private byte age;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "user_id")},
//                inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
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

    public String toStringRoles() {
        StringBuilder rolesString = new StringBuilder();
        for (Role role : roles) {
            rolesString.append(role.toString()).append(" ");
        }
        return rolesString.toString();
    }

    public boolean findRole(String role) {
        return roles.stream().anyMatch(r -> r.getRole().equals(role));
    }
}
