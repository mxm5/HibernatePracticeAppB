package Service;

import Domain.Teacher;
import Domain.Teacher;
import Repository.TeacherRepo;
import Service.base.Service;

import java.util.Collection;
import java.util.Optional;

public class TeacherService extends Service<Teacher, Integer> {
    private static final TeacherRepo teacherRepo;

    public static TeacherRepo getTeacherRepo() {
        return teacherRepo;
    }

    static {
        teacherRepo = new TeacherRepo();
    }


    @Override
    public Teacher create(Teacher teacher) {

        Optional<Teacher> teacherUpdate = teacherRepo.create(teacher);

        return teacherUpdate.get();
    }

    @Override
    public Teacher update(Teacher teacher) {

        Optional<Teacher> teacherUpdate = teacherRepo.create(teacher);

        return teacherUpdate.get();
    }

    @Override
    public Teacher delete(Teacher teacher) {
        teacherRepo.delete(teacher);
        return teacher;
    }



    @Override
    public void deleteById(Integer id) {
        teacherRepo.delete(findByID(id));
    }

    @Override
    public Teacher exists(Teacher teacher) {
        Optional<Integer> entityId = Optional.ofNullable(teacherRepo.getEntityId(teacher));
        return entityId.map(teacherRepo::simpleFindById).orElse(null);
    }

    @Override
    public Collection<Teacher> readAll() {
        return teacherRepo.readAll();
    }

    @Override
    public Teacher read(Teacher teacher) {

        return teacherRepo.read(teacher);
    }

    @Override
    public Integer getEntityID(Teacher teacher) {
        return teacherRepo.getEntityId(teacher);
    }
    @Override
    public Teacher findByID(Integer id) {
        return teacherRepo.simpleFindById(id);
    }

    @Override
    public Teacher getEntity(Teacher teacher) {
        return teacherRepo.getEntityFromDb(teacher).get();
    }
}
