package co.uk.ksb.HikariCP;

import co.uk.ksb.HikariCP.database.entity.Person;
import co.uk.ksb.HikariCP.database.entity.PersonRepository;
import co.uk.ksb.HikariCP.registration.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class RegisterService {

    @Autowired
    HikariDataSource datasource;
    private PersonRepository repo;

    @Autowired
    public RegisterService(PersonRepository repo) {
        this.repo = repo;
    }
    public void save(UserRequest user) {
        Person person = new Person();
        person.setAge(10);
        person.setName("Bhasker");
        person.setSex("Male");
        repo.save(person);
    }

    public void savePerson(UserRequest user)  {

        try {
            Connection connection = null;
            connection = datasource.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "select count(*) from person";
            ResultSet rs = stmt.executeQuery(sql);
            int personCount = 0;
            while(rs.next()) {
                personCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
