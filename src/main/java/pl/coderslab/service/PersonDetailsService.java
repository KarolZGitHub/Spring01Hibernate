package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.PersonDetails;

@Service
@Transactional
public class PersonDetailsService {
    private PersonDetailsDao personDetailsDao;

    public PersonDetailsService(PersonDetailsDao personDetailsDao) {
        this.personDetailsDao = personDetailsDao;
    }
    public void create(PersonDetails personDetails){
        personDetailsDao.addPersonDetails(personDetails);
    }
    public PersonDetails find(long id){
        return personDetailsDao.findPersonDetailsById(id);
    }
    public void update(PersonDetails personDetails){
        personDetailsDao.updatePersonDetails(personDetails);
    }
    public void delete(long id){
        personDetailsDao.deletePersonDetailsById(id);
    }
}
