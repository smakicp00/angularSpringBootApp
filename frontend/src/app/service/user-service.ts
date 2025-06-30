import {inject, Injectable} from '@angular/core';
import {UserModel} from '../model/user-model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor() {
  }

  private http = inject(HttpClient);
  private url = 'http://localhost:8080/users';

  public getAllUsers() {
    this.http.get<UserModel[]>(this.url);

    return this.http.get<UserModel[]>(this.url);
  }
}
