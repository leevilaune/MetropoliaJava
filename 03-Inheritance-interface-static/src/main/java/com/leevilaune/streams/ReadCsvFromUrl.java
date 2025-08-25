package com.leevilaune.streams;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCsvFromUrl {

    private Scanner r;

    public ReadCsvFromUrl(String url) throws IOException {
        this.r = new Scanner(new URL(url).openStream());
    }

    public ArrayList<String> readFile(){
        ArrayList<String> lines = new ArrayList<>();
        while(this.r.hasNext()){
            lines.add(r.nextLine());
        }
        return lines;
    }
    public double averageForDate(String targetDate, String targetField){
        ArrayList<String> lines = readFile();
        String[] fields = lines.get(0).split(";");
        int fieldIndex = findFieldIndex(targetField,fields);
        double sum = 0;
        int size = 0;
        for(String s : lines){
            String[] parts = s.split(";");
            String date = parts[0].split(" ")[0];
            if(date.equalsIgnoreCase(targetDate)){
                size++;
                sum += Double.parseDouble(parts[fieldIndex].replace(",","."));
            }
        }
        return sum/size;
    }
    public int findFieldIndex(String field, String[] fields){
        int i = 0;
        for(String s : fields){
            if(s.equalsIgnoreCase(field)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args){
        ReadCsvFromUrl reader = null;
        try {
            reader = new ReadCsvFromUrl("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String targetDate = "01.01.2023";
        String targetField = "UlkoTalo";
        double avg = reader.averageForDate(targetDate,targetField);
        System.out.printf("Average during %s for %s is %.3f",targetDate,targetField,avg);
    }
}
