package com.example.UserManagementAPI;

import com.example.UserManagementAPI.Model.User;
import com.example.UserManagementAPI.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //loads only relevent content to JPA
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp(){
        userRepository.deleteAllInBatch();
        user1 = new User("Alice Wonderland","alice@example.com");
        user2 = new User("Bob The Builder","bob@example.com");
        user3 = new User("ram","ram@gmail.com");

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void testFindByEmailFound(){
        Optional<User> foundUser = userRepository.findByEmail(user1.getEmail());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo(user1.getName());
        assertThat(foundUser.get().getEmail()).isEqualTo(user1.getEmail());
        assertThat(foundUser.get().getId()).isEqualTo(user1.getId());
    }

    @Test
    void testByEmailByNotFound(){
        String NonExistingEmail = "abc@example.com";
        Optional<User> foundUser = userRepository.findByEmail(NonExistingEmail);
        assertThat(foundUser).isEmpty();
    }

    @Test
    void testSaveUser(){
        User newUser = new User("Charlie Chaplin","charlie@example.com");
        User saveduser = userRepository.save(newUser);

        assertThat(saveduser).isNotNull();
        assertThat(saveduser.getId()).isNotNull();
        assertThat(saveduser.getName()).isNotNull();
        assertThat(saveduser.getEmail()).isNotNull();
    }

    @Test
    void testUpdateUser(){
        String newName = "Vishnu";
        String newEmail = "vishnu@gmail.com";



        user3.setName(newName);
        user3.setEmail(newEmail);

        User updatedUser = userRepository.save(user3);

        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getId()).isNotNull();
        assertThat(updatedUser.getName()).isEqualTo(newName);
        assertThat(updatedUser.getEmail()).isEqualTo(newEmail);

    }

    @Test
    void testDeleteUser(){
        Optional<User> foundUser = userRepository.findById(user1.getId());
        userRepository.deleteById(user1.getId());
    }
}
