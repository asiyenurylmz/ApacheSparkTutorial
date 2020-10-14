package TransformationExam;

import java.io.Serializable;

public class CupModel implements Serializable{

	String year;
	String hostCountry;
	String winner;
	String runnersUp;
	String third;
	String fourth;
	int goalsScored;
	int qualifiedTeams;
	int matchesPlayed;
	String attendance;
	
	public CupModel(String year, String hostCountry, String winner, String runnersUp, String third, String fourth,
			int goalsScored, int qualifiedTeams, int matchesPlayed, String attendance) {
		super();
		this.year = year;
		this.hostCountry = hostCountry;
		this.winner = winner;
		this.runnersUp = runnersUp;
		this.third = third;
		this.fourth = fourth;
		this.goalsScored = goalsScored;
		this.qualifiedTeams = qualifiedTeams;
		this.matchesPlayed = matchesPlayed;
		this.attendance = attendance;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHostCountry() {
		return hostCountry;
	}

	public void setHostCountry(String hostCountry) {
		this.hostCountry = hostCountry;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getRunnersUp() {
		return runnersUp;
	}

	public void setRunnersUp(String runnersUp) {
		this.runnersUp = runnersUp;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

	public String getFourth() {
		return fourth;
	}

	public void setFourth(String fourth) {
		this.fourth = fourth;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public int getQualifiedTeams() {
		return qualifiedTeams;
	}

	public void setQualifiedTeams(int qualifiedTeams) {
		this.qualifiedTeams = qualifiedTeams;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	
	
}
