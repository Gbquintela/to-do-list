package com.to_do_list.to_do_list.repository;

import com.to_do_list.to_do_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpfAndPassword(String cpf, String password);
}
