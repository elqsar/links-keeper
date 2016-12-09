package cz.linkskeeper.users.repository;

import cz.linkskeeper.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    List<User> findByUserNameLike(String userName);

    List<User> findByUserNameNotLike(String userName);

    List<User> findByFirstNameLikeAndLastName(String firstName, String lastName);

    @Query("select user from User user where user.mail = ?1")
    User findByEmailAddress(String emailAddress);
//
//    @Query("select u from User u where u.id >= :lowest and u.id <= :highest")
//    List<User> queryByIdRange(@Param("lowest") Long lowest,
//                              @Param("highest") Long highest);
}
