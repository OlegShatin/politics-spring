package ru.kpfu.itis.group11501.shatin.politics_web_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Oleg Shatin
 * Date: 5/2/17 5:24 PM
 */
/*
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByName(String name);
    Subject findByNameAndSemester(String name, Semester semester);
    @Query("select s from Subject as s   where s.semesterNumber = ?1 ")
    List<Subject> findAllBySemesterNumber(int semesterNumber);
    @Query("select s from Subject as s    " +
            "order by s.semesterNumber desc")
    List<Subject> findAllOrderBySemesterNumber();
    @Query("select s from Subject as s   where s.semesterNumber < ?1 " +
            "order by s.semesterNumber desc")
    List<Subject> findAllBySemesterNumberLessThanOrderBySemesterNumber(int semesterNumber);

}
*/