package repositories;

import models.Licence;
import repositories.base.CrudRepository;

public class LicenceRepository extends CrudRepository<Licence, Long> {
    public LicenceRepository() {
        super(Licence.class);
    }
}
