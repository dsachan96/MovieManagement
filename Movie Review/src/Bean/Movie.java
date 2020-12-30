package Bean;

import Main.runner;

public class Movie {
	String name;
	String genere;
	int year;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Movie(String name, String genere, int year) throws Exception {
		runner r = new runner();
		if(!r.checkMovieExists(name)){
		this.name = name;
		this.genere = genere;
		this.year = year;
		}
		else
			throw new Exception("Movie Already exists");
	}
	public Movie(String name){
		this.name = name;
	}
}
