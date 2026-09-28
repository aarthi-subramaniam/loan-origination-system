import {useEffect,useState} from "react";
import axios from "axios";
import "./styles.css";
const API="http://localhost:8080/api/loans";
const empty={applicantName:"",email:"",phone:"",annualIncome:"",loanAmount:"",tenureMonths:"24",creditScore:"",loanPurpose:""};
export default function App(){
 const [form,setForm]=useState(empty),[loans,setLoans]=useState([]),[message,setMessage]=useState("");
 const load=async()=>{try{setLoans((await axios.get(API)).data)}catch{setMessage("Start the Spring Boot backend on port 8080.")}};
 useEffect(()=>{load()},[]);
 const change=e=>setForm({...form,[e.target.name]:e.target.value});
 const submit=async e=>{e.preventDefault();try{
  await axios.post(API,{...form,annualIncome:Number(form.annualIncome),loanAmount:Number(form.loanAmount),tenureMonths:Number(form.tenureMonths),creditScore:Number(form.creditScore)});
  setForm(empty);setMessage("Loan application submitted successfully.");load();
 }catch(err){setMessage(err.response?.data?.message||"Application submission failed.")}};
 return <div className="app"><header><p>BANKING DOMAIN PROJECT</p><h1>Loan Origination System</h1><span>Apply, validate eligibility, and track loan applications.</span></header>
 <main><section className="card"><h2>New Loan Application</h2><form onSubmit={submit} className="grid">
 {["applicantName","email","phone","annualIncome","loanAmount","tenureMonths","creditScore","loanPurpose"].map(name=>
 <label key={name}>{name.replace(/([A-Z])/g," $1")}<input required={["applicantName","email","annualIncome","loanAmount","tenureMonths","creditScore"].includes(name)} type={name==="email"?"email":["annualIncome","loanAmount","tenureMonths","creditScore"].includes(name)?"number":"text"} name={name} value={form[name]} onChange={change}/></label>)}
 <button>Submit Application</button></form>{message&&<p>{message}</p>}</section>
 <section className="card"><div className="row"><h2>Application Tracker</h2><button onClick={load}>Refresh</button></div><table><thead><tr><th>ID</th><th>Applicant</th><th>Amount</th><th>Credit</th><th>Status</th></tr></thead><tbody>
 {loans.map(l=><tr key={l.id}><td>#{l.id}</td><td>{l.applicantName}</td><td>₹{Number(l.loanAmount).toLocaleString("en-IN")}</td><td>{l.creditScore}</td><td className={l.status.toLowerCase()}>{l.status}</td></tr>)}
 {!loans.length&&<tr><td colSpan="5">No applications yet.</td></tr>}</tbody></table></section></main></div>
}
