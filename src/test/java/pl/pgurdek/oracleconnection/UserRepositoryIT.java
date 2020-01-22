package pl.pgurdek.oracleconnection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserRepositoryIT extends AbstractOracleDBConfiguration{

    @Autowired
    private UserRepo userRepo;

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
