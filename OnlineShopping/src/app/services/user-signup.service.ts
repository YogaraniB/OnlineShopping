import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserSignupService {
 
  constructor(private http:HttpClient) { }

  baseUrl="http://localhost:8019/api/v1";

  

  getUserSignUp(id): Observable<any> {
    return this.http.get(`${this.baseUrl}/getUserSignUpById/${id}`);
  }

  createUserSignUp(UserSignUp: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/UserSignUps`, UserSignUp);
  }

  updateUserSignUp(id, UserSignUp: Object): Observable<Object> {
   
    return this.http.put(this.baseUrl+"/UserSignUp/" +id,UserSignUp);
    
  }

  deleteUserSignUp(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+"/UserSignUp/" +id);
  }

  getUserSignUpsList(): Observable<any> {
    return this.http.get(this.baseUrl+"/UserSignUps");
  }

  getUserSignUpListAutoComplete(name:String):Observable<any> {
    return this.http.get(this.baseUrl+"/UserSignUpsByName1.8/"+name);
  }

  getUserSignUpListIdAutoComplete(empId:number):Observable<any> {
    return this.http.get(this.baseUrl+"/UserSignUpsById1.8/"+empId);
  }
  
}