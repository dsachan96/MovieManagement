package Service;

import java.util.ArrayList;

import Bean.Movie;
import Bean.Review;
import Bean.User;

public class Services {
	public boolean checkUserExists(String user,ArrayList<User> userList){
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getUserName().equalsIgnoreCase(user))
				return true;
		}
		return false;
	}

	public boolean checkRoleAsCritic(String user,ArrayList<User> userList) {
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getUserName().equalsIgnoreCase("critic"))
				return true;
		}
		return false;
	}

	public boolean checkMovieRated(String user, String movie, ArrayList<Review> reviewList) {
		
		for(int i=0;i<reviewList.size();i++){
			if(reviewList.get(i).getUserName().equalsIgnoreCase(user) && reviewList.get(i).getMovieName().equalsIgnoreCase(movie))
				return true;
		}
		return false;
	}

	public void upgradeUser(String user, ArrayList<Review> reviewList, ArrayList<User> userList) {
		User ur = null;
		for(int i=0;i<userList.size();i++){
			if(user.equalsIgnoreCase(userList.get(i).getUserName())){
				ur = userList.get(i);
			}
		}
		int count = 0;
		for(int i=0;i<reviewList.size();i++){
			if(reviewList.get(i).getUserName().equalsIgnoreCase(user)){
				count++;
			}
		}
		if(count>=3){
			userList.remove(ur);
			ur.modify();
			userList.add(ur);
		}
	}

	public int getMovieYear(String name, ArrayList<Movie> movieList) throws Exception  {
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getName().equalsIgnoreCase(name)){
				return movieList.get(i).getYear();
			}
		}
		throw new Exception("Movie Not in List");
	}

	public boolean checkMovieExists(String name, ArrayList<Movie> movieList)  {
		for(int i=0;i<movieList.size();i++){
			if(name.equalsIgnoreCase(movieList.get(i).getName())){
				return true;
			}
		}
		return false;
	}
}
