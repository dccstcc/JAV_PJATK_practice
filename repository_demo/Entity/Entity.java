package Entity;
public abstract class Entity {
    protected int id;
    protected EntityState entityState;

    public Entity() {
        this(0);
    }
    public Entity(int id) {
        this(id, EntityState.New);
    }
    public Entity(int id, EntityState entityState) {
        this.id = id;
        this.entityState = entityState;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) { this.id = id; }
    public EntityState getEntityState() {
        return  this.entityState;
    }
    public void setEntityState(EntityState entityState) {
        this.entityState = entityState;
    }
}
