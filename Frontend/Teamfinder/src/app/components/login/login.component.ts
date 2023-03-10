import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { FormBuilder , Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent{
  loginAutofilled: boolean = false;
  passwordAutofilled: boolean = false;


  loginForm = this.fb.group({
      login: ['', Validators.required],
      password: ['', Validators.required],
  });

  constructor(private loginservice : LoginService, private fb : FormBuilder){}

  login(){
    if(this.loginForm.invalid) return;
    this.loginservice.loginpost(this.loginForm.value).subscribe(x => {console.log(x)});
  }
}
