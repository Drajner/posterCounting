package rekrutacjaAtinea;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import javafx.util.Pair;
import java.io.File;


public class Main {

    public static Scanner getFileScanner(String path){
        File inputFile = new File(path);
        try(Scanner inputScanner = new Scanner(inputFile)){
            return inputScanner;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Scanner(System.in);
    }

    public static Pair<Integer, ArrayList<Integer>>  readInput(Scanner inputScanner){
        int buildingNumber = inputScanner.nextInt();
        ArrayList<Integer> buildingsSize = new ArrayList<Integer>();
        while(inputScanner.hasNext()){
            buildingsSize.add(inputScanner.nextInt());
        }

        return new Pair<Integer, ArrayList<Integer>>(buildingNumber, buildingsSize);
    }

    public static Integer coverAlgorithm(Pair<Integer, ArrayList<Integer>> buildingsData){
        int posters = 0;
        Stack<Integer> posterStack = new Stack<Integer>();
        for(int i = 0; i < buildingsData.getKey(); i++){
            while(!posterStack.empty() && posterStack.peek() > buildingsData.getValue().get(2 * i + 1)){
                posterStack.pop();
            }
            if(posterStack.empty() || posterStack.peek() < buildingsData.getValue().get(2 * i + 1)){
                posterStack.push(buildingsData.getValue().get(2 * i + 1));
                posters += 1;
            }
        }
        return posters;
    }

    public static void main(String[] args) {
        System.out.println(coverAlgorithm(readInput(getFileScanner("C:\\Users\\Badi\\Desktop\\etap1\\pla\\in\\pla0.in"))));
    }
}
