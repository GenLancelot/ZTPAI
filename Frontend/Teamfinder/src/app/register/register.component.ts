import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { FormControl, FormGroupDirective, NgForm, Validators, FormGroup, FormBuilder, AbstractControl, ValidatorFn } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';


export default class CustomValidators {
  static match(controlName: string, matchControlName: string): ValidatorFn {
    return (controls: AbstractControl) => {
      const control = controls.get(controlName);
      const matchControl = controls.get(matchControlName);

      if (!matchControl?.errors && control?.value !== matchControl?.value) {
        matchControl?.setErrors({
          matching: {
            actualValue: matchControl?.value,
            requiredValue: control?.value
          }
        });
        return { matching: true };
      }
      return null;
    };
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  loginAutofilled: boolean = false;
  passwordAutofilled: boolean = false;
  passwordRepeatedAutofilled: boolean = false;
  registerForm: FormGroup;

  constructor(private loginservice : LoginService, private fb : FormBuilder){
    this.registerForm = this.fb.group({
      login: ['', Validators.required],
      password: ['', Validators.required],
      passwordRepeated: ['', Validators.required],
    }, 
    {
      validators: [CustomValidators.match('password', 'passwordRepeated')]
    });

  } 

  register(){
    if(this.registerForm.invalid) return;

    
  }

}
