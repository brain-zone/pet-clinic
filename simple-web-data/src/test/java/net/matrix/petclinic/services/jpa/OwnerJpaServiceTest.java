package net.matrix.petclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import net.matrix.petclinic.model.Owner;
import net.matrix.petclinic.repositories.OwnerRepository;
import net.matrix.petclinic.services.EntityNotFoundException;
import net.matrix.petclinic.services.PetService;
import net.matrix.petclinic.services.PetTypeService;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
    @Mock
    PetService petService;

    @Mock
    PetTypeService petTypeService;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService ownerService;

    final Owner owner = new Owner();
    final Long ownerId = 123L;
    final String lastName = "Shores";

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        owner.setId(ownerId);
        owner.setAddress("11601, 4th ST N");
        owner.setCity("St Petersburg");
        owner.setFirstName("Lincoln");
        owner.setLastName(lastName);
    }


    @Test
    final void testDelete() {
        ownerService.delete(owner);
        verify(ownerRepository, atMostOnce()).delete(any());
    }

    @Test
    final void testFindAll() {
        Set<Owner> owners = new HashSet<>(3);

        Owner aOwner = new Owner();
        aOwner.setId(1L);
        owners.add(aOwner);

        Owner bOwner = new Owner();
        bOwner.setId(2L);
        owners.add(bOwner);

        Owner cOwner = new Owner();
        cOwner.setId(3L);
        owners.add(cOwner);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> foundOwners = ownerService.findAll();
        assertNotNull(foundOwners);
        assertEquals(3, foundOwners.size());
        assertEquals(owners, foundOwners);
        assertThrows(UnsupportedOperationException.class, () -> foundOwners.add(new Owner()));
        verify(ownerRepository, atMostOnce()).findAll();
    }

    @Test
    final void testFindById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));

        Owner foundOwner = ownerService.findById(ownerId);
        assertSame(owner, foundOwner);
        verify(ownerRepository, atMostOnce()).findById(any());
    }

    @Test
    final void testFindById_NoMatchFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> ownerService.findById(321L));
        verify(ownerRepository, atMostOnce()).findById(any());
    }

    @Test
    final void testFindByLastName() {
        when(ownerRepository.findByLastName(lastName)).thenReturn(Optional.of(owner));

        Owner foundOwner = ownerService.findByLastName(lastName);
        assertSame(owner, foundOwner);

        verify(ownerRepository, atMostOnce()).findByLastName(anyString());
    }

    @Test
    final void testFindByLastName_NoMatchFound() {
        when(ownerRepository.findByLastName("nobody")).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> ownerService.findByLastName("nobody"));
        verify(ownerRepository, atMostOnce()).findByLastName(anyString());
    }


    @Test
    final void testSave() {
        Owner aOwner = new Owner();
        aOwner.setId(12345L);
        when(ownerRepository.save(any())).thenReturn(aOwner);

        Owner savedOwner = ownerRepository.save(aOwner);
        assertSame(aOwner, savedOwner);
    }

}
