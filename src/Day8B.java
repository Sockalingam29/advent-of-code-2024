import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Day8B {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code-2024\\src\\input\\Day8");
        Scanner text = new Scanner(file);
        long totsum = 0;

        List<List<String>> ls = new ArrayList<>();
        while(text.hasNextLine()) {
            String input = text.nextLine();
//            ls.add(new ArrayList<String>());
            ls.add(Arrays.asList(input.split("")));
        }
        boolean[][] res = new boolean[ls.size()][ls.get(0).size()];
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                if(ls.get(i).get(j).equals("."))
                    continue;
                for (int k = i; k < ls.size(); k++) {
                    for (int l = 0; l < ls.get(k).size(); l++) {
                        if(k==i && l==j) continue;
                        if(!ls.get(i).get(j).equals(ls.get(k).get(l))) continue;
                        int a=i,b=j,c=k,d=l;
//                        while(a >= 0 && b < ls.get(0).size() && b >= 0 && a < ls.get(0).size()){
                        while(true){
                            a= a - k + i;
                            if (j > l) {
                                b = b + j - l;
                            } else {
                                b = b - l + j;
                            }
                            if (a >= 0 && b <= ls.get(0).size() && b >= 0 && a <= ls.get(0).size())
                                res[a][b] = true;
                            else break;

                        }
//                        while(c >= 0 && d < ls.get(0).size() && d >= 0 && c < ls.get(0).size()){
                        while(true){
                            c = c + k - i;
                            if (j > l) {
                                d = d - j + l;
                            } else {
                                d = d + l - j;
                            }
                            if (c >= 0 && d <= ls.get(0).size() && d >= 0 && c <= ls.get(0).size())
                                res[c][d] = true;
                            else break;
                        }
                    }
                }
            }
        }
        int c=0;
        for(int i=0;i<res.length;i++) {
            System.out.println(Arrays.toString(res[i]));
            for (int j = 0; j < res[i].length; j++) {
                if (res[i][j] == true) c++;
            }
        }
        System.out.println(c);
    }
}
