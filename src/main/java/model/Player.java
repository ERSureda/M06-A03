package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Players")
//@IdClass(PlayerId.class)
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "Club_abv")
    private Club club;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "height")
    private int height;
    @Column(name = "position")
    private String position;


    public Player() {}

    public Player(Club club, String name, int height, String position) {
        this.club = club;
        this.name = name;
        this.height = height;
        this.position = position;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
