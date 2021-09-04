package test;

import Domain.Address;
import Domain.Student;
import Domain.Teacher;
import Service.AddressService;
import Service.StudentService;
import Service.TeacherService;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.stream.IntStream;

public class serviceTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Teacher fakeTeacher = PopulateFakeTest.getFakeTeacher(faker);
        Teacher fakeTeacher2 = PopulateFakeTest.getFakeTeacher(faker);
        StudentService studentService = new StudentService();
        AddressService addressService = new AddressService();
        TeacherService teacherService = new TeacherService();

        //SAVE ONE TEACHER
        Teacher teacher = teacherService.create(fakeTeacher);
        Teacher teacher2 = teacherService.create(fakeTeacher2);
        IntStream.range(1, 11).forEach(
                (i) -> {
                    System.out.println("=========================");
                    System.out.println(i);
                    //CREATE A FAKE STUDENT
                    Student student = PopulateFakeTest.fakeStudent(faker);
                    //CREATE A FAKE ADDRESS FOR STUDENT
                    Address fakeAddress = PopulateFakeTest.getFakeAddress(faker);
                    fakeAddress.setStudent(student);
                    addressService.create(fakeAddress);
                    //FIND STUDENT AND UPDATE IT WITH TEACHER
//            Integer entityID = studentService.getEntityID(student);
//            studentService.;
//                            Integer entityId = StudentService.getStudentRepo().getEntityId(student);
                    Student student1 = studentService.getEntity(student);
                    teacher.setStudents(List.of(student1));
                    teacherService.update(teacher);
                    teacher2.setStudents(List.of(student1));
                    teacherService.update(teacher2);
//                    student1.setTeachers(List.of(teacher));
//                    studentService.update(student1);
                }
        );
        StudentService.getStudentRepo().closeEntityManager();
        TeacherService.getTeacherRepo().closeEntityManager();
        AddressService.getAddressRepo().closeEntityManager();

    }
}
