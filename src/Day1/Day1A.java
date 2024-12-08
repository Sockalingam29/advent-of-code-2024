package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1A {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code-2024\\src\\input\\Day1");
        Scanner text = new Scanner(file);
        int tot=0;
        List<Integer> l= new ArrayList<>();
        List<Integer> r= new ArrayList<>();
        while (text.hasNextLine()) {
            String data = text.nextLine();
            String[] temp = new String[2];
            temp = data.split("   ");
            l.add(Integer.parseInt(temp[0]));
            r.add(Integer.parseInt(temp[1]));
        }
        Collections.sort(l);
        Collections.sort(r);
        long sum=0;
        for (int i = 0; i < l.size(); i++) {
            sum+=Math.abs(l.get(i)-r.get(i));
        }
        System.out.println(sum);
    }
}
