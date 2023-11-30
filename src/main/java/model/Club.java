package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clubs")
public class Club {
    private static final long serialVersionUID = 1L;
    @Column(name = "club_name")
    private String club_name;
    @Id
    @Column(name = "abv")
    private String abv;
    @Column(name = "hex_code")
    private String hex_code;
    @Column(name = "logo_link")
    private String logo_link;

    public Club() {}

    public Club(String clubName, String abv, String hexCode, String logoLink) {
        this.club_name = clubName;
        this.abv = abv;
        this.hex_code = hexCode;
        this.logo_link = logoLink;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getHex_code() {
        return hex_code;
    }

    public void setHex_code(String hex_code) {
        this.hex_code = hex_code;
    }

    public String getLogo_link() {
        return logo_link;
    }

    public void setLogo_link(String logo_link) {
        this.logo_link = logo_link;
    }

    @Override
    public String toString() {
        return "Team{" +
                "club_name='" + club_name + '\'' +
                ", abv='" + abv + '\'' +
                ", hex_code='" + hex_code + '\'' +
                ", logo_link='" + logo_link + '\'' +
                '}';
    }
}
