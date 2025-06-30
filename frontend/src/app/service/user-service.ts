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
  public deleteUser(userName: string){
    return this.http.delete<UserModel[]>(`${this.url}/deleteUser/${userName}`);
  }

  public changeUserPassword(changePass: string, newPassword: string){
    console.log(changePass);
    console.log(newPassword);
    return this.http.patch(`${this.url}/changeUserPassword/${changePass}`,
      { newPassword: newPassword },{
        headers: {
          'Content-Type': 'application/json'
        }
      })
  }

  public login(userName: string, password: string){
    const data = {
      userName: userName,
      password: password
    }
    return this.http.post<User>(`${this.url}/login`,data);
  }
}
