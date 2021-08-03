
public class Exercise5 {
    Department dep1 = new Department(1, "DEV", "2021-02-02");
    Department dep2 = new Department(2, "PM", "2021-01-02");
    Department dep3 = new Department(3, "GD", "2021-03-02");


    public void Q1() {
        System.out.println(dep1.toString());

    }

    public void Q3() {
        System.out.println(dep1.hashCode());
    }

    public void Q4() {
        if (dep1.departmentName == "phong A") {
            System.out.println("phong ban 1 la phong A");
        } else {
            System.out.println("phong ban 1 khong phai la phong A ma la phong " + dep1.departmentName);
        }
    }

    public void Q5(){
        if (dep1.departmentName.equals(dep2.departmentName)){
            System.out.println("co bang nhau !");
        } else {
            System.out.println("khong bang nhau!");
        }
    }

}
