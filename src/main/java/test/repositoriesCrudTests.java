package test;

import Domain.Student;
import Repository.StudentRepo;

import java.sql.Date;
import java.util.Optional;

public class repositoriesCrudTests {
    public static void main(String[] args) {
        StudentRepo studentRepo = new StudentRepo();

        res("create entity");
        Optional<Student> entity = studentRepo.create(
                new Student(
                        "sssss",
                        "ssssssss",
                        33434,
                        Date.valueOf("2011-11-11")
                )
        );

//        studentRepo.deleteEntity();

        System.out.println(entity);
        res("test read all ");
        studentRepo.simpleFindAll().forEach(System.out::println);
        studentRepo.closeEntityManager();
    }

    private static void res(String name) {
        System.out.println("================================");
        System.out.println(name+" working");
    }
}
