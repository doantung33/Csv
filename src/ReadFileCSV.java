import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    private static final  String comma = ",";
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            String line ;
            bufferedReader = new BufferedReader(new FileReader("studentfile.csv"));
            while ((line= bufferedReader.readLine())!=null){
                printStudent(parseCSV(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader!= null)
                    bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCSV (String csvLine){
        List<String> result = new ArrayList<>();
        if (csvLine!= null){
            String[]arr = csvLine.split(comma);
            for (int i = 0; i < arr.length; i++) {
                result.add(arr[i]);

            }
        }
        return result;
    }
    private static void printStudent (List<String>student){
        System.out.println(student.toString());
    }
}
