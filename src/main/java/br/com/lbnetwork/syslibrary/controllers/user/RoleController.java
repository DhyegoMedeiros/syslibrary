package br.com.lbnetwork.syslibrary.controllers.user;

import br.com.lbnetwork.syslibrary.dtos.user.RoleRecordDto;
import br.com.lbnetwork.syslibrary.models.user.RoleModel;
import br.com.lbnetwork.syslibrary.repositories.user.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/role")
    public ResponseEntity<?> roleCreate(@RequestBody @Valid RoleRecordDto roleRecordDto){
        var roleOptional = roleRepository.findByRole("ROLE_"+roleRecordDto.role());
        if (roleOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(roleOptional.get());
        }
        var roleModel = new RoleModel();
        BeanUtils.copyProperties(roleRecordDto, roleModel);
        roleModel.setRole("ROLE_"+roleRecordDto.role().toUpperCase().trim());
        roleModel.setCreatedAt(new Date());
        roleModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(roleModel));
    }

    @GetMapping("/role")
    public ResponseEntity<Object> getAllRoles(){
        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.findAll());
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable(value = "id")UUID id){
        Optional<RoleModel> roleModelOptional = roleRepository.findById(id);
        if (roleModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No role located in the database checks the UUID provided in the request." + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(roleModelOptional.get());
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid RoleRecordDto roleRecordDto){
        Optional<RoleModel> roleModelOptional = roleRepository.findById(id);
        if (roleModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No role located in the database checks the UUID provided in the request." + id);
        }
        var roleModel = roleModelOptional.get();
        var data = roleModelOptional.get().getCreatedAt();
        BeanUtils.copyProperties(roleRecordDto, roleModel);
        roleModel.setCreatedAt(data);
        roleModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.save(roleModel));
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") UUID id){
        Optional<RoleModel> roleObject = roleRepository.findById(id);
        if (roleObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No role located in the database checks the UUID provided in the request.");
        }
        roleRepository.delete(roleObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("Role successfully deleted from the database.");
    }
}