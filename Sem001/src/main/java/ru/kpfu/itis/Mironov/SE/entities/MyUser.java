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
    private String login;
    private String password;
    private String email;
    private Long userProduce;
    private Integer last;
    private Long userTarif;
    private String role;
    private Tarif tarif;


    private boolean enabled;

    private Firm firm;
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
        grantedAuthorities.add(new SimpleGrantedAuthority(this.getRole().toUpperCase()));
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
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        System.out.println(enabled + "user");
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
    @Column(name = "user_Produce")
    public Long getUserProduce() {
        return userProduce;
    }

    public void setUserProduce(Long userProduce) {
        this.userProduce = userProduce;
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
    @Column(name = "user_tarif")
    public Long getUserTarif() {
        return userTarif;
    }

    public void setUserTarif(Long userTarif) {
        this.userTarif = userTarif;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_tarif")
//    public Tarif getTarif() {
//        return tarif;
//    }
//
//    public void setTarif(Tarif tarif) {
//        this.tarif = tarif;
//    }
//
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_firm")
//    public Firm getFirm() {
//        return firm;
//    }
//
//    public void setFirm(Firm firm) {
//        this.firm = firm;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser myUsers = (MyUser) o;

        if (id != null ? !id.equals(myUsers.id) : myUsers.id != null) return false;
        if (login != null ? !login.equals(myUsers.login) : myUsers.login != null) return false;
        if (password != null ? !password.equals(myUsers.password) : myUsers.password != null) return false;
        if (email != null ? !email.equals(myUsers.email) : myUsers.email != null) return false;
        if (userProduce != null ? !userProduce.equals(myUsers.userProduce) : myUsers.userProduce != null)
            return false;
        if (last != null ? !last.equals(myUsers.last) : myUsers.last != null) return false;
        if (userTarif != null ? !userTarif.equals(myUsers.userTarif) : myUsers.userTarif != null) return false;
        if (role != null ? !role.equals(myUsers.role) : myUsers.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userProduce != null ? userProduce.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + (userTarif != null ? userTarif.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", userProduce=" + userProduce +
                ", last=" + last +
                ", userTarif=" + userTarif +
                ", role='" + role + '\'' +
                '}';
    }
}
