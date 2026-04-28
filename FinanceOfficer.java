import java.util.*;

public class FinanceOfficer {
    private boolean payrollApproved = false;

    public void displayPayrollSummary(List<Employee> employees, String month, int year) {
        Salary salary = new Salary();
        
        System.out.println("    PAYROLL SUMMARY FOR " + month.toUpperCase() + " " + year);
        System.out.println("\n");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("\n");
        
        double totalGross = 0;
        double totalDeductions = 0;
        double totalNet = 0;
        
        for (Employee emp : employees) {
            double gross = salary.grossSalary(emp);
            double pf = salary.calculatePF(emp);
            double esi = salary.calculateESI(emp);
            double tds = salary.calculateTDS(emp);
            double deductions = pf + esi + tds;
            double net = salary.calculateNetSalary(emp);
            
            System.out.printf("ID: %d | %s | Gross: %.2f | Deductions: %.2f | Net: %.2f\n", 
                emp.id, emp.name, gross, deductions, net);
            
            totalGross += gross;
            totalDeductions += deductions;
            totalNet += net;
        }
        
        System.out.println("\n");
        System.out.printf("TOTAL | Gross: %.2f | Deductions: %.2f | Net: %.2f\n", 
            totalGross, totalDeductions, totalNet);
        System.out.println("\n");
    }

    public boolean approvePayroll(Scanner scan) {
        System.out.print("Enter 'Approve' to confirm payroll: ");
        String input = scan.nextLine().trim();
        
        if (input.equalsIgnoreCase("Approve")) {
            payrollApproved = true;
            System.out.println("Payroll Approved! Period locked.");
            return true;
        } else {
            System.out.println("Payroll not approved. process cancelled...");
            return false;
        }
    }

    public void initiatePayrollTransfer(List<Employee> employees) {
        System.out.println("\n");
        System.out.println("Bank Transfer");
        System.out.println("\n");
        
        for (Employee emp : employees) {
            System.out.println("Processing: " + emp.name + " (ID: " + emp.id + ")");
        }
        
        System.out.println("\n");
        System.out.println("Bank Transfer Initiated. Salary transferred for " + employees.size() + " employees.");
        System.out.println("\n");
    }

    public boolean isPayrollApproved() {
        return payrollApproved;
    }
}
