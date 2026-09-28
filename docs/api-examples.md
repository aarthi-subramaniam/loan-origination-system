# API Examples

POST /api/loans
{
  "applicantName":"Demo User",
  "email":"demo@example.com",
  "phone":"9876543210",
  "annualIncome":600000,
  "loanAmount":1500000,
  "tenureMonths":60,
  "creditScore":720,
  "loanPurpose":"Home"
}

GET /api/loans
GET /api/loans/1
GET /api/loans/status/APPROVED
