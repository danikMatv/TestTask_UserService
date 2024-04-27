package com.clearsolutions.demotask.repository;

import com.clearsolutions.demotask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    List<User> findUsersByDateBetween(Date fromDate, Date toDate);

}
