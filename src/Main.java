import java.util.Scanner;
import java.sql.*;

import Movie.*;
import Viewer.*;
import Cinema.*;
import org.example.oopshka.*;
import org.example.oopshka.dao.MovieDao;

public class Main {
  public static void main(String[] args) {


//    ArrayList<Movie> movies = new ArrayList<>();
//    movies.add(new Movie("The SpongeBob Movie: Search for SquarePants", "01:32:21", 2025));
//    movies.add(new Movie("Toy Story", "01:21:00", 1995));
//    movies.add(new Movie("Finding sadasdasdsadNemo", "01:40:00", 2003));
//    movies.add(new Movie("The Incredibles", "01:55:00", 2004));
//
//    ArrayList<Viewer> viewers = new ArrayList<>();
//    viewers.add(new Viewer("Darkan", "Ualiev", movies.get(0).getName()));
//    viewers.add(new Viewer("Aidar", "Sultanov", movies.get(1).getName()));
//    viewers.add(new Viewer("Nursultan", "Bekov", movies.get(2).getName()));
//    viewers.add(new Viewer("Arman", "Kenesov", movies.get(3).getName()));
//
//
//    ArrayList<Cinema> cinemas = new ArrayList<>();
//    cinemas.add(new Cinema("Aru cinema", 32));
//    cinemas.add(new Cinema("Chaplin", 20));
//    cinemas.add(new Cinema("Keruen Cinema", 120));
//    cinemas.add(new Cinema("Eurasia Cinema", 45));
//
//
//    Scanner sc = new Scanner(System.in);
//
//    for (int i = 0; i<viewers.size(); i++){
//      System.out.println(viewers.get(i));
//    }
//
//    String firstName = sc.nextLine();
//    String lastName = sc.nextLine();
//    int movienumber = sc.nextInt();
//    sc.nextLine();
//
//
//    Viewer view1 = new Viewer(firstName, lastName, movies.get(movienumber - 1).getName());
//    viewers.add(view1);
//
//
//    for (int i = 0; i < movies.size(); i++){
//      if (movies.get(i).getYear() == 2025) {
//        System.out.println(movies.get(i));
//      }
//      else {System.out.println("The film's year is not 2025");}
//    }
//
//    for (int i = 0; i<viewers.size(); i++){
//      System.out.println(viewers.get(i));
//    }


//    org.example.oopshka.dao.MovieDao movieDao = new org.example.oopshka.dao.MovieDao();
//
//    try {
//      // CREATE
//      Movie m = new Movie("Toy Story", "01:21:00", 1995);
//      int newId = movieDao.insertMovie(m);
//      System.out.println("Inserted movie id = " + newId);
//
//      // READ
//      System.out.println("All movies:");
//      for (Movie x : movieDao.getAllMovies()) {
//        System.out.println(x);
//      }
//
//      // UPDATE
//      boolean upd = movieDao.updateMovieYear(newId, 1996);
//      System.out.println("Updated? " + upd);
//
//      // DELETE
//      boolean del = movieDao.deleteMovie(newId);
//      System.out.println("Deleted? " + del);
//
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }

