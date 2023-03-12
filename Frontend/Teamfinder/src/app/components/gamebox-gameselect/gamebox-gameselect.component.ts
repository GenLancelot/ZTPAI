import { Component, Input } from '@angular/core';
import { GameDto } from 'src/app/models/GameDto.interface';

@Component({
  selector: 'app-gamebox-gameselect',
  templateUrl: './gamebox-gameselect.component.html',
  styleUrls: ['./gamebox-gameselect.component.scss']
})
export class GameboxGameselectComponent {
 @Input()
 game? : GameDto;
}
