package test;

import Domain.Address;
import Domain.Student;
import Domain.Teacher;
import Repository.AddressRepo;
import Repository.StudentRepo;
import Repository.TeacherRepo;
import com.github.javafaker.Faker;
import org.hibernate.type.LocalDateType;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class PopulateFakeTest {
    public static void main(String[] args) {
        AddressRepo addressRepo = new AddressRepo();
        Faker faker = new Faker();
        //        create 50 students
        Teacher fakeTeacher1 = getFakeTeacher(faker);
        Teacher fakeTeacher2 = getFakeTeacher(faker);

        TeacherRepo teacherRepo = new TeacherRepo();
        Teacher t1 = teacherRepo.create(fakeTeacher1).get();
        Teacher teacher1 = teacherRepo.simpleFindById(t1.getTeacherId());
        Teacher t2 = teacherRepo.create(fakeTeacher2).get();
        Teacher teacher2 = teacherRepo.simpleFindById(t2.getTeacherId());

        IntStream.range(0, 50).forEach(
                i -> {

                    Student student =
                    fakeStudent(faker);
                    StudentRepo studentRepo = new StudentRepo();
                    Optional<Student> student1 = studentRepo.create(student);
                    teacherRepo.getTransaction().begin();
                    t1.setStudents(List.of(student1.get()));
                    t2.setStudents(List.of(student1.get()));
                    teacherRepo.getTransaction().commit();
                    Address address1 = new Address(
                            faker.number().numberBetween(1111, 9999),
                            faker.address().state(),
                            faker.address().city(),
                            faker.address().fullAddress(),
                            getAddressPostalCode(faker),
                            student
                    );
                    addressRepo.create(address1);
                }
        );
    }

    public static Student fakeStudent(Faker faker) {
       return new Student(
        faker.name().lastName(),
        faker.name().firstName(),
        faker.number().numberBetween(300000, 99999999),
        getBirthday(faker)
);
    }

    public static Teacher getFakeTeacher(Faker faker) {
        return new Teacher(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(300000, 9999999),
                10000.0,
                getBirthday(faker),
                getFakeAddress(faker)
        );
    }

    public static Address getFakeAddress(Faker faker) {
        return new Address(
                faker.number().numberBetween(1111, 9999),
                faker.address().state(),
                faker.address().city(),
                faker.address().fullAddress(),
                getAddressPostalCode(faker)
        );
    }

    public static int getAddressPostalCode(Faker faker) {
        return Integer.parseInt(faker.address().zipCode().replaceAll("-", ""));
    }

    public static Date getBirthday(Faker faker) {
        return new Date(faker.date().birthday().getTime());
    }
}
