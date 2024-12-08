package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7A {
    static boolean helper(long sum, long exp, List<Integer> arr){
        if(sum>exp) return false;
        if(sum==exp && arr.size()==0) return true;
        if(arr.size()==0) return false;

        boolean addFlag = helper(sum+arr.get(0),exp,arr.subList(1,arr.size())); // 121 150
        if(addFlag) return true;
        boolean mulFlag = helper(sum*arr.get(0),exp,arr.subList(1,arr.size()));
        return mulFlag;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code-2024\\src\\input\\Day7");
        Scanner text = new Scanner(file);
        long totsum = 0;
        while(text.hasNextLine()){
            String input = text.nextLine();
            String[] parts = input.split(":");
            long exp = Long.parseLong(parts[0].trim());

            ArrayList<Integer> numbers = new ArrayList<>();
            String[] numberStrings = parts[1].trim().split(" ");
            for (String numStr : numberStrings) {
                numbers.add(Integer.parseInt(numStr));
            }

            boolean res = helper(numbers.get(0), exp, numbers.subList(1, numbers.size()));
            if(res) totsum+=exp;
        }
        System.out.println(totsum);

    }
}
