import { TestBed } from '@angular/core/testing';

import { GameselectService } from './gameselect.service';

describe('GameselectService', () => {
  let service: GameselectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GameselectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
