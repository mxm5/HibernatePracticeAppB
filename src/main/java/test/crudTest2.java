package test;

import Domain.Address;
import Domain.Student;
import Domain.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

public class crudTest2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(
                        "Hibernate_practice_app"
                );
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
//        test2();

//        Teacher teacher9 = entityManager.find(Teacher.class, 9);
//        Address address = teacher9.getAddress();
//        Address address8 = new Address(
//                324, "teh", "tehran", "st1 num2", 51531
//
//        );

        Student student10 = entityManager.find(Student.class,10);
        Address address12 = entityManager.find(Address.class,12);
        student10.setAddresses(List.of(address12));

        System.out.println();

        entityManager.getTransaction().begin();
//        entityManager.merge(student10);
        entityManager.getTransaction().commit();
    }

    private static void test2() {
        //        test1(entityManager);
        Student student = new Student(
                "tttt",
                "ttttt",
                33434,
                Date.valueOf("2011-11-11")
        );
    }

    private static void test1(EntityManager entityManager) {
        Student student = entityManager.find(Student.class, 4);
        Teacher teacher = entityManager.find(Teacher.class, 15);
        entityManager.getTransaction().begin();
        student.setTeachers(List.of(teacher));
        entityManager.getTransaction().commit();
        System.out.println(student.getTeachers());
    }

}
