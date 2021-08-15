package entity;

public class Manager extends User {
    private int expInYear;

    public Manager(int id, String fullName, String email, String password, Role role, int projectId, int expInYear) {
        super(id, fullName, email, password, role, projectId);
        this.expInYear = expInYear;
    }

    public Manager() {
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' + ", Role =" + getRole() + ", projectId=" + getProjectId() + ", expInYear='" + expInYear + '\'' +
                '}';
    }
}

