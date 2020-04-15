package hu.elte.alkfejl.DormRooms.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LabelRepo extends CrudRepository<Label, Integer> {
    Optional<Label> findLabelByText(String text);
}
