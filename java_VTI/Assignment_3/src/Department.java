public class Department {
    public int departmentID;
    public String departmentName;
    public String date;

    public Department(int departmentID, String departmentName, String date) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.date = date;
    }

    public String getName() {

        return departmentName;
    }

    public int getID() {
        return departmentID;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    }

