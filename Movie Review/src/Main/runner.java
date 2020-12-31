package Main;

import java.util.ArrayList;

import Bean.Movie;
import Bean.Review;
import Bean.User;
import Service.Services;

public class runner {
	static ArrayList<User> userList ;
	static ArrayList<Movie> movieList;
	static ArrayList<Review> reviewList;
	public static void main(String[] args) throws Exception{
		Services srv = new Services();
		 userList = new ArrayList<>();
		 movieList = new ArrayList<>();
		 reviewList = new ArrayList<>();
		User ur = new User("Deepak");
		userList.add(ur);
		User u = new User("Abhi");
		userList.add(u);
		Movie m1 = new Movie("Padman", "Info", 2020);
		Movie m2 = new Movie("DON", "Action & Comedy", 2006);
		Movie m3 = new Movie("DOON", "Action", 2006);
		Movie m4 = new Movie("PAA", "Action", 2006);
		Movie m5 = new Movie("PAAT", "Action", 2006);
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		//movieList.add(m5);
//		
		
		Review rr = new Review("Deepak", "DON", 10);
		reviewList.add(rr);
		Review r = new Review("Deepak", "DOON", 10);
		reviewList.add(r);
		Review r1 = new Review("Deepak", "PADMAN", 10);
		reviewList.add(r1);
		Review r3 = new Review("Deepak", "PAA", 10);
		reviewList.add(r3);
		Review rr1 = new Review("Abhi", "DON", 10);
		reviewList.add(rr1);
		Review r12 = new Review("Abhi", "DOON", 10);
		reviewList.add(r12);
		Review r11 = new Review("Abhi", "PADMAN", 10);
		reviewList.add(r11);
		Review r31 = new Review("Abhi", "PAA", 10);
		reviewList.add(r31);
		//Review r4 = new Review("Deepak", "PAAT", 10);
		//reviewList.add(r4);
		//System.out.println(reviewList.get(3).getRating());
		ArrayList<Movie> moviesyear = srv.topNmoviesByAllInYearWise(movieList, 2006, 3);
		ArrayList<Movie> moviesbygenere = srv.topNmoviesByAllGenereWise(movieList, "Drama", 3);
		ArrayList<Movie> moviegenereCritic = srv.topNmoviesByCrticGenereWise(movieList,userList,reviewList, "Drama", 2);
		ArrayList<Movie> movieyearcritic = srv.topNmoviesByCriticInYearWise(movieList,userList, 2006, 2);
		for(int i=0;i<movies.size();i++){
			System.out.println(movies.get(i).getTotalRating()+" "+movies.get(i).getName());
		}
		
	}
	public boolean checkUserExists(String user) {
		Services srv = new Services();
		return srv.checkUserExists(user,userList);
	}
	public boolean checkRoleAsCritic(String user) {
		Services srv = new Services();
		return srv.checkRoleAsCritic(user, userList);
	}
	public boolean checkMovieRated(String user, String name) {
		Services srv = new Services();
		return srv.checkMovieRated(user,name,reviewList);
	}
	public void upgradeUser(String user) {
		Services srv = new Services();
		srv.upgradeUser(user,reviewList,userList);
	}
	public int getMovieYear(String name) throws Exception {
		Services srv = new Services();
		return srv.getMovieYear(name,movieList);
	}
	public boolean movieExists(String name) throws Exception {
		Services srv = new Services();
		return srv.checkMovieExists(name,movieList);
	}
	public boolean checkMovieExists(String name) throws Exception {
		Services srv = new Services();
		return srv.checkMovieExists(name, movieList);
	}
	public void increaseTotalRating(String name, int rating) {
		Services srv = new Services();
		srv.increaseTotalRating(movieList,name,rating);
	}
	
}
