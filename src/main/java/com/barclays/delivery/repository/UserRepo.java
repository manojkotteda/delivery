package com.barclays.delivery.repository;

import com.barclays.delivery.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepo extends JpaRepository<Credentials, Integer> {
    public Credentials findByEmailAndPassword(String email,String password);
    public Credentials findByEmail(String email);

}
