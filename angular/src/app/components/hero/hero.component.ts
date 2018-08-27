import {Component, OnInit} from '@angular/core';
import {SuperheroesService} from '../../services/superheroes.service';
import {Character} from '../../models/character';
import {CharacterList} from '../../models/character-list';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {

  constructor(private heroService: SuperheroesService) {
  }

  public chars: Character[];

  getAllHero(): void {
    this.heroService.fetchAllCharacters()
      .subscribe(
        (cList: CharacterList) => {
          this.chars = cList.chars;
        },
        error => console.log(`Error: ${error}`)
        // character => this.character = character,
        // error => console.log(`Error: ${error}`)
      );
    console.log(this.chars);
  }

  ngOnInit() {
  }
}
