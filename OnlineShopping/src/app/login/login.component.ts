import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userRole='';
  userId ;
  password = ''
  invalidLogin = false;
  userRoleList: any = ['Admin','User'];
  constructor() { }

  ngOnInit(): void {
  }

}
