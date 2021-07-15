package com.newsapp.Repository;

import com.newsapp.Model.DAO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByEmail(String email);
}