    Scanner sc = new Scanner(System.in);
    MovieDao movieDao = new MovieDao();
    ViewerDao viewerDao = new ViewerDao();
    CinemaDao cinemaDao = new CinemaDao();
    try {
      while (true) {
        System.out.println("Choose option:\n" +
                "1.Movie\n" +
                "2.Viewer\n" +
                "3.Create your tables\n" +
                "4.Show all tables\n" +
                "5.Delete tables\n" +
                "6.Cinema\n"+
                "0.Exit\n");


        int tablenumber = sc.nextInt();
        sc.nextLine();


        if (tablenumber == 1) {
          while (true) {
            System.out.println("Choose function:\n" +
                    "1. Enter data\n" +
                    "2. Show data\n" +
                    "3. Update year\n" +
                    "4. Update name\n" +
                    "5. Delete data\n" +
                    "7. Update Description\n" +
                    "8. Create column\n" +
                    "6. Quit\n");

            int actionnumber = sc.nextInt();
            sc.nextLine();


            if (actionnumber == 1) {
              System.out.println("Enter name: ");
              String name = sc.nextLine();
              System.out.println("Enter duration: ");
              String duration = sc.nextLine();
              System.out.println("Enter year: ");
              int year = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter description: ");
              String description = sc.nextLine();
              Movie m = new Movie(name, duration, description, year);
              int newId = movieDao.insertMovie(m);
              System.out.println("Inserted movie id = " + newId);
            }

            else if (actionnumber == 2) {
              System.out.println("All movies:");
              for (Movie x : movieDao.getAllMovies()) {
                System.out.println(x);
              }
            }


            else if (actionnumber == 8) {
              System.out.println("Enter column's name");
              String name = sc.nextLine();

              movieDao.MovieaddColumn(name);
            }


            else if(actionnumber == 7) {
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter description: ");
              String description = sc.nextLine();
              boolean upd = movieDao.updateMovieDescription(id, description);
              System.out.println("Updated? " + upd);
            }


            else if (actionnumber == 3) {
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              System.out.println("Enter year: ");
              int year = sc.nextInt();
              sc.nextLine();
              boolean upd = movieDao.updateMovieYear(id, year);
              System.out.println("Updated? " + upd);
            }

            else if (actionnumber == 4) {
              System.out.println("Enter id : ");
              int id = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter name: ");
              String name = sc.nextLine();
              boolean upd = movieDao.updateMovieName(id, name);
              System.out.println("Updated? " + upd);
            }

            else if (actionnumber == 5) {
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              boolean del = movieDao.deleteMovie(id);
              System.out.println("Deleted? " + del);
            }

            else if (actionnumber == 6) break;
          }
        }



        else if (tablenumber == 2){
          while (true) {
            System.out.println("Choose function:\n" +
                    "1. Enter data\n" +
                    "2. Show data\n" +
                    "3. Update film\n" +
                    "4. Update firstname\n" +
                    "5. Update lastname\n" +
                    "6. Delete data\n" +
                    "7. Quit\n");
            int actionnumber = sc.nextInt();
            sc.nextLine();


            if (actionnumber == 1){
              System.out.println("Enter firstname: ");
              String firstname = sc.nextLine();
              System.out.println("Enter last_name: ");
              String lastName = sc.nextLine();
              System.out.println("Enter movie: ");
              String movie = sc.nextLine();

              Viewer v = new Viewer(firstname, lastName, movie);
              int newId = viewerDao.insertViewer(v);
              System.out.println("Inserted viewer id = " + newId);
            }


            else if (actionnumber == 2){
              System.out.println("All viewers: ");
              for (Viewer x : viewerDao.getAllViewers()){
                System.out.println(x);
              }
            }


            else if (actionnumber == 3){
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter movie: ");
              String movie = sc.nextLine();

              boolean upd = viewerDao.updateViewerMovie(id, movie);
              System.out.println("Updated? " + upd);
            }


            else if (actionnumber == 4){
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter firstName: ");
              String firstName = sc.nextLine();

              boolean upd = viewerDao.updateViewerFirstName(id, firstName);
              System.out.println("Updated? " + upd);
            }


            else if (actionnumber == 5){
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter lastName: ");
              String lastName = sc.nextLine();

              boolean upd = viewerDao.updateViewerLastName(id, lastName);
              System.out.println("Updated? " + upd);
            }


            else if (actionnumber == 6){
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              boolean del = viewerDao.deleteViewer(id);
              System.out.println("Deleted? "+del);
            }
            else if (actionnumber == 7) break;
          }
        }


        else if (tablenumber == 0) break;


        else if (tablenumber == 3) {
          DBInit.createTables();
        }


        else if (tablenumber == 4){
          ShowTables.printTables();
        }


        else if (tablenumber == 5){
          DBInit.dropTables();
        }

        else if (tablenumber == 6) {
          while (true) {
            System.out.println("Choose function:\n" +
                    "1. Enter data\n" +
                    "2. Show data\n" +
                    "3. Update hallsCount\n" +
                    "4. Update name\n" +
                    "5. Delete data\n" +
                    "6. Quit\n");

            int actionnumber = sc.nextInt();
            sc.nextLine();

            if (actionnumber == 1) {
              System.out.println("Enter name: ");
              String name = sc.nextLine();
              System.out.println("Enter hallsCount: ");
              int hallsCount = sc.nextInt();
              sc.nextLine();

              Cinema c = new Cinema(name, hallsCount);
              int newId = cinemaDao.insertCinema(c);
              System.out.println("Inserted cinema id = " + newId);

            } else if (actionnumber == 2) {
              System.out.println("All cinemas:");
              for (Cinema x : cinemaDao.getAllCinemas()) {
                System.out.println(x);
              }

            } else if (actionnumber == 3) {
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              System.out.println("Enter hallsCount: ");
              int hallscount = sc.nextInt();
              sc.nextLine();

              boolean upd = cinemaDao.updateCinemahallscount(id, hallscount);
              System.out.println("Updated? " + upd);

            } else if (actionnumber == 4) {
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();
              System.out.println("Enter name: ");
              String name = sc.nextLine();

              boolean upd = cinemaDao.updateCinemaName(id, name);
              System.out.println("Updated? " + upd);

            } else if (actionnumber == 5) {
              System.out.println("Enter id: ");
              int id = sc.nextInt();
              sc.nextLine();

              boolean del = cinemaDao.deleteCinema(id);
              System.out.println("Deleted? " + del);

            } else if (actionnumber == 6) {
              break;
            }
          }
        }



      }
    }


    catch (SQLException e) {
      e.printStackTrace();
    }


  }
}


