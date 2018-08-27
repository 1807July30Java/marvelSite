import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Character} from '../models/character';
import {CharacterList} from '../models/character-list';

@Injectable({
  providedIn: 'root'
})
export class SuperheroesService {

  constructor(private http: HttpClient) {
  }

  public fetchAllCharacters(): Observable<CharacterList> {
    console.log('Starting to get...');
    return this.http.get<CharacterList>('https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/all.json');
  }

  public fetchSingleCharacter(id: number): Observable<Character> {
    return this.http.get<Character>('https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/id/' + id + '.json');
  }
}
