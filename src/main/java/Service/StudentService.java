package Service;

import Domain.Student;
import Domain.Student;
import Repository.StudentRepo;
import Service.base.Service;

import java.util.Collection;
import java.util.Optional;

public class StudentService extends Service<Student, Integer> {
    private static final StudentRepo studentRepo;

    public static StudentRepo getStudentRepo() {
        return studentRepo;
    }

    static {
        studentRepo = new StudentRepo();
    }


    @Override
    public Student create(Student student) {

        Optional<Student> studentUpdate = studentRepo.create(student);

        return studentUpdate.get();
    }

    @Override
    public Student update(Student student) {

        Optional<Student> studentUpdate = studentRepo.create(student);

        return studentUpdate.get();
    }

    @Override
    public Student delete(Student student) {
        studentRepo.delete(student);
        return student;
    }


    @Override
    public void deleteById(Integer id) {
        studentRepo.delete(findByID(id));
    }

    @Override
    public Student exists(Student student) {
        Optional<Integer> entityId = Optional.ofNullable(studentRepo.getEntityId(student));
        return entityId.map(studentRepo::simpleFindById).orElse(null);
    }

    @Override
    public Collection<Student> readAll() {
        return studentRepo.readAll();
    }

    @Override
    public Student read(Student student) {
        return studentRepo.read(student);
    }

    @Override
    public Integer getEntityID(Student student) {
        return studentRepo.getEntityId(student);
    }

    @Override
    public Student findByID(Integer id) {
        return studentRepo.simpleFindById(id);
    }

    @Override
    public Student getEntity(Student student) {
        return studentRepo.getEntityFromDb(student).get();
    }
}
