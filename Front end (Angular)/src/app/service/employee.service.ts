import { Injectable } from '@angular/core';
import { HttpClient,  HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Employee } from '../model/employee';
import { catchError } from 'rxjs/operators';

import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  addEmpURL : string;
  getEmpURL : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;
  getEmpByNameUrl: string;


  constructor(private http : HttpClient) {

    this.addEmpURL = 'http://localhost:9091/emp/addEmployee';
    this.getEmpURL = 'http://localhost:9091/emp/getAll';
    this.updateEmpUrl = 'http://localhost:9091/emp/updateEmployee';
    this.deleteEmpUrl = 'http://localhost:9091/emp/deleteEmployeeById';
    this.getEmpByNameUrl = 'http://localhost:9091/emp/getEmpByNameUsingJPQL';

   }

   addEmployee(emp : Employee): Observable<Employee> {
     return this.http.post<Employee>(this.addEmpURL,emp)
     .pipe(catchError(this.errorHandler));

   }


   getAllEmployee(): Observable<Employee[]>{
     return this.http.get<Employee[]>(this.getEmpURL)
     .pipe(catchError(this.errorHandler));

   }

   getEmpByName(term: string): Observable<any>{
    return this.http.get<Employee>(this.getEmpByNameUrl+'/'+term)
    .pipe(catchError(this.errorHandler));

  }
   
   updateEmployee(emp :Employee) : Observable<Employee>{
     return this.http.put<Employee>(this.updateEmpUrl, emp);
   }

   deleteEmployee(emp : Employee) : Observable<Employee> {
     return this.http.delete<Employee>(this.deleteEmpUrl+'/'+emp.id)
     .pipe(catchError(this.errorHandler));

   }

   errorHandler(error : HttpErrorResponse){
    return Observable.throwError(error.message || "server error");

   }

  

}
