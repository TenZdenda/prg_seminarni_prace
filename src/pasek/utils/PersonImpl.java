package pasek.utils;

import pasek.entities.Person;
import pasek.infa.PersonInface;
import pasek.utils.DatabaseConnect;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonImpl implements PersonInface {

    @Override
    public void insert(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnect.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO users (name, email, pass) VALUES (?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getEmail());
            preparedStatement.setString(3, person.getPass());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Chyba: " + e);
        }

    }

    @Override
    public Person selectedById(String email) {
        Person person = new Person();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnect.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setPass(resultSet.getString("pass"));
            }


        } catch (Exception e){
            System.out.println("Chyba: " + e);
        }

        return person;

    }

    @Override
    public void delete(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnect.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println("Chyba: " + e);
        }

    }
}
