import { Component, ElementRef, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GameDto } from 'src/app/models/GameDto.interface';
import { GameselectService } from 'src/app/services/gameselect.service';

@Component({
  selector: 'app-gameselect',
  templateUrl: './gameselect.component.html',
  styleUrls: ['./gameselect.component.scss']
})
export class GameselectComponent implements OnInit{
  searchText?: string;
  selectedIndex? : number  = -1;
  gamesArray! : GameDto[];

  constructor(private gameselectService : GameselectService, private el : ElementRef) {}

  ngOnInit(): void {
    this.gameselectService.getGames().subscribe(x => {this.gamesArray = x});
  }

  changeSelected(gameDto:GameDto){
    if(gameDto.isSelected === false || gameDto.isSelected === undefined){
      let indexSelected = this.gamesArray.findIndex(x => x.isSelected === true);
      if(indexSelected >= 0){
        this.gamesArray[indexSelected].isSelected = false;
      }
      gameDto.isSelected = true;
    }
    else{
      gameDto.isSelected = false;
    }
  }
}
