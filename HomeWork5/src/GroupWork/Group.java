package GroupWork;

import GroupWork.AddExeption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Group  implements Voenkom {
    private static final int N = 10;
    private Student[] group;
    private int k;

    public Group(){
        this.group = new Student[N];
        this.k = 0;
    }

    public void add(Student student){
        try {
            if (student != null){
                if(k == 10){
                    throw new AddExeption();
                }
                group[k] = student;
                k++;
            }
            else {
                throw new NullPointerException();
            }

        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        catch (AddExeption my){
            System.out.println(my.getMessage());
        }

    }

    public void add(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input Name, Surname, age, male, avg");
            String name = in.next();
            String surname = in.next();
            int age = in.nextInt();
            String male = in.next();
            int avg = in.nextInt();
            if((age < 0) || (age > 100) || ( avg < 60) || (avg > 100) || (male.equalsIgnoreCase("F"))
                    ||male.equalsIgnoreCase("M")){
                throw new NotCorectInputExeption();
            }
            group[k] = new Student(name, surname, age, male, avg);
            k++;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        } catch (NotCorectInputExeption ex1) {
            System.out.println(ex1.getMessage());
        }
    }

    public void remove(int i){
        try {
            if (group[i] != null) {
                group[i] = null;
                for (int j = i; j < k-1; j++) {
                    group[i] = group[i+1];
                }
                k--;
            }
            else {
                throw new NullPointerException();
            }
        }
        catch (NullPointerException e){
            System.out.println("Yoiu cant delete student if it not exist");
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Not right index, try next time");
        }
    }

    public List<Integer> getStudentIndex(String surname){
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < k ; i++) {
            if (group[i].getSurname().equalsIgnoreCase(surname)){
                indexes.add(i);
            }
        }
        return indexes;
    }

    public  void sortBySurname(){
        Scanner in = new Scanner(System.in);
        System.out.println("Normal -1 Revers - 2");
        if (in.next().trim().equalsIgnoreCase("1")) {
            Arrays.sort(group, Comparator.comparing(Student::getSurname));
        } else if (in.next().trim().equalsIgnoreCase("2")) {
            Arrays.sort(group, Comparator.comparing(Student::getSurname).reversed());
        } else System.out.println("I cant sort");

    }

    public  void sortBySurnameAndAvg(){
        Scanner in = new Scanner(System.in);
        System.out.println("Normal -1 Revers - 2");
        if (in.next().trim().equalsIgnoreCase("1")) {
            Arrays.sort(group, Comparator.comparingInt(Student::getAverage).thenComparing(Student::getSurname));
        } else if (in.next().trim().equalsIgnoreCase("2")) {
            Arrays.sort(group, Comparator.comparingInt(Student::getAverage).thenComparing(Student::getSurname).reversed());
        } else System.out.println("I cant sort");
    }

    public  void sortByName(){
        Scanner in = new Scanner(System.in);
        System.out.println("Normal -1 Revers - 2");
        if (in.next().trim().equals("1")) {
            Arrays.sort(group, Comparator.comparing(Student::getName));
        } else if (in.next().trim().equals("2")) {
            Arrays.sort(group, Comparator.comparing(Student::getName).reversed());
        } else System.out.println("I cant sort");
    }

    public void sortByParametr() {
        Scanner in = new Scanner(System.in);
            System.out.println("If You want to sort by : 1.Surname, 2.Surname, Average, 3.Name");
            if (in.next().trim().equals("1")) {
                this.sortBySurname();
            } else if (in.next().trim().equals("2")) {
                this.sortBySurnameAndAvg();
            } else if (in.next().trim().equals("3")) {
                this.sortByName();
            } else System.out.println("I cant sort");
    }


    public Student[] areReadyToArmy() {
        Student[] temp = new Student[k];
        int count = 0;
        for (int i = 0; i < k ; i++) {
            if (group[i] != null) {
                if ((group[i].getAge() >= 18) && (group[i].getMale().equalsIgnoreCase("M"))) {
                    temp[count] = group[i];
                    count++;
                }
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public Student getStudent(int i){
        try {
            if((i < 0) || (i > k)){
                throw new ArrayIndexOutOfBoundsException("Not Korrect indexation, you get null");
            }
            else {
                return group[i];
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        String result = "The group \n";
        for (int i = 0; i < k; i++) {
            if (group[i] != null) {
                result += (group[i].toString());
            }
        }
        return result;
    }

    public void writeToFile(String pathResult){
        try(FileWriter out = new FileWriter(pathResult)) {
            for (Student item: group ) {
                out.write(item.getName() +" " + item.getSurname() +" "  + item.getAge() +" "
                        + item.getMale() +" " + item.getAverage() + "\n");
                out.flush();
            }

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Group reagFromFile(String inputPath, Group result){
        try(Scanner in = new Scanner(new FileInputStream(inputPath))) {
            while (in.hasNext()){
                try {
                    String name = in.next();
                    String surname = in.next();
                    int age = in.nextInt();
                    String male = in.next();
                    int avg = in.nextInt();
                    if((age < 0) || (age > 100) || ( avg < 60) || (avg > 100) /*|| (male.equalsIgnoreCase("m"))
                            ||(male.trim().equalsIgnoreCase("f"))*/){
                        throw new NotCorectInputExeption();
                    }
                    result.add(new Student(name, surname, age, male, avg));

                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                    System.out.println("ArrayIndexOutOfBoundsException");
                }
                catch (NumberFormatException ex){
                    System.out.println(ex.getMessage());
                    return null;
                } catch (NotCorectInputExeption ex1) {
                    System.out.println(ex1.getMessage());
                    return null;
                }

            }
            return result;
        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }


}
