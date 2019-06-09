package pasek.infa;

import pasek.entities.Person;

public interface PersonInface {

    void insert(Person person );

    Person selectedById( String email );

    void delete( String email );

}
