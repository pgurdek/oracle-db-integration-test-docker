//package pl.pgurdek.oracleconnection.conf;
//
//import oracle.jdbc.pool.OracleDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Configuration
//public class ConfigurationOracle {
//    @Bean
//    DataSource dataSource() throws SQLException {
//        OracleDataSource dataSource = new OracleDataSource();
//        dataSource.setUser("dbunit");
//        dataSource.setPassword("dbunit");
//        dataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
//        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setFastConnectionFailoverEnabled(true);
//        return dataSource;
//    }
//}
