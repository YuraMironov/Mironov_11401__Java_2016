package ru.kpfu.itis.Mironov.SE.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "users")
public class MyUser implements UserDetails {

    private Long id;
    private Firm firm;
    private String role;
    private Tarif tarif;
    private Integer last;
    private String login;
    private String email;
    private String password;
    private boolean enabled;
    private boolean nonlocked;

    @Transient
    public SafetyUser getSafetyUser(){
        SafetyUser safetyUser =  new SafetyUser();
        safetyUser.setUsername(getUsername());
        safetyUser.setLogin(getLogin());
        safetyUser.setId(getId());
        safetyUser.setLast(getLast());
        safetyUser.setTarif(getTarif());
        safetyUser.setFirm(getFirm());
        safetyUser.setEmail(getEmail());
        safetyUser.setRole(getRole());
        safetyUser.setAdmin(isAdmin());
        return safetyUser;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for(String s: getRole().split(",")){
            grantedAuthorities.add(new SimpleGrantedAuthority(s.trim().toUpperCase()));
        }
        return grantedAuthorities;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Transient
    public String getUsername() {
        return getEmail();
    }

    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Column(name = "nonlocked")
    public boolean isNonlocked() {
        return nonlocked;
    }
    public void setNonlocked(boolean nonlocked) {
        this.nonlocked = nonlocked;
    }
    @Transient
    public boolean isAccountNonLocked() {
        return isNonlocked();
    }

    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "last")
    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_tarif")
    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_produce")
    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
    @Transient
    public boolean isAdmin(){
        return getRole().toUpperCase().contains("ADMIN");
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", last=" + last +
                ", role='" + role + '\'' +
                ", tarif=" + tarif +
                ", enabled=" + enabled +
                ", firm=" + firm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser user = (MyUser) o;

        if (enabled != user.enabled) return false;
        if (!id.equals(user.id)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!last.equals(user.last)) return false;
        if (!role.equals(user.role)) return false;
        if (!tarif.equals(user.tarif)) return false;
        return firm.equals(user.firm);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + last.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + tarif.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + firm.hashCode();
        return result;
    }
}
