package model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

public class ResultId implements Serializable {
    private static final long serialVersionUID = 2L;

    private Date date;
    private String homeTeam;
    private String awayTeam;

    public ResultId() {}

    @Override
    public int hashCode() {
        return Objects.hash(date, homeTeam, awayTeam);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultId resultId = (ResultId) o;
        return Objects.equals(date, resultId.date) &&
                Objects.equals(homeTeam, resultId.homeTeam) &&
                Objects.equals(awayTeam, resultId.awayTeam);
    }
}
