package dk.codezoo.service;

import dk.codezoo.common.service.util.BaseService;
import dk.codezoo.model.Pet;
import dk.codezoo.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService extends BaseService<Pet, PetRepository> {
}
