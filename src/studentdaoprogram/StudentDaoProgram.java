package studentdaoprogram;

import DaoImpl.StudentDaoImpl;
import interfaceDao.StudentDao;
import java.util.List;
import java.util.Scanner;
import model.Student;

public class StudentDaoProgram {

    public static void main(String[] args) {

        StudentDao sDao = new StudentDaoImpl();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("Main Menu:\n1. Create\n2. Update\n3. Delete\n4. Find By ID\n5. Find All\n6. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("\n==== CREATE ====");
                    System.out.print("\nEnter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter First Name: ");
                    String firstName = sc.next();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.next();
                    Student s = new Student(id, firstName, lastName);
                    sDao.create(s);
                    System.out.println("The student has been successfully added.\n");
                }
                case 2 -> {
                    System.out.print("\n==== UPDATE ====");
                    System.out.print("\nEnter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New First Name: ");
                    String firstName = sc.next();
                    System.out.print("Enter New Last Name: ");
                    String lastName = sc.next();
                    Student s = new Student();
                    s.setId(id);
                    s.setFirstname(firstName);
                    s.setLastname(lastName);
                    sDao.update(s);
                    System.out.println("The student has been successfully updated.\n");
                }
                case 3 -> {
                    System.out.print("\n==== DELETE ====");
                    System.out.print("\nEnter ID: ");
                    int id = sc.nextInt();
                    sDao.delete(id);
                    System.out.println("The student has been successfully deleted.\n");
                }

                case 4 -> {
                    System.out.print("\n==== FIND BY ID ====");
                    System.out.print("\nEnter ID: ");
                    int id = sc.nextInt();
                    Student s = sDao.findById(id);
                    System.out.println(s + "\n");
                }
                case 5 -> {
                    List<Student> sList = sDao.findAll();
                    for (Student s : sList) {
                        System.out.println(s);
                    }
                    System.out.println();
                }
                case 6 ->
                    System.out.println("Program ended.");
                default ->
                    System.out.println("Invalid Option. Please select 1, 2, 3, 4, 5 or 6.\n");
            }

        } while (choice != 6);

    }

}
