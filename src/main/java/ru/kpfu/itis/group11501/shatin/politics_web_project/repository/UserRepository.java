package ru.kpfu.itis.group11501.shatin.politics_web_project.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.UserRole;

import java.util.List;

/**
 * @author Oleg Shatin
 * Date: 3/17/17 3:51 PM
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    //Query is generated automatically based on method name
    User findByEmail(String email);
    User findByEmailAndPasswordHash(String email, String password_hash);
    List<User> findAllByRole(UserRole role);
}
