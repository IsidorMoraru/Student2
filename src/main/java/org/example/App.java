package org.example;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        Student s1 = new Student("vas", "ile", new DateOfBirth(2005, 04, 01), Gender.MALE, "1990105044429");
        Student s2 = new Student("jvas", "ie", new DateOfBirth(2015, 01, 01), Gender.MALE, "1990102044429");
        Student s3 = new Student("vkas", "il", new DateOfBirth(2002, 02, 01), Gender.FEMALE, "1490105044429");


        StudentRepository studentRepository = new StudentRepository();

        studentRepository.addStudentToList(s1);
        studentRepository.addStudentToList(s2);
        studentRepository.addStudentToList(s3);

        s3.calculateAge();
        System.out.println(s3.calculateAge());


        studentRepository.deleteStudentsFromList("1490105044429");

        studentRepository.retriveStudents(21);


    }


}
