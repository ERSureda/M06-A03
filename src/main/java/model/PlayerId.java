package model;

import java.io.Serializable;
import java.util.Objects;

public class PlayerId implements Serializable {
    private static final long serialVersionUID = 2L;

    private Club club;
    private int id;

    public PlayerId() {}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerId playerId = (PlayerId) o;
        return id == playerId.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
