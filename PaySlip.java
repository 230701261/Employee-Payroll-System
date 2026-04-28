
public class PaySlip {
    public void generatePaySlip(Employee emp, String month, int year) {
        Salary salary = new Salary();
        
        double basic = emp.salary;
        double hra = basic * 0.40;
        double conveyance = 1000;
        double allowances = basic * 0.10;
        double gross = basic + hra + conveyance + allowances;
        double pf = salary.calculatePF(emp);
        double esi = salary.calculateESI(emp);
        double tds = salary.calculateTDS(emp);
        double net = salary.calculateNetSalary(emp);

       System.out.println("\n-----");
        System.out.println("PAYSLIP FOR " + month.toUpperCase() + " " + year);
        System.out.println("Employee: " + emp.name + " (ID: " + emp.id + ")");
        System.out.println("\n");
        System.out.printf("Basic Salary: %.2f\n", basic);
        System.out.printf("HRA: %.2f\n", hra);
        System.out.printf("Conveyance: %.2f\n", conveyance);
        System.out.printf("Allowances: %.2f\n", allowances);
        System.out.printf("Gross Salary: %.2f\n", gross);
        System.out.printf("PF Deduction: %.2f\n", pf);
        System.out.printf("ESI Deduction: %.2f\n", esi);
        System.out.printf("TDS Deduction: %.2f\n", tds);
        System.out.printf("Net Salary: %.2f\n", net);
        System.out.println("\n");
    }
}
