import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1B {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code-2024\\src\\input\\Day1");
        Scanner text = new Scanner(file);
        int tot=0;
        List<Integer> l= new ArrayList<>();
//        List<Integer> r= new ArrayList<>();
        Map<Integer,Integer> rfreq = new HashMap<>();
        while (text.hasNextLine()) {
            String data = text.nextLine();
            String[] temp = new String[2];
            temp = data.split("   ");
            l.add(Integer.parseInt(temp[0]));
            int r = Integer.parseInt(temp[1]);
            rfreq.put(r,rfreq.getOrDefault(r,0)+1);
        }
//        Collections.sort(l);
//        Collections.sort(r);
        long sum=0;
        for (int i = 0; i < l.size(); i++) {
            if(rfreq.get(l.get(i))!=null)
            sum+=((long) l.get(i) *rfreq.get(l.get(i)));
        }
        System.out.println(sum);
    }
}
