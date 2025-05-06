package com.to_do_list.to_do_list.repository;

import com.to_do_list.to_do_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
