
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterFileCsv {
    private static final String comma =",";

    public static void main(String[] args) {
        String fileName = "studentfile.csv";
        writerFile(fileName);

    }
    public static void writerFile (String fileName) {
        Student student = new Student("tungg", 18, "HD");
        Student student1 = new Student("met", 19, "HD");
        Student student2 = new Student("moi", 20, "HD");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);

        FileWriter fileWriter = null;

        try {
            fileWriter= new FileWriter(fileName);
            for ( Student student3 : students){
                fileWriter.append(student3.getName());
                fileWriter.append(comma);
                fileWriter.append(String.valueOf(student3.getAge()));
                fileWriter.append(comma);
                fileWriter.append(student3.getAddress()+"\n");
            }
            System.out.println("Đã tạo xong file CSV");
        } catch (IOException e) {
            System.out.println("Chưa tạo được file CSV");
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            }catch (IOException e){
                System.out.println("ERROR");
                e.printStackTrace();
            }
        }

    }

}
