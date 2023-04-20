import java.util.ArrayList;
import java.util.Random;

public class Student
{
    private int course;
    private String name;
    private String group;
    private ArrayList<Integer> listMarks = new ArrayList<>();
    public Student ( String name,int course, String group, ArrayList<Integer> listMarks)
    {
        this.name = name;
        this.course = course;
        this.group = group;
        this.listMarks = listMarks;
    }
    public String getName()
    {
        return name;
    }
    public String getGroup()
    {
        return group;
    }
    public ArrayList<Integer> getListMarks()
    {
        return listMarks;
    }

    public static ArrayList<Integer> fillListMarks(ArrayList<Integer> listMarks) {
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            listMarks.add(random.nextInt(10)+1);
        }
        return listMarks;
    }

    public int getCourse()
    {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public static Double getAverageMark(ArrayList<Integer> listMarks)
    {
            double sumMarks = 0;
            double average;
            for (int j = 0; j < listMarks.size(); j++) {
                sumMarks += listMarks.get(j);
            }
            average = sumMarks / listMarks.size();
            return average;
    }
    public static ArrayList<Student> getStudentsToDelete(ArrayList<Student> list)
    {
        ArrayList<Student> studentsToDelete = new ArrayList<>();
        for (Student i: list)
        {
            double sumMarks=0;
            double average;
            for (int j = 0; j < i.listMarks.size(); j++)
            {
                sumMarks+=i.listMarks.get(j);
            }
            average = sumMarks/i.listMarks.size();
            if(average<3)
            {
                studentsToDelete.add(i);
            }
        }
        return studentsToDelete;
    }
    public static void printStudents(ArrayList<Student> studentArrayList)
    {
        for (Student i: studentArrayList)
        {
            System.out.print(i.getName().toString()+" ");
            System.out.print(Integer.toString(i.getCourse())+" ");
            System.out.print(i.getGroup().toString()+" ");
            System.out.print(i.getListMarks().toString()+" ");
            System.out.println("Средний балл - "+Student.getAverageMark(i.getListMarks()));
            System.out.println();
        }
    }
}
