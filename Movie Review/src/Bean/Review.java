package Bean;

import java.util.Calendar;

import Main.runner;

public class Review {
	int rating;
	String movieName;
	String userName;
	public Review(String user ,String name,int rating) throws Exception {
		runner r = new runner();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(r.getMovieYear(name)>currentYear){
			throw new Exception("Movie Yet To be Released");
		}
		if(r.movieExists(name)){
			if(r.checkUserExists(user))
			{
				if(!r.checkMovieRated(user,name)){
					if(r.checkRoleAsCritic(user)){
						//System.out.println("here");
						this.rating = rating*2;
					}
					else{
						this.rating = rating;
					}
					this.movieName = name;
					this.userName = user;
					r.upgradeUser(user);
					r.increaseTotalRating(name,this.rating);
				}
				else
					throw new Exception("Movie Already Rated by the user");
			}
			else{
				throw new Exception("User Doesnot Exist");
			}
		}
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
