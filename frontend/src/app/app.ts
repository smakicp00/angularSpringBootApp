import {Component, inject} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {User} from './component/user/user';
import {UserService} from './service/user-service';
import {FormsModule} from '@angular/forms';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontend';


  constructor() {
  }
  private router = inject(Router);
  private userService = inject(UserService);
  userName = "";
  password = "";
  message = ""

  login() {
    this.userService.login(this.userName,this.password).subscribe((data: any) => {
      if (data == null) {
        this.message = "Invalid username or password";

      } else {
        console.log(data);
        this.message = "Login successful";
        localStorage.setItem('loggedUser', JSON.stringify(data));
        this.router.navigate(['/login']);
      }
    })

  }

}
