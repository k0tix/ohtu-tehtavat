
package ohtu;

public class Player {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private int penalties;
    private String nationality;
    private String birthdate;

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getPoints() {
        return this.goals + this.assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-25s %s %2d + %2d = %2d", this.getName(), this.getTeam(), this.getGoals(), this.getAssists(), this.getPoints());
    }
      
}
