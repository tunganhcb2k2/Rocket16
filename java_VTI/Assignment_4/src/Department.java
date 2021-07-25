public class Department {
    public int departmentID;
    public String departmentName;
    public String date;

    public Department(int departmentID, String departmentName) {
        this.departmentID = 0;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public String getName() {

        return departmentName;
    }

    private static void Q1(){
        Department dep = new Department();
        Department dep1 = new Department(0,"TAH");
    }


}
