package com.aarthi.loan.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="loan_applications")
public class LoanApplication {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String applicantName;
 @Column(nullable=false) private String email;
 private String phone;
 @Column(nullable=false, precision=15, scale=2) private BigDecimal annualIncome;
 @Column(nullable=false, precision=15, scale=2) private BigDecimal loanAmount;
 @Column(nullable=false) private Integer tenureMonths;
 @Column(nullable=false) private Integer creditScore;
 private String loanPurpose;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private LoanStatus status;
 @Column(nullable=false) private LocalDateTime createdAt;
 @PrePersist void onCreate(){ createdAt=LocalDateTime.now(); }
 public Long getId(){return id;}
 public String getApplicantName(){return applicantName;} public void setApplicantName(String v){applicantName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public BigDecimal getAnnualIncome(){return annualIncome;} public void setAnnualIncome(BigDecimal v){annualIncome=v;}
 public BigDecimal getLoanAmount(){return loanAmount;} public void setLoanAmount(BigDecimal v){loanAmount=v;}
 public Integer getTenureMonths(){return tenureMonths;} public void setTenureMonths(Integer v){tenureMonths=v;}
 public Integer getCreditScore(){return creditScore;} public void setCreditScore(Integer v){creditScore=v;}
 public String getLoanPurpose(){return loanPurpose;} public void setLoanPurpose(String v){loanPurpose=v;}
 public LoanStatus getStatus(){return status;} public void setStatus(LoanStatus v){status=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
