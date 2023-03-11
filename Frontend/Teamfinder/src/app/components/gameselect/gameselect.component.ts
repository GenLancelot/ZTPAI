import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GameDto } from 'src/app/models/GameDto.interface copy';
import { GameselectService } from 'src/app/services/gameselect.service';

@Component({
  selector: 'app-gameselect',
  templateUrl: './gameselect.component.html',
  styleUrls: ['./gameselect.component.scss']
})
export class GameselectComponent implements OnInit{
  games$! : Observable<GameDto[]>;

  constructor(private gameselectService : GameselectService) {}

  ngOnInit(): void {
    this.games$ = this.gameselectService.getGames();
  }

}
