public class Salary {
    public double grossSalary(Employee emp) {
        double basicSalary = emp.salary;
        double hra = basicSalary * 0.40;
        double conveyance = 1000;
        double allowances = basicSalary * 0.10;
        double grossSalary = basicSalary + hra + conveyance + allowances;
        return grossSalary;
    }

    public double calculatePF(Employee emp) {
        double basicSalary = emp.salary;
        double threshold = 15000;
        if (basicSalary > threshold) {
            return basicSalary * 0.12;
        }
        return 0;
    }

    public double calculateESI(Employee emp) {
        double grossSalary = grossSalary(emp);
        double threshold = 21000;
        if (grossSalary >= threshold) {
            return grossSalary * 0.0075;
        }
        return 0;
    }

    public double calculateTDS(Employee emp) {
        double grossSalary = grossSalary(emp);
        if (grossSalary >= 50000) {
            return grossSalary * 0.10;
        } else if (grossSalary >= 35000) {
            return grossSalary * 0.05;
        }
        return 0;
    }

    public double calculateNetSalary(Employee emp) {
        double grossSalary = grossSalary(emp);
        double pf = calculatePF(emp);
        double esi = calculateESI(emp);
        double tds = calculateTDS(emp);
        return grossSalary - pf - esi - tds;
    }

    public void displaySalaryDetails(Employee emp) {
        double basic = emp.salary;
        double hra = basic * 0.40;
        double conveyance = 1000;
        double allowances = basic * 0.10;
        double gross = basic + hra + conveyance + allowances;
        double pf = calculatePF(emp);
        double esi = calculateESI(emp);
        double tds = calculateTDS(emp);
        double net = calculateNetSalary(emp);

        System.out.println("\nSalary Breakdown for " + emp.name + " (ID: " + emp.id + ")");
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("Conveyance: " + conveyance);
        System.out.println("Allowances: " + allowances);
        System.out.println(" ");
        System.out.println("Gross Salary: " + gross);
        System.out.println("---");
        System.out.println("Deductions:");
        System.out.println("PF: " + pf);
        System.out.println("ESI: " + esi);
        System.out.println("TDS: " + tds);
        System.out.println(" ");
        System.out.println("Net Salary: " + net);
    }
}
