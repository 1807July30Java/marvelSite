import { TestBed, inject } from '@angular/core/testing';

import { SuperheroesService } from './superheroes.service';

describe('SuperheroesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SuperheroesService]
    });
  });

  it('should be created', inject([SuperheroesService], (service: SuperheroesService) => {
    expect(service).toBeTruthy();
  }));
});
