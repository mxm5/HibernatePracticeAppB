package test;

import Domain.Address;
import Domain.Student;
import Domain.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class CrudTests {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(
                        "Hibernate_practice_app"
                );
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        // create an address
//        Address teacherAddress = new Address(
//                234
//                , "qz"
//                , "qazvin"
//                , "qaz st 1 num 2",
//                346541566
//
//        );
//        Date now = Date.valueOf(LocalDate.now());
//        // create a teacher1
//        Teacher teacher1 = new Teacher(
//                "hasan",
//                "alavi",
//                23344,
//                1531531.513,
//                now,
//                teacherAddress
//        );
//        // create 2 students
//        Student student1 = new Student(
//                "mohammad",
//                "hasani",
//                324324,
//                now,
//                List.of(teacher1)
//
//        );
//        Student student = new Student(
//                "karim",
//                "amir",
//                32432462,
//                now,
//                List.of(teacher1)
//
//        );

        Address address2 = new Address(
                434434,
                "9999999",
                "tehran",
                "nom 1 building 1",
                543545);

        Teacher teacher2 = new Teacher(
                "555555",
                "hamidi",
                151351,
                353324.35453,
                Date.valueOf("2010-10-10")
//                address2
//                now,
//                address2,
//                List.of(student1, student)
        );

//        address2.setTeacher(teacher2);
//        teacher2.setAddress(address2);
//        address2.setTeacher(teacher2);
//        student.setAddresses(
//                List.of(
//                        new Address(
//                                343, "qq", "qqq", "dfsfdsfd", 34324
//                        )
//                )
//        );
//        Student student2 = entityManager.find(Student.class, 6);

        Student student = new Student("hasan", "emir", 3434, Date.valueOf("1999-10-10"));
        address2.setStudent(student);
        teacher2.setStudents(List.of(student));
        transaction.begin();

        entityManager.persist(address2);
        entityManager.persist(teacher2);
//        entityManager.persist(address2);
//        Collection<Address> addresses = student2.getAddresses();
//        Address address = new Address(
//                2334,
//                "km",
//                "kerman",
//                "no 2 st 1 p 14",
//                43434,
//                student2
//        );
//        student2.setAddresses(List.of(address));
//        entityManager.persist(address);
//        Collection<Address> addresses = student2.getAddresses();
//        System.out.println(addresses);

        transaction.commit();
//        Address address = entityManager.find(Address.class, 5);
//        System.out.println(address.getTeacher().getTeacherFirstName());

        entityManager.close();
        entityManagerFactory.close();
    }

}
