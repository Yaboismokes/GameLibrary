import java.util.ArrayList;

/**
 * Write a description of class GameLibrary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameLibrary
{
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();
    private final String LIBRARY_AUTHORS = "Library made by: Asher L. and Herbert C.";
    private final String LIBRARY_CREATION_DATE = "Library created on November 25th, 2026.";
    private final String LIBRARY_COMPLETION_DATE = "Library released for use on December xth, 2026.";

    public GameLibrary()
    {
        addSinglePlayerGame("author1", Platform.XBOX, Genre.RPG, AgeRating.E, "Game 1", 12);
        setGameRating(1, 5.6);
        addMultiPlayerGame("author2", Platform.PC, Genre.ACTION, AgeRating.E10, "Game 2", 4);
        setGameRating(2, 9.8);
    }

    public void addSinglePlayerGame(String author, Platform platform, Genre genre, AgeRating ageRating, String gameTitle, int hoursToFinish)
    {
        Game newGame = new SinglePlayer(author, platform, genre, ageRating, gameTitle, hoursToFinish);
        newGame.setID(games.size() + 1);
        games.add(newGame);

    }

    public void addMultiPlayerGame(String author, Platform platform, Genre genre, AgeRating ageRating, String gameTitle, int maxPlayers)
    {
        Game newGame = new MultiPlayer(author, platform, genre, ageRating, gameTitle, maxPlayers);
        newGame.setID(games.size() + 1);
        games.add(newGame);
    }

    public void printLibraryDetails()
    {
        System.out.println(LIBRARY_AUTHORS);
        System.out.println(LIBRARY_CREATION_DATE);
        System.out.println(LIBRARY_COMPLETION_DATE);
    }

    public void printGameDetails(int ID)
    {
        Game game = findGameByID(ID);
        if (game == null) {
            System.out.println("No game was found with ID " + ID);
            return;
        } else { 
            System.out.println(game.getGameDetails());
        }
    }

    public Game findGameByID(int ID)
    {
        for (Game game : games) {
            if (game.getID() == ID) {
                return game;
            }
        }
        return null;
    }

    public void listAllGames()
    {
        if (games.isEmpty()) {
            System.out.println("No games in the library.");
            return;
        } else {
            System.out.println("----- All Games -----");
            for (Game game: games) {
                System.out.println(game.getID() + ". " + game.getTitle());
            }
        }
    }
    
    public void listAllGamesByGenre(Genre genre)
    {
        boolean found = false;
        if (games.isEmpty()) {
            System.out.println("No games in the library.");
            return;
        } else {
            System.out.println("----- All " + genre + " Games -----");
            for (Game game: games) {
                if (game.getGenre() == genre) {
                    System.out.println("- " + game.getTitle());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No games in the library of this genre.");
            }
        }
    }
    
    public void listAllGamesByPlatform(Platform platform)
    {
        boolean found = false;
        if (games.isEmpty()) {
            System.out.println("No games in the library.");
            return;
        } else {
            System.out.println("----- All " + platform + " Games -----");
            for (Game game: games) {
                if (game.getPlatform() == platform) {
                    System.out.println("- " + game.getTitle());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No games in the library of this platform.");
            }
        }
    }
    
    public void listAllGamesByAgeRating(AgeRating ageRating)
    {
        boolean found = false;
        if (games.isEmpty()) {
            System.out.println("No games in the library.");
            return;
        } else {
            System.out.println("----- All " + ageRating + " Games -----");
            for (Game game: games) {
                if (game.getAgeRating() == ageRating) {
                    System.out.println("- " + game.getTitle());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No games in the library of this age rating.");
            }
        }
    }
    
    public void rateGame(int ID, double rating)
    {
        if (rating < 1 || rating > 10) {
            System.out.println("Rating must be between 1 and 10 inclusive.");
            return;
        }
        Game ratedGame = findGameByID(ID);
        if (ratedGame == null) {
            System.out.println("No game found with ID " + ID);
        } else {
            ratedGame.calculateRating(rating);
            System.out.println("Rating successful. New average rating for " + ratedGame.getTitle() + " is: " + ratedGame.getRating());
        }
    }
    
    public void listAllGamesByRating()
    {
        if (games.isEmpty()) {
            System.out.println("No games in the library.");
            return;
        }
        ArrayList<Game> sortedGamesByRating = new ArrayList<>(games);
        // sortedGamesByRating.sort((gameRating1 , gameRating2) -> Double.compare(gameRating2.getRating(), gameRating1.getRating()));
        
        System.out.println("----- All Games By Rating -----");
        for (Game game : sortedGamesByRating) {
            System.out.println(game.getRating() + ": " + game.getTitle());
        }
    }
    
    public void setGameRating(int ID, double rating)
    {
        if (rating < 1 || rating > 10) {
            System.out.println("Rating must be between 1 and 10 inclusive.");
            return;
        }
        Game ratedGame = findGameByID(ID);
        if (ratedGame == null) {
            System.out.println("No game found with ID " + ID);
        } else {
            ratedGame.setRating(rating);
        }
    }
}