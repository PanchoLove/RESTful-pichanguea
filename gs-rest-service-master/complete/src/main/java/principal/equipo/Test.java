package principal.equipo;

public class Test {
    int id;
    String data;

    public Test(){};

    public Test(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public Test(String id, String data) {
        this.id = Integer.parseInt(id);
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }
}
