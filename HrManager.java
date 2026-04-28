import java.util.*;

public class HrManager {
    static Scanner scan = new Scanner(System.in);
    static FinanceOfficer financeOfficer = new FinanceOfficer();
    static PaySlip paySlip = new PaySlip();
    static Salary salary = new Salary();

    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Payroll System!");
        
        while (true) {
            System.out.println("\n MAIN MENU");
            System.out.println("1. Manage Employees");
            System.out.println("2. Display Employees");
            System.out.println("3. Run Payroll Processing");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    manageEmployees();
                    break;
                case 2:
                    Employee emp = new Employee("", 0, "", 0);
                    emp.displayEmployees();
                    break;
                case 3:
                    runPayrollProcess();
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void manageEmployees() {
        while (true) {
            System.out.println("\nEmployee Mangement Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int empChoice = scan.nextInt();
            scan.nextLine();

            Employee emp = new Employee("", 0, "", 0);
            
            switch (empChoice) {
                case 1:
                    emp.addEmployee();
                    break;
                case 2:
                    emp.deleteEmployee();
                    break;
                case 3:
                    emp.displayEmployees();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void runPayrollProcess() {
        System.out.println("\nPayroll Processing");
        
        System.out.print("Enter Payroll Month: ");
        String month = scan.nextLine();
        System.out.print("Enter Year: ");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.println("processing payroll for " + month + " " + year + "...");
        
        System.out.println("\nFetching active employees...");

        List<Employee> activeEmployees = Employee.getActiveEmployees();
        System.out.println("[" + activeEmployees.size() + "] employees found.");
        
        if (activeEmployees.isEmpty()) {
            System.out.println("No active employees found. process end here !!");
            return;
        }
        
        System.out.println("\nsalary calculAtions ");
        for (Employee emp : activeEmployees) {
            double gross = salary.grossSalary(emp);
            System.out.println("Processing ID " + emp.id + " - " + emp.name + ": Gross Calculated: " + gross);
        }
        
        System.out.println("\nCalculating deductions...");
        for (Employee emp : activeEmployees) {
            double pf = salary.calculatePF(emp);
            double esi = salary.calculateESI(emp);
            double tds = salary.calculateTDS(emp);
            System.out.println("Processing ID " + emp.id + " - " + emp.name + ": Deductions - PF=" + pf + ", ESI=" + esi + ", TDS=" + tds);
        }
        
        System.out.println("\nComputing net salary...");
        for (Employee emp : activeEmployees) {
            double net = salary.calculateNetSalary(emp);
            System.out.println("ID " + emp.id + " - " + emp.name + ": Net Salary: " + net);
        }
        
        System.out.println("\nFINANCE OFFICER APPROVAL");
        financeOfficer.displayPayrollSummary(activeEmployees, month, year);
        
        if (!financeOfficer.approvePayroll(scan)) {
            return;
        }
        
        System.out.println("\nGenerating PaySlips");
        for (Employee emp : activeEmployees) {
            paySlip.generatePaySlip(emp, month, year);
        }
        
        System.out.println("\n bank transfer...");
        financeOfficer.initiatePayrollTransfer(activeEmployees);
        
        System.out.println("Payroll processing completed");
    }
}
