package Controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.persistence.Id;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User responseEntity = userService.getUser(id);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> responseEntities = userService.getAllUser();
        if (responseEntities.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseEntities);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User responseEntity = userService.getUser(id);
        userService.deleteUser(id);
        return ResponseEntity.ok(responseEntity);
    }
}
