import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { GameDto } from '../models/GameDto.interface copy';

@Injectable({
  providedIn: 'root'
})
export class GameselectService {

  constructor(private http: HttpClient) { }

  public getGames() : Observable<GameDto[]>{
    return this.http.get<GameDto[]>('http://localhost:8080/gameselect').pipe(
      tap(x => console.log(x))
      );
  }
}
