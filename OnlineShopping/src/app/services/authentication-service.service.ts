import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  // authenticate(username, password) {
  //   return this.httpClient.post<any>('http://localhost:8013/authenticate',{username,password}).pipe(
  //    map(
  //      userData => {
  //       sessionStorage.setItem('username',username);
  //       let tokenStr= 'Bearer '+userData.token;
  //       sessionStorage.setItem('token', tokenStr);
  //       return userData;
  //      }
  //    )

  //   );
  // }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('userId')
  
    return !(user === null)
  }

  logOut() {
    sessionStorage.clear();
  }
}