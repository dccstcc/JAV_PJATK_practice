package UoW;

import Entity.Entity;
import Entity.EntityState;
import Repository.DatabaseContext;

import java.util.HashMap;
import java.util.Map;

public class HsqlUoW implements UoW {
    DatabaseContext databaseContext;
    Map<Entity, UoWRepository> entities;

    public HsqlUoW() {
        this.databaseContext = new DatabaseContext();
        this.entities = new HashMap<>();
    }

    @Override
    public void saveChanges() {
        this.databaseContext.saveChanges();
    }

    @Override
    public void undo() {
        this.databaseContext.undo();
    }

    private void setEntities(Entity entity, UoWRepository repository) {
        if(!this.entities.containsKey(entity))
            this.entities.put(entity, repository);
    }
    @Override
    public void markAsChanged(Entity entity, UoWRepository repository) {
        setEntities(entity, repository);

        entity.setEntityState(EntityState.Modified);
        repository.persistUpdate(entity);
    }

    @Override
    public void markAsDeleted(Entity entity, UoWRepository repository) {
        setEntities(entity, repository);
        entity.setEntityState(EntityState.Deleted);
        repository.persistUpdate(entity);
    }

    @Override
    public void markAsNew(Entity entity, UoWRepository repository) {
        setEntities(entity, repository);
        entity.setEntityState(EntityState.New);
        repository.persistUpdate(entity);
    }
}
