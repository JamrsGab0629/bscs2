import java.util.HashMap;
import java.util.Scanner;
class Student{
    int age;
    int grades;

    Student(int age,int grades){
        this.age = age;
        this.grades = grades;
    }
}
public class crud {
    public static void main(String[] args){
        HashMap <String,Student> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
String user;
do{
    menu();
    System.out.println("Enter what you want");
    user = scan.nextLine();

    if(user.equals("1")){
        Addstuds(map,scan);
    }
    else if(user.equals("2")){
        viewstudentgrade(map, scan);
    }
    else if(user.equals("3")){
        remove(map, scan);
    }
    else if(user.equals("4")){
        viewstudents(map);
    }
    else if(user.equals("5"))
    {
        updateStudent(map, scan);
    }

}while(!user.equals("6"));


    }
    public static void menu(){
        System.out.println("1. Add Students ");
        System.out.println("2. View student grade");
        System.out.println("3. Remove Student");
        System.out.println("4. Show all Students");
        System.out.println("5. Update Student");
        System.out.println("6. Exit");
    }
    public static void Addstuds(HashMap<String,Student> map,Scanner scan){
        
        
        System.out.println("Enter your name");
        String name = scan.nextLine();
        System.out.println("Enter your Grades");
        int grades = scan.nextInt();

        System.out.println("Enter your age");
        int age = scan.nextInt();
      

        scan.nextLine();
if(map.containsKey(name)){
    System.out.println("Student already exists!");
} else {
    map.put(name, new Student(age,grades));
    System.out.println("Student added!");
}
       

    }
    public static void viewstudentgrade(HashMap<String,Student> map,Scanner scan){
        if(map.isEmpty()){
            System.out.println("map is empty");
            return;
        }
        System.out.println("Enter the students name");
        String name = scan.nextLine();
        Student s = map.get(name);

        if(s != null){
            System.out.println("Age " + s.age+ " Grade" + s.grades);
        }
        else{
            System.out.println("Student does not exist");
        }

      

      

    }
    public static void viewstudents(HashMap<String,Student> map){
        if(map.isEmpty()){
            System.out.println("Map is empty");
            return;
        }
       
        for(HashMap.Entry<String,Student> entry : map.entrySet()){
              Student s = entry.getValue();
            System.out.println("Name " + entry.getKey() + ": Grades" + s.grades + "age: " + s.age);
        
        }
      

    }
    public static void remove(HashMap<String,Student> map,Scanner scan){
        if(map.isEmpty()){
            System.out.println("Map is empty");
            return;
        }
        System.out.println("Enter the name that you want to delete: ");
        String name = scan.nextLine();

      
        if(map.containsKey(name)){
            map.remove(name);
            System.out.println("Student has been remove");

        }
        else{
            System.out.println("Student does not exist");
        }
    }
    public static void search(HashMap<String,Student> map,Scanner scan){
        if(map.isEmpty()){
            System.out.println("map is empty");
          return;  
        }
        System.out.println("Type the student you want to search");
        String name = scan.nextLine();

    
    }
    public static void updateStudent(HashMap<String,Student> map, Scanner scan){
    if(map.isEmpty()){
        System.out.println("Map is empty");
        return;
    }

    System.out.println("Enter student name to update:");
    String name = scan.nextLine();

    if(map.containsKey(name)){
        Student s = map.get(name);

        System.out.println("Enter new grade:");
        s.grades = scan.nextInt();

        System.out.println("Enter new age:");
        s.age = scan.nextInt();
        scan.nextLine();

        System.out.println("Student updated!");
    } else {
        System.out.println("Student not found.");
    }
}
    
}
