package hu.elte.alkfejl.DormRooms.model;

import org.springframework.data.repository.CrudRepository;

public interface LayoutRepo extends CrudRepository<Layout, Integer> {
    Object synchronizationObject = new Object();
}
