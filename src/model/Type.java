package model;

public class Type {
    private int id;
    private String name;
    private String encodeName;

    public Type() {
    }

    public Type(int id, String name, String encodeName) {
        this.id = id;
        this.name = name;
        this.encodeName = encodeName;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEncodeName() {
        return encodeName;
    }

    public void setEncodeName(String encodeName) {
        this.encodeName = encodeName;
    }
}
