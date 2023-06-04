package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addPersonDetails(PersonDetails personDetails){
        entityManager.persist(personDetails);
    }
    public PersonDetails findPersonDetailsById(long id){
        return entityManager.find(PersonDetails.class, id);
    }
    public void updatePersonDetails(PersonDetails personDetails){
        entityManager.merge(personDetails);
    }
    public void deletePersonDetailsById(long id){
        PersonDetails personDetails = findPersonDetailsById(id);
        entityManager.remove(entityManager.contains(personDetails) ? personDetails : entityManager.merge(personDetails));
    }
}
