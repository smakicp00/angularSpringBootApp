import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {User} from './component/user/user';




@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontend';
}
