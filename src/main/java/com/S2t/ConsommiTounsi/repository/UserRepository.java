package com.S2t.ConsommiTounsi.repository;
import com.S2t.ConsommiTounsi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findByusername(String username);

    public List<User> findByemail(String email);
}
