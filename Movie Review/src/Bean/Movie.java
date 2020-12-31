package Bean;

import Main.runner;

public class Movie implements Comparable<Movie> {
	String name;
	String genere;
	int year;
	int totalRating;
	int criticRating;
	int totalReviews;
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
		this.totalRating = 0;
		this.criticRating = 0;
		this.totalReviews = 0;
		}
		else
			throw new Exception("Movie Already exists");
	}
	public Movie(String name){
		this.name = name;
	}
	public void increaseTotalRating(int rating) {
		this.totalRating += rating;
	}
	public int getTotalRating(){
		return this.totalRating;
	}
	public void increaseCrticRating(int rating){
		this.criticRating += rating;
	}
	public int getCrticRating(){
		return this.criticRating;
	}
	public void increaseTotalReviews(){
		this.totalReviews += 1;
	}
	public int getTotalReviews(){
		return this.totalReviews;
	}
	@Override
	public int compareTo(Movie o) {
		return this.totalRating - o.totalRating;
	}
}
