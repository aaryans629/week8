# Week 8 Coding Assignment (Polymorphism & Inheritance)

---

### Problem 1: The Canteen Billing Counter
#### Task
A college canteen serves three kinds of customers: students, staff, and guests. Each kind of customer pays a different final amount for the same bill. For every bill, calculate the final amount to be paid, display it, and then display the total amount collected.

#### Input
The first line contains an integer N, the number of bills. Each of the next N lines contains a customer type and the bill amount.
- `STUDENT Amount`
- `STAFF Amount`
- `GUEST Amount`

#### Output
For each bill, display `CustomerType: FinalAmount`, formatted to two decimal places. Finally, display `Total: GrandTotal`, also formatted to two decimal places.

#### Business Rules
- Students get a 10% discount.
- Staff get a 5% discount.
- Guests pay the full amount plus a ₹10 service charge.

#### Sample Input
```
3
STUDENT 200
STAFF 300
GUEST 150
```

#### Expected Output
```
STUDENT: 180.00
STAFF: 285.00
GUEST: 160.00
Total: 625.00
```

---

### Problem 2: The Campus Parking Charge Calculator
#### Task
The campus parking lot allows bikes, cars, and trucks. Each vehicle type is charged differently based on the number of hours it was parked. For every parked vehicle, calculate the parking charge, display it, and then display the total charge collected.

#### Input
The first line contains an integer N, the number of parked vehicles. Each of the next N lines contains a vehicle type and the number of hours parked.
- `BIKE Hours`
- `CAR Hours`
- `TRUCK Hours`

#### Output
For each vehicle, display `VehicleType: Charge`, formatted to two decimal places. Finally, display `Total: GrandTotal`, also formatted to two decimal places.

#### Business Rules
- Bike: ₹10 per hour.
- Car: ₹30 for the first hour, plus ₹20 for each additional hour.
- Truck: ₹50 per hour, with a minimum charge of ₹100.

#### Sample Input
```
4
BIKE 3
CAR 4
TRUCK 1
CAR 1
```

#### Expected Output
```
BIKE: 30.00
CAR: 90.00
TRUCK: 100.00
CAR: 30.00
Total: 250.00
```

---

### Problem 3: The Hostel Electricity Bill
#### Task
A hostel has three kinds of rooms: single rooms, shared rooms, and AC rooms. Each room type calculates its monthly electricity bill differently. For shared rooms, the bill is split equally among the occupants, and the amount shown is what each occupant pays. For every room, calculate the bill, display it, and then display the total of all bills shown.

#### Input
The first line contains an integer N, the number of rooms. Each of the next N lines contains `RoomType Units [AdditionalParam]`.
- `SINGLE Units`
- `SHARED Units Occupants`
- `AC Units`

#### Output
For each room, display `RoomType: BillAmount`, formatted to two decimal places. Finally, display `Total: GrandTotal`, also formatted to two decimal places.

#### Business Rules
- Single room: ₹8 per unit.
- Shared room: ₹6 per unit, divided equally by the number of occupants.
- AC room: ₹10 per unit, plus a fixed charge of ₹200.

#### Sample Input
```
3
SINGLE 120
SHARED 150 3
AC 100
```

#### Expected Output
```
SINGLE: 960.00
SHARED: 300.00
AC: 1200.00
Total: 2460.00
```

---

### Problem 4: The Festival Bonus Calculator
#### Task
A company pays a festival bonus to its employees. Full-time employees, part-time employees, and interns each receive the bonus in a different way. For every employee, calculate the bonus, display it with the employee's name, and then display the total bonus paid.

#### Input
The first line contains an integer N, the number of employees. Each of the next N lines contains `EmployeeType Name MonthlySalary`.
- `FULLTIME Name MonthlySalary`
- `PARTTIME Name MonthlySalary`
- `INTERN Name MonthlySalary`

#### Output
For each employee, display `Name: Bonus`, formatted to two decimal places. Finally, display `Total Bonus: GrandTotal`, also formatted to two decimal places.

#### Business Rules
- Full-time employees get 10% of their monthly salary.
- Part-time employees get 5% of their monthly salary.
- Interns get a fixed bonus of ₹2,000, whatever their salary.

#### Sample Input
```
3
FULLTIME Asha 50000
PARTTIME Ravi 30000
INTERN Neha 15000
```

#### Expected Output
```
Asha: 5000.00
Ravi: 1500.00
Neha: 2000.00
Total Bonus: 8500.00
```

---

### Problem 5: The Streaming Plan Renewal Reminder
#### Task
A video streaming service offers three subscription plans: Basic, Standard, and Premium. Each plan stays valid for a different number of days from its start date. For every subscriber, calculate the date on which the plan must be renewed and display it.

#### Input
The first line contains an integer N, the number of subscribers. Each of the next N lines contains `PlanType Name StartDate`, where StartDate is in the format YYYY-MM-DD.
- `BASIC Name StartDate`
- `STANDARD Name StartDate`
- `PREMIUM Name StartDate`

#### Output
For each subscriber, display `Name: RenewalDate`, where RenewalDate is formatted as YYYY-MM-DD.

#### Business Rules
- Basic plan: valid for 30 days.
- Standard plan: valid for 90 days.
- Premium plan: valid for 365 days.
- The renewal date is the start date plus the plan's validity in days.

#### Sample Input
```
4
BASIC Asha 2024-01-15
STANDARD Ravi 2024-02-01
PREMIUM Neha 2024-03-10
BASIC Kiran 2024-12-20
```

#### Expected Output
```
Asha: 2024-02-14
Ravi: 2024-05-01
Neha: 2025-03-10
Kiran: 2025-01-19
```
