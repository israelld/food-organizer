package dev.israelld.foodorganizer.services;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.User;
import dev.israelld.foodorganizer.repositories.DietRepository;
import dev.israelld.foodorganizer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private UserService userService;

    public Diet findById(Long id) {
        Optional<Diet> obj = dietRepository.findById(id);
        return obj.orElse(null);
    }

    public Diet findByDietNameIdentifierOrCreate(User user, String nameIdentifier){
        Diet obj = dietRepository.findByNameIdentifier(nameIdentifier);
        //return obj == null ? this.create(new Diet(diet.getUser(), nameIdentifier)) : obj;
        if(obj == null){
            obj = this.create(new Diet(userService.findByUserNameOrCreate(user.getUserName()), nameIdentifier));
            return obj;
        }
        return obj;
    }

    public List<Diet> findAll() {
        return dietRepository.findAll();
    }

    public Diet update(Long id, Diet obj) {
        Diet newObj = findById(id);
        newObj.setId(id);
        newObj.setUser(obj.getUser());
        newObj.setNameIdentifier(obj.getNameIdentifier());
        return dietRepository.save(newObj);
    }

    public Diet create(Diet obj) {
        return dietRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        dietRepository.deleteById(id);
    }
}
