import {inject, Injectable} from '@angular/core';
import {UserModel} from '../model/user-model';
import {HttpClient} from '@angular/common/http';
import {User} from '../component/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor() {
  }

  private http = inject(HttpClient);
  private url = 'http://localhost:8080';

  public getAllUsers() {
    return this.http.get<User[]>(`${this.url}/users`);
  }
  public addUser(user : UserModel){
    console.log(user);
    return this.http.post<User>(`${this.url}/addUser`, user);
  }
}
