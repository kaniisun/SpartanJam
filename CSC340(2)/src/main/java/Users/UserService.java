/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreyk
 */
@Service
public class UserService {
    @Autowired 
    private UserRepository repo;
    
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
}
