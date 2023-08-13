package org.hulyam.repository;

import org.hulyam.repository.entity.Sales;
import org.hulyam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findAllByUser(User user);
}
