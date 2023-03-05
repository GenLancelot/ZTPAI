import { Injectable } from '@angular/core';
import { tap, Observable } from 'rxjs';
import { afterLoginDto } from './models/afterLoginDto.interface';
import { loginDto } from './models/loginDto.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  public loginpost(user : loginDto) : Observable<afterLoginDto>{
    return this.http.post<afterLoginDto>('http://localhost:8080/login', user).pipe(
      tap(x => console.log(x))
      );
  }
}
