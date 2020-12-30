package Main;

import java.util.ArrayList;
import java.util.Calendar;

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
		Movie m1 = new Movie("Padman", "Info", 2020);
		Movie m2 = new Movie("DON", "Action & Comedy", 2006);
		Movie m3 = new Movie("DOON", "Action", 2006);
		Movie m4 = new Movie("PAA", "Action", 2006);
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
//		Movie m3 = new Movie("DON", "Action & Comedy", 2006);
//		if(srv.movieDoesnotExist(m3.getName(), movieList));{
//			movieList.add(m1);
//		}
		
		Review rr = new Review("Deepak", "DON", 10);
		reviewList.add(rr);
		Review r = new Review("Deepak", "DOON", 10);
		reviewList.add(r);
		Review r1 = new Review("Deepak", "PADMAN", 10);
		reviewList.add(r1);
		Review r3 = new Review("Deepak", "PAA", 10);
		reviewList.add(r3);
		System.out.println(reviewList.get(3).getRating());
		System.out.println(userList.get(0).getRole());
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
	
}
