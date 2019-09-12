package site.syso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import site.syso.bean.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByName(String name);

    @Transactional
    void deleteUserById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE User SET name = :name WHERE id = :id")
    void updateUser(@Param("id") Long id, @Param("name") String name);

}
