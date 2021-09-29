package UoW;

import Entity.Entity;

public interface UoWRepository {
    void persistAdd(Entity entity);
    void persistRemove(Entity entity);
    void persistUpdate(Entity entity);
}
