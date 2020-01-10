package google;

import google.GoogleSearchTest;

public class Main {

	public static void main(String[] args) {

		GoogleSearchTest rottenTomatoes = new GoogleSearchTest("https://developer.fandango.com/rotten_tomatoes", "https://www.google.com/");
		rottenTomatoes.setPageTitle("https://www.google.com/");
		rottenTomatoes.setSearchField();
		rottenTomatoes.setSearchText("Rotten Tomatoes API");
		rottenTomatoes.searchText();
		rottenTomatoes.getFinalResult();
		rottenTomatoes.close();
	}

}
