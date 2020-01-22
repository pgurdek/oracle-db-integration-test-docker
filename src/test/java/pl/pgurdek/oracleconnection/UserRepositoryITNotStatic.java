package pl.pgurdek.oracleconnection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.OracleContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
public class UserRepositoryITNotStatic {

    @Autowired
    private UserRepo userRepo;

    @Rule
    public OracleContainer  oracle = new OracleContainer();
    @Test
    public void addUser() {
        User user = userRepo.saveAndFlush(new User("Piotr", "password"));
        User actual = userRepo.findById(user.getId()).get();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getUsername()).isEqualTo("Piotr");
        assertThat(actual.getPassword()).isEqualTo("password");
    }

    @Test
    public void findAllUsers() {
        User user = userRepo.saveAndFlush(new User("Piotr", "password"));
        User user2 = userRepo.saveAndFlush(new User("Marek", "123"));

        List<User> actual = userRepo.findAll();
        assertThat(actual.size()).isEqualTo(2);
    }
}
