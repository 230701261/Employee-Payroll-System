# Employee Payroll Management System (Java)

##  Introduction

The **Employee Payroll Management System** is a Java-based application developed to automate payroll operations such as employee record management, salary computation, deductions, and payslip generation.

This project is implemented using **core Java concepts** and utilizes **ArrayList as the primary data structure** for storing and managing employee and payroll data. It does not rely on any SQL or NoSQL database, making it lightweight and focused on demonstrating object-oriented design, data handling, and business logic implementation.

The system simulates real-world payroll processing workflows followed in organizations, ensuring structured salary calculation and deduction handling.

---

##  Development Phases

###  Phase 1: Foundation & Setup

* Define company policies (overtime rules, leave handling, tax structure)
* Design class models for:

  * Employee
  * Role
  * Salary Structure
  * Attendance
* Implement role-based access control (basic logic)
* Initialize data storage using **ArrayList collections**

---

###  Phase 2: Core Module Development

* Employee Management:

  * Add, update, view, and remove employee records
* Salary Configuration:

  * Define salary components (Basic, HRA, Allowances)
  * Configure deductions (PF, ESI, TDS, etc.)

---

###  Phase 3: Payroll Processing Engine

* Attendance Handling:

  * Track working days and leaves (LOP)
* Salary Calculation:

  * Compute Gross Salary
  * Apply deductions
  * Calculate Net Salary
* Tax Handling:

  * Basic tax computation based on defined rules

---

###  Phase 4: Output & Processing

* Generate payslip details (console-based or file output)
* Display structured salary breakdown for each employee
* Prepare payroll summary for processing salaries

---

##  Actors (System Users)

### HR Manager

* Manages employee records
* Updates roles and salary structures
* Handles employee onboarding and exit

### Finance Officer

* Processes payroll
* Calculates salaries and deductions
* Verifies and finalizes payroll data

### Employee

* Views salary details
* Accesses payslip information
* Checks deductions and net salary
