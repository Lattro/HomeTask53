import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        //ЗАДАНИЕ 1
        System.out.println("ЗАДАНИЕ 1");

        ArrayList<HeavyBox> arrayList = new ArrayList<HeavyBox>();
        System.out.println("введите 5 весов");
        for (int i = 0; i < 5; i++)
        {
            arrayList.add(new HeavyBox(scanner.nextInt()));
        }
        System.out.println("вывод массива до удаления");
        for (HeavyBox i: arrayList)
        {
            System.out.println(i);
        }
        System.out.println("вывод массива после удаления последнего элемента 3 способами");
        arrayList.remove(arrayList.size()-1);
        for (HeavyBox i: arrayList)
        {
            System.out.println(i);
        }
        System.out.println(arrayList.toString());
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.print(arrayList.get(i)+",");
        }
        System.out.println();
        System.out.println("удаление всех элементов из массива");
        arrayList.removeAll(arrayList);
        System.out.println(arrayList.toString());


        // ЗАДАНИЕ 2
        System.out.println("ЗАДАНИЕ 2");
        System.out.println("Введите числа одной строкой в формате 1,2,3,4,4");
        String line = scanner.next();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.stream(line.split(",")).toList());
        System.out.println(hashSet.toString());


        // ЗАДАНИЕ 3
        System.out.println("ЗАДАНИЕ 3");
        System.out.println("введите 5 весов");
        for (int i = 0; i < 5; i++)
        {
            arrayList.add(new HeavyBox(scanner.nextInt()));
        }
        ArrayList<HeavyBox> listMore300 = new ArrayList<>();
        listMore300 = HeavyBox.checkWeight(arrayList);
        System.out.println(listMore300.toString()+" - Веса больше 300");
        arrayList.removeAll(listMore300);
        System.out.println(arrayList.toString()+" - Веса не более 300");

        //ЗАДАНИЕ 4
        System.out.println("ЗАДАНИЕ 4");
        ArrayList<Student> studentArrayList = new ArrayList<>();
        System.out.println("укажите количество студентов");
        int countStudents = scanner.nextInt();
        System.out.println("Заполните данные о студенте : ИМЯ КУРС ГРУППА");
        for (int i = 0; i < countStudents; i++)
        {
            studentArrayList.add(new Student( scanner.next(),scanner.nextInt(), scanner.next(), Student.fillListMarks(new ArrayList<Integer>())));
        }
        ArrayList<Student> arrayStudentsToDelete = new ArrayList<>();
        arrayStudentsToDelete = Student.getStudentsToDelete(studentArrayList);
        System.out.println("Всего студентов");
        Student.printStudents(studentArrayList);
        if(arrayStudentsToDelete.size()==0)
        {
            System.out.println("Двоешников нет");
            for (Student i: studentArrayList)
            {
                int course = i.getCourse();
                i.setCourse(course+=1);
            }
            Student.printStudents(studentArrayList);
        }
        else
        {
            System.out.println("Двоешники");
            Student.printStudents(arrayStudentsToDelete);
            studentArrayList.removeAll(arrayStudentsToDelete);
            if(studentArrayList.size()==0)
            {
                System.out.println("Всех отчислили");
            }
            else
            {
                for (Student i: studentArrayList)
                {
                    int course = i.getCourse();
                    i.setCourse(course+=1);
                }
                System.out.println("Студентов осталось после сессии");
                Student.printStudents(studentArrayList);
            }
        }
    }
}
