//package pl.pgurdek.oracleconnection;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.EntityManager;
//
//@RequestMapping("/")
//@RestController
//public class ControllerOracle {
//
//    final EntityManager entityManager;
//    private UserRepo userRepo;
//
//    public ControllerOracle(EntityManager entityManager, UserRepo userRepo) {
//        this.entityManager = entityManager;
//        this.userRepo = userRepo;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String getValue() {
//        userRepo.save(new User("piotrek","aaa"));
//        userRepo.findAll().forEach(
//                System.out::println
//        );
//        return "aaa";
//    }
//
//}
//
