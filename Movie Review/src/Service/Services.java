package Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

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
			if(userList.get(i).getUserName().equalsIgnoreCase(user)&&userList.get(i).getRole().equalsIgnoreCase("critic"))
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
		if(count>=2){
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
	
	public ArrayList<Movie> topNmoviesByAllInYearWise(ArrayList<Movie> movieList,int year,int n){
		PriorityQueue<Movie> pq = new PriorityQueue<>();
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getYear()==year){
				if(pq.size()==n){
					if(pq.peek().getTotalRating()<movieList.get(i).getTotalRating()){
						pq.poll();
						pq.add(movieList.get(i));
					}
				}
				else{
					pq.add(movieList.get(i));
				}
			}
		}
		ArrayList<Movie> list = new ArrayList<>();
		while(pq.size()!=0){
			list.add(pq.poll());
		}
		return list;
	}

	public void increaseTotalRating(ArrayList<Movie> movieList, String name, int rating) {
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getName().equalsIgnoreCase(name)){
				Movie m = movieList.get(i);
				movieList.remove(m);
				m.increaseTotalRating(rating);
				movieList.add(m);
				return;
			}
		}
	}

	public ArrayList<Movie> topNmoviesByAllGenereWise(ArrayList<Movie> movieList, String genere, int n) {
		PriorityQueue<Movie> pq = new PriorityQueue<>();
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getGenere().equalsIgnoreCase(genere)){
				if(pq.size()==n){
					if(pq.peek().getTotalRating()<movieList.get(i).getTotalRating()){
						pq.poll();
						pq.add(movieList.get(i));
					}
				}
				else{
					pq.add(movieList.get(i));
				}
			}
		}
		ArrayList<Movie> list = new ArrayList<>();
		while(pq.size()!=0){
			list.add(pq.poll());
		}
		return list;
	}

	public ArrayList<Movie> topNmoviesByCrticGenereWise(ArrayList<Movie> movieList, String genere, int n) {
		PriorityQueue<Movie> pq = new PriorityQueue<>(new comp());
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getGenere().equalsIgnoreCase(genere)){
				if(pq.size()==n){
					if(pq.peek().getCrticRating()<movieList.get(i).getCrticRating()){
						pq.poll();
						pq.add(movieList.get(i));
					}
				}
				else{
					pq.add(movieList.get(i));
				}
			}
		}
		ArrayList<Movie> list = new ArrayList<>();
		while(pq.size()!=0){
			list.add(pq.poll());
		}
		return list;
	}

	public ArrayList<Movie> topNmoviesByCriticInYearWise(ArrayList<Movie> movieList, int year,int n) {
		PriorityQueue<Movie> pq = new PriorityQueue<>(new comp());
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getYear()==year){
				if(pq.size()==n){
					if(pq.peek().getCrticRating()<movieList.get(i).getCrticRating()){
						pq.poll();
						pq.add(movieList.get(i));
					}
				}
				else{
					pq.add(movieList.get(i));
				}
			}
		}
		ArrayList<Movie> list = new ArrayList<>();
		while(pq.size()!=0){
			list.add(pq.poll());
		}
		return list;
	}

	public void increaseCriticRating(ArrayList<Movie> movieList, String name, int rating) {
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getName().equalsIgnoreCase(name)){
				Movie m = movieList.get(i);
				movieList.remove(m);
				m.increaseCrticRating(rating);
				movieList.add(m);
				return;
			}
		}
	}

	public void increaseTotalReviews(ArrayList<Movie> movieList, String name) {
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getName().equalsIgnoreCase(name)){
				Movie m = movieList.get(i);
				movieList.remove(m);
				m.increaseTotalReviews();
				movieList.add(m);
				return;
			}
		}
	}
	
	public double avgReviewScoreYearWise(ArrayList<Movie> movieList,int year){
		int totalRating = 0;
		int totalReviews = 0;
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getYear()==year){
				totalRating = totalRating+movieList.get(i).getTotalRating();
				totalReviews = totalReviews+movieList.get(i).getTotalReviews();
			}
		}
		if(totalRating==0)
			return 0;
		return totalRating/totalReviews;
	}
	
	public double avgReviewScoreGenereWise(ArrayList<Movie> movieList,String genere){
		int totalRating = 0;
		int totalReviews = 0;
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getGenere().equalsIgnoreCase(genere)){
				totalRating = totalRating+movieList.get(i).getTotalRating();
				totalReviews = totalReviews+movieList.get(i).getTotalReviews();
			}
		}
		if(totalRating==0)
			return 0;
		return totalRating/totalReviews;
	}
	
	public double avgReviewScoreMovieWise(ArrayList<Movie> movieList,String Movie){
		int totalRating = 0;
		int totalReviews = 0;
		for(int i=0;i<movieList.size();i++){
			if(movieList.get(i).getName().equalsIgnoreCase(Movie)){
				totalRating = totalRating+movieList.get(i).getTotalRating();
				totalReviews = totalReviews+movieList.get(i).getTotalReviews();
				break;
			}
		}
		if(totalRating==0)
			return 0;
		return totalRating/totalReviews;
	}
}
class comp implements Comparator<Movie>{

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getCrticRating()-o2.getCrticRating();
	}
	
}
