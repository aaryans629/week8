# Week 8 Coding Practice (Polymorphism & Inheritance)

---

### Problem 1: Payment System Fee Calculation
#### Task
A payment processing system handles various transaction types. Each payment method applies a different processing fee. For every transaction, calculate the final amount after applying the applicable fee and display the adjusted amount for each transaction followed by the total amount processed.

#### Input
The first line contains an integer N, the number of transactions. Each of the next N lines contains a payment type and transaction amount.
- `CARD Amount`
- `WALLET Amount`
- `BANKTRANSFER Amount`

#### Output
For each transaction, display `PaymentType: AdjustedAmount`, formatted to two decimal places. Finally, display `Total: GrandTotal`, also formatted to two decimal places.

#### Business Rules
- Card transactions have a 2% processing fee.
- Wallet transactions have a 1% processing fee.
- Bank Transfers have no processing fee.

#### Sample Input
```
3
CARD 1000
WALLET 500
BANKTRANSFER 2000
```

#### Expected Output
```
CARD: 1020.00
WALLET: 505.00
BANKTRANSFER: 2000.00
Total: 3525.00
```

---

### Problem 2: Library Item Due Date Calculator
#### Task
A library manages different types of items (e.g., Books, DVDs, Magazines). Each item type has a specific borrowing duration. The system needs to process a list of borrowed items and calculate their respective due dates from the current date.

#### Input
The first line contains an integer N, the number of borrowed items. Each of the next N lines contains `ItemType ItemTitle`.
- `BOOK "The Great Gatsby"`
- `DVD "Inception"`
- `MAGAZINE "National Geographic Jan 2023"`

#### Output
For each borrowed item, display `ItemTitle: DueDate`. The DueDate should be formatted as YYYY-MM-DD.

#### Business Rules
- Books have a standard borrowing period of 14 days.
- DVDs have a standard borrowing period of 7 days.
- Magazines have a standard borrowing period of 3 days.
- Base current date: 2023-10-26.

#### Sample Input
```
3
BOOK "1984"
DVD "The Matrix"
MAGAZINE "Forbes Issue 500"
```

#### Expected Output
```
1984: 2023-11-09
The Matrix: 2023-11-02
Forbes Issue 500: 2023-10-29
```

---

### Problem 3: Delivery Fee Calculator
#### Task
A delivery service offers different types of delivery (e.g., Standard, Express, International). Each delivery type has unique rules for calculating its fee based on weight and distance. The system needs to calculate the total fee for a list of delivery requests.

#### Input
The first line contains an integer N, the number of delivery requests. Each of the next N lines contains `DeliveryType Weight Distance [AdditionalParam]`.
- `STANDARD Weight Distance`
- `EXPRESS Weight Distance`
- `INTERNATIONAL Weight Distance CustomsFee`

#### Output
For each delivery, display `DeliveryType: CalculatedFee`, formatted to two decimal places. Finally, display `Total: GrandTotalFee`, also formatted to two decimal places.

#### Business Rules
- Standard Delivery: Base fee $5, plus $0.50 per kg, plus $0.10 per km.
- Express Delivery: Base fee $15, plus $1.00 per kg, plus $0.20 per km.
- International Delivery: Base fee $25, plus $2.00 per kg, plus $0.50 per km, plus an additional CustomsFee.

#### Sample Input
```
3
STANDARD 10 50
EXPRESS 5 20
INTERNATIONAL 20 100 30
```

#### Expected Output
```
STANDARD: 15.00
EXPRESS: 29.00
INTERNATIONAL: 155.00
Total: 199.00
```

---

### Problem 4: Examination Question Grader
#### Task
An examination system needs to evaluate answers for different types of questions (e.g., Multiple Choice, True/False, Essay). Each question type has a specific grading logic. The system must process a list of questions with provided answers and determine the score for each, then calculate the total score.

#### Input
The first line contains an integer N, the number of questions. Each of the next N lines contains `QuestionType QuestionText CorrectAnswer StudentAnswer [Points]`.
- `MCQ "What is 2+2?" "4" "4" 10`
- `TF "Water boils at 100C?" "True" "True" 5`
- `ESSAY "Discuss OOP principles" "Polymorphism, Inheritance, Encapsulation" "I talked about Polymorphism and Inheritance." 20`

#### Output
For each question, display `QuestionType: Score`, formatted to two decimal places. Finally, display `Total Score: OverallScore`, also formatted to two decimal places.

#### Business Rules
- Multiple Choice Question (MCQ): Full points if StudentAnswer exactly matches CorrectAnswer.
- True/False Question (TF): Full points if StudentAnswer exactly matches CorrectAnswer.
- Essay Question (ESSAY): Partial points. If StudentAnswer contains at least two of the keywords from CorrectAnswer (comma-separated, case-insensitive), award 75% of Points. If one keyword, award 50%. Otherwise, 0 points.

#### Sample Input
```
4
MCQ "What is the capital of France?" "Paris" "Paris" 10
TF "The Earth is flat?" "False" "True" 5
ESSAY "Name two primary OOP principles." "Inheritance, Polymorphism, Encapsulation" "Polymorphism is one." 20
ESSAY "Describe abstraction and composition." "Abstraction, Composition" "I talked about abstraction." 15
```

#### Expected Output
```
MCQ: 10.00
TF: 0.00
ESSAY: 10.00
ESSAY: 7.50
Total Score: 27.50
```

---

### Problem 5: Public Transport Fare Calculator
#### Task
A public transport system calculates fares based on the type of transport (e.g., Bus, Train, Metro) and distance traveled. Each transport type has a different fare structure. The system needs to calculate the fare for a list of journeys and display the individual and total fares.

#### Input
The first line contains an integer N, the number of journeys. Each of the next N lines contains `TransportType Distance [AdditionalParam]`.
- `BUS Distance`
- `TRAIN Distance`
- `METRO Distance PeakHourFactor`

#### Output
For each journey, display `TransportType: CalculatedFare`, formatted to two decimal places. Finally, display `Total: GrandTotalFare`, also formatted to two decimal places.

#### Business Rules
- Bus: Base fare $2, plus $0.10 per km. Max fare $10.
- Train: Base fare $3, plus $0.15 per km.
- Metro: Base fare $1.50, plus $0.20 per km, multiplied by a PeakHourFactor.

#### Sample Input
```
3
BUS 15
TRAIN 50
METRO 10 1.5
```

#### Expected Output
```
BUS: 3.50
TRAIN: 10.50
METRO: 5.25
Total: 19.25
```
