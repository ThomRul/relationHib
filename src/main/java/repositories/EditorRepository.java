package repositories;

import models.Editor;
import repositories.base.CrudRepository;

public class EditorRepository extends CrudRepository<Editor, Long> {
    public EditorRepository() {
        super(Editor.class);
    }
}
