package Repository;

import Domain.Teacher;
import Repository.Base.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Optional;

public class TeacherRepo extends Repository<Teacher, Integer> {

    @Override
    public Optional<Teacher> create(Teacher teacher) {
//        getTransaction().begin();
        //        getTransaction().commit();
        return simpleSave(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        simpleRemove(teacher);
    }

    @Override
    public Optional<Teacher> update(Teacher teacher) {
        return simpleSave(teacher);
    }

    @Override
    public Teacher read(Teacher teacher) {
        return simpleFindById(teacher.getTeacherId());
    }

    @Override
    public Collection<Teacher> readAll() {
        return simpleFindAll();
    }

    @Override
    public Class<Teacher> getEntityClassType() {
        return Teacher.class;
    }

    @Override
    public Optional<Teacher> getEntityFromDb(Teacher entity) {
        TypedQuery<Teacher> query = getTeacherTypedQuery(entity);
        Teacher foundTeacher = query.getSingleResult();
        return Optional.ofNullable(foundTeacher);
    }

    @Override
    public Integer getEntityId(Teacher entity) {
        TypedQuery<Teacher> query = getTeacherTypedQuery(entity);

        Teacher singleResult = query.getSingleResult();
        return singleResult.getTeacherId();
    }

    private TypedQuery<Teacher> getTeacherTypedQuery(Teacher entity) {
        return getEntityManager().createQuery(
                "select t from Teacher t where" +
                        " t.teacherFirstName = '" + entity.getTeacherFirstName() + "' " +
                        "and t.teacherLastName = '" + entity.getTeacherLastName() + "' " +
                        "and t.teacherCode = '" + entity.getTeacherCode() + "' " +
                        "and t.teacherSalary = '" + entity.getTeacherSalary() + "' " +
                        "and t.teacherBirthday = '" + entity.getTeacherBirthday() + "' ",
                Teacher.class
        );
    }
}
