import {Component, inject} from '@angular/core';
import {UserService} from '../../service/user-service';
import {UserModel} from '../../model/user-model';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.html',
  styleUrl: './user.css'
})
export class User {

  users: UserModel[] = [];
  constructor(private userService: UserService) {}
  ngOnInit() {
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
