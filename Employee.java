import java.util.*;

class Employee {
    String name;
    int id;
    String role;
    Date dateOfJoining;
    double salary;
    boolean active;

    Scanner scan = new Scanner(System.in);

    static List<Employee> employees = new ArrayList<>();

    public Employee(String name, int id, String role, double salary) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.salary = salary;
        this.dateOfJoining = new Date();
        this.active = true;
    }

    public Employee(String name, int id, String role, double salary, boolean active) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.salary = salary;
        this.dateOfJoining = new Date();
        this.active = active;
    }

    public void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scan.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scan.nextInt();
        scan.nextLine(); 
        System.out.print("Enter employee role: ");
        String role = scan.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scan.nextDouble();
        scan.nextLine();

        Employee newEmployee = new Employee(name, id, role, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully!");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            System.out.println("Name: " + emp.name + ", ID: " + emp.id + ", Role: " + emp.role + ", Salary: " + emp.salary + ", Active: " + emp.active);
        }
    }

    public static List<Employee> getActiveEmployees() {
        List<Employee> activeEmp = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.active) {
                activeEmp.add(emp);
            }
        }
        return activeEmp;
    }

    public static Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                return emp;
            }
        }
        return null;
    }

    public void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scan.nextInt();
        scan.nextLine(); 
        boolean removed = employees.removeIf(emp -> emp.id == id);
        if (removed) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

   
}