CREATE DATABASE IF NOT EXISTS loan_origination;
USE loan_origination;

CREATE TABLE IF NOT EXISTS loan_applications (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 applicant_name VARCHAR(120) NOT NULL,
 email VARCHAR(150) NOT NULL,
 phone VARCHAR(30),
 annual_income DECIMAL(15,2) NOT NULL,
 loan_amount DECIMAL(15,2) NOT NULL,
 tenure_months INT NOT NULL,
 credit_score INT NOT NULL,
 loan_purpose VARCHAR(200),
 status VARCHAR(30) NOT NULL,
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
