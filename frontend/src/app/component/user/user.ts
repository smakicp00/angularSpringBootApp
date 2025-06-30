import {Component, inject} from '@angular/core';
import {UserService} from '../../service/user-service';
import {UserModel} from '../../model/user-model';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './user.html',
  styleUrl: './user.css'
})
export class User {

  password: string = "";
  userName: string = "";
  users: UserModel[] = [];
  user: UserModel = new UserModel();
  constructor(private userService: UserService) {}
  ngOnInit() {
    this.loadUsers();
  }

  addUser(){
    this.user.userName = this.userName;
    this.user.password= this.password;
    console.log(this.user);
    this.userService.addUser(this.user).subscribe({next: (data) => {
        console.log(data);
      },
      error: (err) => {
        console.error(err);
      }});
  }

  loadUsers(){
    this.userService.getAllUsers().subscribe({
      next: (data) => {
        console.log(data);
        this.users = data;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
}
