/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student.management;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    private String name;
    private int id;
    private String course;
    
    public Student(String name, int id, String course){
        this.name = name;
        this.id = id;
        this.course = course;
    }
    
    public int getId(){
        return id;
    }
    
    public String toString(){
        return "ID: "+id+", Name: "+name+", Course: "+course;
    }
}

public class StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        while(true){
            System.out.println("Student management system");
            System.out.println("1. Add Student\n2. View all students\n3. Search student by ID\n4. Delete student\n5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            
            switch (choice){
                case 1:
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student course: ");
                    String course = sc.nextLine();
                    
                    students.add(new Student(name,id,course));
                    System.out.println("Student added");
                    break;
                    
                case 2:
                    if (students.isEmpty()){
                        System.out.println("No student to display");
                    } else{
                        for (Student s : students){
                            System.out.println(s);
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    
                    for (Student s : students){
                        if (s.getId() == searchId){
                            System.out.println("Found"+s);
                            found = true;
                            break;
                        }
                    }
                    if (!found)System.out.println("Student not found");
                    break;
                
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deletedId = sc.nextInt();
                    boolean removed = students.removeIf(s -> s.getId() == deletedId);
                    if (removed) System.out.println("Student deleted");
                    else System.out.println("Student not found");
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid option");
            }
        }
        
    }
}
