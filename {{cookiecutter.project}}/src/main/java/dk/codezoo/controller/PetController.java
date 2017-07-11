package dk.codezoo.controller;

import dk.codezoo.common.service.mapping.jackson.TreeNodeHolder;
import dk.codezoo.common.service.util.BaseController;
import dk.codezoo.model.Pet;
import dk.codezoo.service.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
public class PetController extends BaseController<Pet, PetService> {

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> index(WebRequest request) {
        Pageable pageable = pageMapper.parse(request, "name");
        Page<Pet> page = service.findAll(pageMapper.parse(request, "name"));

        return pageMapper.render(page);
    }

    @GetMapping("pets/{id}")
    public Pet get(@PathVariable String id) {
        return checkResource(service.findOne(id));
    }

    @PostMapping("pets")
    public Pet create(@RequestBody Pet pet) {
        return doCreate(pet);
    }

    @PostMapping("pets/{id}")
    public Pet update(@PathVariable String id,  @RequestBody Pet pet) {
        return doUpdate(id, pet, treeNodePropertyReferenceConverter.translate(TreeNodeHolder.get()));
    }

}
