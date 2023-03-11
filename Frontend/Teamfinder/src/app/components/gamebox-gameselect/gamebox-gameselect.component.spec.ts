import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GameboxGameselectComponent } from './gamebox-gameselect.component';

describe('GameboxGameselectComponent', () => {
  let component: GameboxGameselectComponent;
  let fixture: ComponentFixture<GameboxGameselectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameboxGameselectComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GameboxGameselectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
