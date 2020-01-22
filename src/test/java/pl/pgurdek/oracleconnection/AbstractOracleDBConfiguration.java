package pl.pgurdek.oracleconnection;

import org.junit.Before;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.OracleContainer;

import java.sql.SQLException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {AbstractOracleDBConfiguration.Initializer.class})
public abstract class AbstractOracleDBConfiguration {
    static final OracleContainer oracle;

    static {
        oracle = new OracleContainer("quay.io/maksymbilenko/oracle-12c")
                .withInitScript("schema-test.sql")
                .withExposedPorts(32868);
        oracle.start();
    }

    @Before
    public void setUp() throws SQLException {

    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues
                    .of("spring.datasource.url=" + oracle.getJdbcUrl(),
                            "spring.datasource.username=" + oracle.getUsername(),
                            "testcontainers.reuse.enable=true",
                            "spring.datasource.password=" + oracle.getPassword())
                    .applyTo(configurableApplicationContext.getEnvironment());
        }
    }

}