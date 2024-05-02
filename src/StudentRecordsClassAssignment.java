import java.util.Scanner;
//Creating the student class
class Student {
    private String name;
    private int id;
    private int age;
    private double grade;
    //Creating variables for the user to input
    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }


    public int getAge() {
        return age;
    }


    public double getGrade() {
        return grade;
    }
    //This will change the variables to the new and updated info
    public void updateInfo(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    //Printing the information back to the user
    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}


/*This class dictates that there will be 100 students maximum and adds the information to be stored in memory*/
class StudentManagement {
    private static int totalStudents = 0;
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    /*if else statement to print different dialogue for the user if the student is or isn’t added*/
    public static void addStudent(String name, int id, int age, double grade) {
        if (totalStudents < MAX_STUDENTS) {
            students[totalStudents++] = new Student(name, id, age, grade);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Cannot add more students. Maximum limit reached.");
        }
    }
    //Class to update the student info
    public static void updateStudent(int id, String name, int age, double grade) {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                students[i].updateInfo(name, age, grade);
                System.out.println("Student information updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }
    //Print student details by the student ID to the user
    public static void viewStudentDetails(int id) {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }
}
//Main class and method for scanner and  prompt dialogue
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    StudentManagement.addStudent(name, id, age, grade);
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    System.out.print("Enter student ID to view details: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudentDetails(viewId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
