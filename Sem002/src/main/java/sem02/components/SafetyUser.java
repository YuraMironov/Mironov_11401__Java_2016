package sem02.components;

import java.io.Serializable;

/**
 * Created by Юра on 13.05.2016.
 */
public class SafetyUser implements Serializable{
    private String username;
    private String role;
    private String login;
    private Long id;
    private String email;
    private Integer last;
    private Firm firm;
    private Tarif tarif;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private boolean admin;

    public Tarif getTarif() {
        return tarif;
    }

    public Firm getFirm() {
        return firm;
    }

    public String getEmail() {
        return email;
    }

    public Integer getLast() {
        return last;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
