package net.matrix.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.matrix.petclinic.model.Owner;
import net.matrix.petclinic.services.EntityNotFoundException;


class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final private Owner owner = new Owner();
    final private Long ownerId = 123L;
    final private String lastName = "Zone";

    @BeforeEach
    void setUp() throws Exception {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        owner.setId(ownerId);
        owner.setAddress("11601, 4th ST N");
        owner.setCity("St Petersburg");
        owner.setFirstName("Brain");
        owner.setLastName(lastName);

        ownerMapService.save(owner);
    }


    @Test
    public void testDelete() throws Exception {
        ownerMapService.delete(owner);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    final void testFindAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
        assertThrows(UnsupportedOperationException.class, () -> owners.add(new Owner()));
    }

    @Test
    final void testFindById() {
        Owner foundOwner = ownerMapService.findById(ownerId);
        assertSame(owner, foundOwner);

        Owner emptyOwner = new Owner();
        assertEquals(emptyOwner, ownerMapService.findById(321L));
    }

    @Test
    final void testFindByLastName() {
        Owner foundOwner = ownerMapService.findByLastName("Zone");
        assertSame(owner, foundOwner);

        assertThrows(EntityNotFoundException.class, () -> ownerMapService.findByLastName("zone"));
    }

    @Test
    final void testSave_existingOwner() {
        Owner foundOwner = ownerMapService.findById(ownerId);
        assertSame(owner, foundOwner);

        assertEquals(ownerId, ownerMapService.save(foundOwner).getId());
    }


    @Test
    final void testSave_newOwner() {
        Owner owner = new Owner();
        assertNull(owner.getId());

        ownerMapService.save(owner);
        assertNotNull(owner.getId());
        assertEquals(ownerId.longValue() + 1L, owner.getId());
    }

}
