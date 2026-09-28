package com.aarthi.loan.service;
import com.aarthi.loan.model.*;
import com.aarthi.loan.repository.LoanApplicationRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class LoanApplicationService {
 private final LoanApplicationRepository repository;
 public LoanApplicationService(LoanApplicationRepository repository){this.repository=repository;}
 public LoanApplication submit(LoanApplication a){a.setStatus(evaluate(a)); return repository.save(a);}
 public List<LoanApplication> findAll(){return repository.findAll();}
 public LoanApplication findById(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Loan application not found"));}
 public List<LoanApplication> findByStatus(LoanStatus status){return repository.findByStatus(status);}
 private LoanStatus evaluate(LoanApplication a){
  boolean income=a.getAnnualIncome()!=null && a.getAnnualIncome().compareTo(BigDecimal.ZERO)>0;
  boolean amount=a.getLoanAmount()!=null && a.getLoanAmount().compareTo(BigDecimal.ZERO)>0;
  boolean credit=a.getCreditScore()!=null && a.getCreditScore()>=650;
  boolean affordable=income && amount && a.getLoanAmount().compareTo(a.getAnnualIncome().multiply(BigDecimal.valueOf(5)))<=0;
  return income && amount && credit && affordable ? LoanStatus.APPROVED : LoanStatus.REJECTED;
 }
}
