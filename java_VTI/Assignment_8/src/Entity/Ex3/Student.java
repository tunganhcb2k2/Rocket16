package Entity.Ex3;

public class Student<A> {
    private A id;
    private String name;

    public Student(A id, String name) {
        this.id = id;
        this.name = name;
    }

    public A getId() {
        return id;
    }

    public void setId(A id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
