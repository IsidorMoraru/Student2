package org.example;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentRepository {
    public List<Student> myListOfStudents = new ArrayList<>();

    public List<Student> myDeletedStudents = new ArrayList<>();


    public void addStudentToList(Student student) throws Exception {
        if (student.getDateOfBirth().year < 1900 && student.getDateOfBirth().year <= LocalDate.now().getYear())
            throw new Exception("Year is out of range");

        myListOfStudents.add(student);
    }

    ;

    public void deleteStudentsFromList(String id) throws Exception {
        if (id == null || id.length() != 13) throw new Exception("Student doesn't exist");
        for (Student student : myListOfStudents) {
            if (student.getId().equalsIgnoreCase(id)) {
                myListOfStudents.remove(student);
                myDeletedStudents.add(student);
                return;
            }

        }
        throw new Exception("id doesn't exist");

    }

    ;

    public void retriveStudents(int age) throws Exception {
        int index = 0;
        for (Student student : myDeletedStudents) {
            if (student.calculateAge() < 0) throw new Exception("Age in less than 0");
            if (student.calculateAge() == age) {
                myDeletedStudents.remove(student);
                myListOfStudents.add(student);
                index++;
            }
        }
        if (index == 0) {
            System.out.println("In list of deleted students doesn't exist someone with this age:");
        }

    }

    ;

    public void printMyStudentsByName() throws Exception {

        try {studentListSortator(myListOfStudents);
            studentListValidator(myListOfStudents);
            listPrinter(myListOfStudents);

        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage()
            );
        }

    }

    public void studentListValidator(List<Student> myListOfStudents) throws Exception {
        for (Student student : myListOfStudents) {
            if (student.getLastName().equals("") || student.getLastName() == null)
                throw new Exception("Last name cannot be empty");
        }
    }

    public void studentListSortator(List<Student> myListOfStudents) {
        myListOfStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }

    public void listPrinter(List<Student> myListOfStudents){
        for (Student student:myListOfStudents){
            System.out.println(student);
        }
    }


    public void printMyStudentsByBirthDate() throws Exception {
        myListOfStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getLastName().equals("") || o1.getLastName() == null || o2.getLastName().equals("") || o2.getLastName() == null)
                    try {
                        throw new Exception("One input is empty");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                return o2.calculateAge() - (o1.calculateAge());
            }

        });
        System.out.println("List of students ordered by date of birth: ");
        for (Student student : myListOfStudents) {
            System.out.println(student);

        }

    }


}
