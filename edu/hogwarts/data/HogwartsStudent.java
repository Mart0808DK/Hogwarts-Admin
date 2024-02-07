package edu.hogwarts.data;

import edu.generic.Student;

import java.time.LocalDate;

public class HogwartsStudent extends Student implements HogwartsPerson{

    private House house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(House house, boolean prefect, String[] teams, int enrollmentYear, int graduationYear, boolean graduated, String fullname, LocalDate birthDate) {
        super(enrollmentYear, graduationYear, graduated, fullname, birthDate);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent() {
        super();
        this.teams = new String[0];
        this.house = new House();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public String toString() {
        StringBuilder teamsString = new StringBuilder();
        if (teams.length > 0) {
            for (String team : teams) {
                teamsString.append(team).append(", ");
            }
            teamsString.replace(teamsString.lastIndexOf(", "), teamsString.length()-1, ".");
        }
        return "edu.hogwarts.data.HogwartsStudent{\n" +
                " fullName: " + getFullName() + "\n" +
                " enrollmentYear: " + getEnrollmentYear() + "\n" +
                " graduationYear: " + getGraduationYear() + "\n" +
                " graduated: " + isGraduated() + "\n" +
                " house: " + house.getName() + "\n" +
                " prefect: " + prefect + "\n" +
                " teams: " + teamsString + "\n" +
                "}";

    }
}
