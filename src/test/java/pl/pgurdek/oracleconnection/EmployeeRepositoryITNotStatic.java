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
public class EmployeeRepositoryITNotStatic{

    @Autowired
    private EmployeeRepo employee;

    @Rule
    public OracleContainer  oracle = new OracleContainer();

    @Test
    public void addEmployee() {
        Employee user = employee.saveAndFlush(new Employee("Piotr", "password"));
        Employee actual = employee.findById(user.getId()).get();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getUsername()).isEqualTo("Piotr");
        assertThat(actual.getPassword()).isEqualTo("password");
    }

    @Test
    public void findAllEmployees() {
        Employee user = employee.saveAndFlush(new Employee("Piotr", "password"));
        Employee user2 = employee.saveAndFlush(new Employee("Marek", "123"));

        List<Employee> actual = employee.findAll();
        assertThat(actual.size()).isEqualTo(2);
    }
}
