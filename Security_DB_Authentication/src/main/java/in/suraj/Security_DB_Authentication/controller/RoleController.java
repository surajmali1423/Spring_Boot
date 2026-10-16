package in.suraj.Security_DB_Authentication.controller;

import in.suraj.Security_DB_Authentication.entity.Role;
import in.suraj.Security_DB_Authentication.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<String>addRole(
            @RequestBody Role role){

        return ResponseEntity.ok(roleService.addRole(role));
    }
}
