package org.hulyam.repository;

import org.hulyam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    // select * from tbluser where name=?
    User findByName(String name);

    User findByAddress(String address);

    // select * from tbluser where name=? and address=?
    User findByNameAndAddress(String name, String address);

    // select * from tbluser where name=? or address=?
    List<User> findByNameOrAddress(String name, String address);

    User findByNameAndAddressAndTel(String name, String address, String tel);

    List<User> findAllByCity(String city);

    List<User> findAllByNameStartsWith(String word);

    Optional<User> findOptionalByNameAndTel(String name, String tel);

    List<User> findAllByNameOrderByIdDesc(String name);

    // SQL - limit 3
    List<User> findTop3ByNameOrderById(String name);
}
