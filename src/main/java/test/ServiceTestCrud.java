package test;

import Domain.Address;
import Domain.Student;
import Domain.Teacher;
import Service.Services;
import com.github.javafaker.Faker;

import java.util.List;

public class ServiceTestCrud {
    public static <E> void print(E e) {
        System.out.println(e);
    }

    public static Faker faker = new Faker();

    public static Student fakeStudent() {
        return PopulateFakeTest.fakeStudent(faker);
    }

    public static Teacher fakeTeacher() {
        return PopulateFakeTest.getFakeTeacher(faker);
    }

    public static Address fakeAddress() {
        return PopulateFakeTest.getFakeAddress(faker);
    }

    public static Student save(Student student) {
        return Services.student.create(student);
    }

    public static Teacher save(Teacher teacher) {
        return Services.teacher.create(teacher);
    }

    public static Address save(Address address) {
        return Services.address.create(address);
    }

    public static void main(String[] args) {

        Teacher teacher = fakeTeacher();
        Student student = fakeStudent();
        Address addressS = fakeAddress();
        Address addressT = fakeAddress();

        teacher.setAddress(addressT);
        teacher.setStudents(List.of(student));
        addressS.setStudent(student);

        save(teacher);
        save(addressS);

        print("all students ");
        for (Student student1 : Services.student.readAll()) {
            print(student1);
            Services.student.delete(student1);
        }

        print("all teachers");
        for (Teacher teacher1 : Services.teacher.readAll()) {
            print(teacher1);
            Services.teacher.delete(teacher1);
        }
        print("all Addresses");
        for (Address address : Services.address.readAll()) {
            print(address);
            Services.address.delete(address);
        }


        Services.finish();
    }
}
