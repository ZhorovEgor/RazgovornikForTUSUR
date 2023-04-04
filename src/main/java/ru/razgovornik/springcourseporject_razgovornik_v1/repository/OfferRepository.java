package ru.razgovornik.springcourseporject_razgovornik_v1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.razgovornik.springcourseporject_razgovornik_v1.models.OfferModel;

public interface OfferRepository extends CrudRepository<OfferModel, Long> {
}
