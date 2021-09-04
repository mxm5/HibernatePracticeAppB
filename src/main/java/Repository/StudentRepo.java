package Repository;

import Domain.Student;
import Repository.Base.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Optional;

public class StudentRepo extends Repository<Student,Integer> {

    public StudentRepo() {
        super();
    }

    @Override
    public Optional<Student> create(Student student) {
//getTransaction().begin();
        //        getTransaction().commit();
        return simpleSave(student);
    }

    @Override
    public void delete(Student student) {
         simpleRemove(student);
    }

    @Override
    public Optional<Student> update(Student student) {
        return simpleSave(student);
    }

    @Override
    public Student read(Student student) {
        return simpleFindById(student.getStudentId());
    }

    @Override
    public Collection<Student> readAll() {
        return simpleFindAll();
    }

    @Override
    public Class<Student> getEntityClassType() {
        return Student.class;
    }

    @Override
    public Optional<Student> getEntityFromDb(Student entity) {
        TypedQuery<Student> query = getStudentTypedQuery(entity);
        Student foundStudent = query.getSingleResult();
        return Optional.ofNullable(foundStudent);
    }

    @Override
    public Integer getEntityId(Student entity) {

        TypedQuery<Student> query = getStudentTypedQuery(entity);
        return query.getSingleResult().getId();
    }

    private TypedQuery<Student> getStudentTypedQuery(Student entity) {
        return getEntityManager().createQuery(
                "select s from Student s where" +
                        " s.studentFirstName = '" + entity.getStudentFirstName() + "' " +
                        "and s.studentLastName = '" + entity.getStudentLastName() + "' " +
                        "and s.studentCode = '" + entity.getStudentCode() + "' " +
                        "and s.studentBirthday = '" + entity.getStudentBirthday() + "'", Student.class
        );
    }
}
