package repositories;

import models.Feature;
import repositories.base.CrudRepository;

public class FeatureRepository extends CrudRepository<Feature, Long> {
    public FeatureRepository() {
        super(Feature.class);
    }
}
