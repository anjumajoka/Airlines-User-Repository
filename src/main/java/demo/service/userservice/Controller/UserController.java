package demo.service.userservice.Controller;

import demo.service.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import demo.service.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User responseEntity = userService.getUser(id);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> responseEntities = userService.getAllUser();
        if (responseEntities.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseEntities);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User responseEntity = userService.createUser(user);
        return ResponseEntity.ok(responseEntity);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User responseEntity = userService.getUser(id);
        userService.deleteUser(id);
        return ResponseEntity.ok(responseEntity);
    }
}
