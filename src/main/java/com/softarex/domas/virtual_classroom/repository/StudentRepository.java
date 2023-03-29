package com.softarex.domas.virtual_classroom.repository;

import com.softarex.domas.virtual_classroom.entity.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

    boolean existsById(UUID id);

    boolean existsByName(String name);

    List<Student> findAll();

    void deleteById(UUID id);

    List<Student> findByName(String name);

}
