package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Players")
@IdClass(Player.class)
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "club_abv")
    private String club_abv;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "height")
    private int height;
    @Column(name = "position")
    private String position;
    @Column(name = "Born")
    private Date born;

    public Player() {}

    public Player(String club_abv, String name, int height, String position, Date born) {
        this.club_abv = club_abv;
        this.name = name;
        this.height = height;
        this.position = position;
        this.born = born;
    }

    public String getClub_abv() {
        return club_abv;
    }

    public void setClub_abv(String club_abv) {
        this.club_abv = club_abv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }
}
