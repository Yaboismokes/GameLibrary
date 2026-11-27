
/**
 * Write a description of class SinglePlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SinglePlayer extends Game
{
    private int hoursToFinish;

    public SinglePlayer(String author, Platform platform, Genre genre, AgeRating ageRating, String gameTitle, int hoursToFinish)
    {
        super(author, platform, genre, ageRating, gameTitle);
        this.hoursToFinish = hoursToFinish;
    }

    public String getGameDetails()
    {
        return super.getGameDetails()
        + " | Hours to finish: " + hoursToFinish;
    }
}