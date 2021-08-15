package entity;

public class Employee extends User {
    private int projectId;
    private ProSkill proSkill;

    private enum ProSkill {
        DEV, TEST, JAVA, SQL
    }

    public Employee(int id, String fullName, String email, String password, Role role, int projectId, int projectId1, ProSkill proSkill) {
        super(id, fullName, email, password, role, projectId);
        this.projectId = projectId1;
        this.proSkill = proSkill;
    }

    public Employee() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public ProSkill getProSkill() {
        return proSkill;
    }

    public void setProSkill(ProSkill proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                "projectId=" + projectId + ", Role =" + getRole() +
                ", proSkill=" + proSkill + ", projectId=" + projectId +
                '}';
    }
}
