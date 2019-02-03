package us.mattgreen;

import java.util.Scanner;

public class Main {

    private final static FileInput movieThing = new FileInput("movieRating.csv");


    public static void main(String[] args) {
        String line;
        String[] fields;
        String[] movies = new String[100];
        int[] movieCount = new int[100];
        int[] ratingCount = new int[100];

        String oldMealType="NA";
        System.out.format("%-15s  %-15s\n","Meal Type", "Average Calories");
        System.out.format("%-15s  %-15s\n","==============", "===============");
        while ((line = movieThing.fileReadLine()) != null) {
            fields = line.split(",");
            String movieName = fields[0];
            int movieRating = Integer.parseInt(fields[1]);
            for(int i= 0; i<movies.length; i++){
                if(movies[i] == null){
                    movies[i] = movieName;
                    ratingCount[i] = movieRating;
                    movieCount[i] = 1;
                    i= movies.length;
                  //  System.out.println(movies[0] + "---" + movieName);
                  //  System.out.println("HIT THE NULL STATEMENT" + movieName + "zzz");
                }else if(movies[i].equals(movieName)){
                    //System.out.println("HITTTTTT");
                    movieCount[i]++;
                    ratingCount[i]+= movieRating;
                    i= movies.length;
                }
            }
            //System.out.println(movies[1] + "---"+ movies[2] + "---"+ movies[3]);


            //System.out.println("--------"+ fields[1]);
          //  if (!oldMealType.equals(fields[0])) {
          //      if (!oldMealType.equals("NA")) {

                  //  System.out.format("%-20s %4.2f\n",oldMealType, average);
          //      }
          //      oldMealType=fields[0];
          //  }

        }
        for(int i = 0; i<movies.length; i++){
            if(movies[i] == null){
                i = movies.length;
            }else{
                System.out.println("Movie: " + movies[i]+ " Total Views: " + movieCount[i] + " Average Rating: "+ ratingCount[i]/movieCount[i]);
            }
        }

       // System.out.format("%-15s  %-15s\n","==============", "===============");
       // System.out.format("%-20s %4.2f\n","Grand Total", totalAverage);
    }
}