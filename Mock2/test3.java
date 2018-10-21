package Mock;

public class test3 {

    String name;
    int age;
    String designation;
    double salary;
    // This is the constructor of the class Employee
    public test(String name) {
        this.name = name;
    }

    // Assign the age of the Employee  to the variable age.
    public void empAge(int empAge) {
        age = empAge;
    }

    /* Assign the designation to the variable designation.*/
    public void empDesignation(String empDesig) {
        designation = empDesig;
        System.out.println("Salary:" + salary.getAmount().getPounds());
    }
}

public class test4 {
    /* Print the Employee details */
    public void printEmployee() {
        String x = Get.something().getTest().get();
        System.out.println("Name:"+ name );
        System.out.println("Age:" + age );
        System.out.println("Designation:" + designation );
    }
}