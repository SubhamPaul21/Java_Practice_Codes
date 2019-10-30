import java.io.File;
import java.util.*;

class Guess {

    public ArrayList<String> getMovieList(String path) throws Exception {
        File movie_file = new File(path);
        Scanner scanner = new Scanner(movie_file);
        // make array list for adding all movies
        ArrayList<String> movie_list = new ArrayList<String>();
        // until the file "movie.txt" has a next line, add that to the arrayList
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movie_list.add(line);
        }
        return movie_list;
    }

    public String[] getRandomMovie(ArrayList<String> movie_list) {
        int size = movie_list.size();
        int randomInt = (int) (Math.random() * size);
        String random_movie = movie_list.get(randomInt).toLowerCase();
        String hidden_movie_name = random_movie.replaceAll("[a-zA-Z0-9]", "-");
        System.out.println("You are guessing: " + hidden_movie_name);
        return new String[] {random_movie, hidden_movie_name};
    }


}


public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        //System.out.println("Let's Play a Movie Guessing Game today.");
        //System.out.println("I will randomly choose a movie from my database and you have to guess the name.");
        String path = "movies.txt";
        Guess game = new Guess();
        ArrayList<String> movie_list = game.getMovieList(path);
        String[] result = game.getRandomMovie(movie_list);
        String random_movie_name = result[0];
        System.out.println(random_movie_name);
        String hidden_movie_name = result[1];
        StringBuilder myGuess = new StringBuilder(hidden_movie_name);
        ArrayList<String> wrong_guess = new ArrayList<String>();
        boolean hasWon = false;
        for (int j = 10; j > 0 ; j--) {
            System.out.println("You have "+ j +" chances left.");
            //take user input
            Scanner input = new Scanner(System.in);
            System.out.print("Guess a letter: ");
            String letter = input.nextLine().toLowerCase();
            char ch = letter.charAt(0);
            if (random_movie_name.contains(letter)) {
                for (int index = random_movie_name.indexOf(letter); index >= 0; index = random_movie_name.indexOf(letter, index + 1)) {
                    myGuess.setCharAt(index, ch);
                }
                if (myGuess.toString().contains("-")) {
                    //hidden_movie_name = myGuess.toString();
                    System.out.println("You are guessing: " + myGuess);
                } else {
                    hasWon = true;
                    break;
                }
            } else {
                wrong_guess.add(letter);
                System.out.println("You have guessed ("+ wrong_guess.size() +") wrong letters:" + wrong_guess);
            }
            //System.out.println("You are guessing: " + hidden_movie_name);
            //System.out.println(random_movie_name);
        }
        if (hasWon) {
            System.out.println("HURRAY!! You correctly guessed it.");
        } else {
            System.out.println("The movie was: "+ random_movie_name);
            System.out.println("Sorry, you are out of attempts. Better luck next time.");
            System.out.println("You lost!");
        }
    }
}