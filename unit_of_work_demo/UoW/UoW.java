package UoW;

import Entity.Entity;

public interface UoW {
    void saveChanges();
    void undo();

    void markAsNew(Entity entity, UoWRepository repository);
    void markAsDeleted(Entity entity, UoWRepository repository);
    void markAsChanged(Entity entity, UoWRepository repository);
}
