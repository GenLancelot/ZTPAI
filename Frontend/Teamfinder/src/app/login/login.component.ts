import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { FormBuilder , Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent{
  firstNameAutofilled: boolean = false;
  lastNameAutofilled: boolean = false;


  loginForm = this.fb.group({
      login: ['', Validators.required],
      password: ['', Validators.required],
  });

  constructor(private loginservice : LoginService, private fb : FormBuilder){}

  login(){
    this.loginservice.loginpost(this.loginForm.value).subscribe(x => {console.log(x)});
  }
}
