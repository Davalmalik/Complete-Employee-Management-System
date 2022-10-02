
import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Employee } from "src/app/model/employee";
import { EmployeeService } from "src/app/service/employee.service";



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {
  empDetail !: FormGroup;
  submitted = false;
  empObj : Employee = new Employee();
  empList : Employee[] = [];
  //name : string;
  public errorMsg!: string;
  searchText : string ='';
  
  

  constructor(private empService : EmployeeService) {
    this.searchText = '';
   }


  ngOnInit()  {
    
    this.getAllEmployee();

    this.empDetail = new FormGroup({
      id : new FormControl(null),
      name : new FormControl(null, [Validators.required, Validators.pattern('[a-zA-Z\\s]+$')]),
      email : new FormControl(null, [Validators.required, Validators.email]),
      salary : new FormControl(null, [Validators.required, Validators.pattern('[0-9,.]+$')]),
      primary_mobile_number : new FormControl(null, [Validators.required, Validators.minLength(10),Validators.pattern('[0-9,-]+$')]),
      secondary_mobile_number : new FormControl(null, [Validators.required,Validators.minLength(10), Validators.pattern('[0-9,-]+$')]),
      project : new FormControl(null, [Validators.required, Validators.pattern('[a-zA-Z,.-_\\s]+$')]),
      reporting_To : new FormControl(null, [Validators.required, Validators.pattern('[a-zA-Z,.-_\\s]+$')]),
    });

    
  }


  onSubmit() {
    console.log(this.empDetail.value);
    this.empDetail.reset();
  }
  get name() {
    return this.empDetail.get('name');
  }
  get email() {
    return this.empDetail.get('email');
  }
  get salary() {
    return this.empDetail.get('salary');
  }
  get primary_mobile_number() {
    return this.empDetail.get('primary_mobile_number');
  }
  get secondary_mobile_number() {
    return this.empDetail.get('secondary_mobile_number');
  }
  get project() {
    return this.empDetail.get('project');
  }
  get reporting_To() {
    return this.empDetail.get('reporting_To');
  }


  addEmployee() {
    console.log(this.empDetail);
    this.empObj.id = this.empDetail.value.id;
    this.empObj.name = this.empDetail.value.name;
    this.empObj.salary = this.empDetail.value.salary;
    this.empObj.email = this.empDetail.value.email;
    this.empObj.primary_mobile_number = this.empDetail.value.primary_mobile_number;
    this.empObj.secondary_mobile_number = this.empDetail.value.secondary_mobile_number;
    this.empObj.project = this.empDetail.value.project;
    this.empObj.reporting_To = this.empDetail.value.reporting_To;

    this.empService.addEmployee(this.empObj).subscribe(res=>{
        console.log(res);
        this.getAllEmployee();
    },error=>{
      this.errorMsg = " Employee is not able to add due to Some internal issues while making API call";
      alert(this.errorMsg);
    });

  }

  getAllEmployee() {
    this.empService.getAllEmployee().subscribe(res=>{
      console.log(res);
        this.empList = res;
      }, error=>{ this.errorMsg = "Some internal issues while making API call";
      });
  }


  editEmployee(emp : Employee) {
    this.empDetail.controls['id'].setValue(emp.id);
    this.empDetail.controls['name'].setValue(emp.name);
    this.empDetail.controls['email'].setValue(emp.email);
    this.empDetail.controls['salary'].setValue(emp.salary);
    this.empDetail.controls['primary_mobile_number'].setValue(emp.primary_mobile_number);
    this.empDetail.controls['secondary_mobile_number'].setValue(emp.secondary_mobile_number);
    this.empDetail.controls['project'].setValue(emp.project);
    this.empDetail.controls['reporting_To'].setValue(emp.reporting_To);
   

  }

  updateEmployee() {

    this.empObj.id = this.empDetail.value.id;
    this.empObj.name = this.empDetail.value.name;
    this.empObj.salary = this.empDetail.value.salary;
    this.empObj.email = this.empDetail.value.email;
    this.empObj.primary_mobile_number = this.empDetail.value.primary_mobile_number;
    this.empObj.secondary_mobile_number = this.empDetail.value.secondary_mobile_number;
    this.empObj.project = this.empDetail.value.project;
    this.empObj.reporting_To = this.empDetail.value.reporting_To;

    this.empService.updateEmployee(this.empObj).subscribe(res=>{
      console.log(res);
      this.getAllEmployee();
    },error=>{ this.errorMsg = "Some internal issues while making API call";
    });

  }

  deleteEmployee(emp : Employee) {
    if(confirm("Are you sure  to delete "+this.name)){

    this.empService.deleteEmployee(emp).subscribe(res=>{
      console.log(res);
      alert('Employee deleted successfully');
      this.getAllEmployee();
    },err => {
      console.log(err);
    });
  }
  } 


  serchByName(){
    let term = this.searchText;
    this.empService.getEmpByName(term).subscribe(data => {
      this.empList =data;
      
    })
  }












  // Search(){
  //   if(this.name == ""){
  //     this.ngOnInit();
  //   }else{
  //     this.empList = this.empList.filter(res =>{
  //       return res.name.toLowerCase().match(this.name.toLowerCase());

  //     })
  //   }
  // }
}

