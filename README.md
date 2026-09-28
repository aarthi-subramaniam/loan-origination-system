# Loan Origination System

Java full-stack portfolio project using Java 17, Spring Boot, React JS, REST API, and MySQL.

## Features
- Loan application submission
- Credit-score and eligibility validation
- Rule-based approval/rejection
- Loan status tracking
- REST APIs
- React JS frontend
- MySQL persistence

## Structure
loan-origination-system/
- backend/
- frontend/
- database/
- docs/
- README.md
- .gitignore

## Run
1. Create MySQL database with `database/schema.sql`.
2. In `backend/src/main/resources/application.properties`, set your MySQL username/password.
3. Run backend:
   `cd backend` then `mvn spring-boot:run`
4. Run frontend:
   `cd frontend` then `npm install` and `npm run dev`

Backend: http://localhost:8080
Frontend: http://localhost:5173

## Demo eligibility rules
- Credit score >= 650
- Income > 0
- Loan amount > 0
- Loan amount <= 5x annual income

This is an educational portfolio project, not a real banking credit-decision system.
