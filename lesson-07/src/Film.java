public class Film {

    /*
     4. Studio Ghibli films
     Create a class Film, which would have private fields title, director, producer, release
     date and running time (and description as an extra challenge). Create a constructor,
     as well as getters for the fields.
     Write a program that reads data from a text file with data about Studio Ghibli films
     using a Scanner, which would create a class Film object for each film with
     corresponding data from the file (at least 5 films). Create a text-based user interface
     to show a user information about films.
     The data source: https://ghibliapi.vercel.app/films
     You need to save this data into a text file, which the program will read.
    */

    private final String title;
    private final String director;
    private final String producer;
    private final String releaseDate;
    private final String runningTime;
    private final String description;

    public Film(String title, String director, String producer, String releaseDate, String runningTime, String description) {
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public String getDescription() {
        return description;
    }
}