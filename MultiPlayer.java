
/**
 * Write a description of class MultiPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MultiPlayer extends Game
{
    private int maxPlayers;

    public MultiPlayer(String author, Platform platform, Genre genre, AgeRating ageRating, String gameTitle, int maxPlayers)
    {
        super(author, platform, genre, ageRating, gameTitle);
        this.maxPlayers = maxPlayers;
    }

    public String getGameDetails()
    {
        return super.getGameDetails()
        + " | Max Players: " + maxPlayers;
        
    }
}