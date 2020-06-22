import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { ToastrService } from 'ngx-toastr';
import { UserSignupService } from '../services/user-signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userRole='';
  userId='' ;
  password = ''
  invalidLogin = false;
  userRoleList: any = ['Admin','User'];
  constructor(private authentocationService: AuthenticationServiceService,
    private toastr: ToastrService,private router: Router,private userService:UserSignupService) { }

  ngOnInit(): void {
    this.authentocationService.logOut();
  }
  checkLogin(){
    if(this.userRole===''){
      this.toastr.error("Please Select any User Role");
      return;
    }else if(this.userId===''){
      this.toastr.error("Please Enter Admin/User Id");
      return;
    }
    else if(this.password===''){
      this.toastr.error("Please Enter Password");
      return;
    }
    else{
      if((this.userRole)==='Admin'){
        sessionStorage.setItem('userRole','Admin');
        if(this.userId==='Admin' && this.password==='password'){
          sessionStorage.setItem('userId',this.userId);
          sessionStorage.setItem('password',this.password);
          this.router.navigate(['productlist']);
          this.invalidLogin = false;
        }else{
          this.invalidLogin = true
            this.toastr.error("Invalid Credentials, UserName or Password is incorrect");
        }
      }else{
        this.userService.getUserSignUp(this.userId).subscribe(data => {
          if (data.password===this.password) {
            sessionStorage.setItem('currentUserDetails',JSON.stringify(data));
            sessionStorage.setItem('userId',this.userId);
            sessionStorage.setItem('password',this.password);
            this.router.navigate(['productlist']);
            this.invalidLogin = false;
          }
          else{
            this.invalidLogin = true
            this.toastr.error("Invalid Credentials, UserName or Password is incorrect");
          }
            this.invalidLogin = false
        },
        error => {
          this.invalidLogin = true
          this.toastr.error("Invalid Credentials, UserName or Password is incorrect");
        }
      )
    }
   
    }
  
  }
}
