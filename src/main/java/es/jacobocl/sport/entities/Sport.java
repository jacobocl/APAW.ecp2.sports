package es.jacobocl.sport.entities;

public class Sport {
    
    private int id;
    
    private String name;

    public Sport(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{\"id\"=" + id + ", \"name\"=\"" + name + "\"}";
    }
}
