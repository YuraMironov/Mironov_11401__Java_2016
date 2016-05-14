package ru.kpfu.itis.Mironov.SE.entities;

import javax.persistence.*;

/**
 * Created by Юра on 10.05.2016.
 */
@Entity
@Table(name = "claimstarif")
public class ClaimTarif {
    private Integer id;
    private Long userid;
    private Long newtarifid;
    private String comment;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
    @Column(name = "newtarifid")
    public Long getNewtarifid() {
        return newtarifid;
    }

    public void setNewtarifid(Long newtarifid) {
        this.newtarifid = newtarifid;
    }
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
