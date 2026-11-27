
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private int ID;
    private String author;
    private Platform platform;
    private Genre genre;
    private AgeRating ageRating;
    private double gameRating = 0.0;
    private int numberOfRatings = 0;
    private String gameTitle;

    public Game(String author, Platform platform, Genre genre, AgeRating ageRating, String gameTitle)
    {
        this.author = author;
        this.platform = platform;
        this.genre = genre;
        this.ageRating = ageRating;
        this.gameTitle = gameTitle;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getGameDetails()
    {
        return "Game ID: " + ID
        + " | Game author: " + author
        + " | Game title: " + gameTitle
        + " | Game platform: " + platform
        + " | Game genre: " + genre
        + " | Game age rating: " + ageRating
        + " | Game rating: " + gameRating;
    }
    
    public void calculateRating(double newRating)
    {
        gameRating = ((gameRating * numberOfRatings) + newRating) / (numberOfRatings + 1);
        numberOfRatings++;
    }
    
    public void setRating(double rating)
    {
        gameRating = rating;
    }
    
    public double getRating()
    {
        return gameRating;
    }

    public int getID()
    {
        return ID;
    }

    public String getTitle()
    {
        return gameTitle;
    }
    
    public Genre getGenre()
    {
        return genre;
    }
    
    public Platform getPlatform()
    {
        return platform;        
    }
    
    public AgeRating getAgeRating()
    {
        return ageRating;
    }
}