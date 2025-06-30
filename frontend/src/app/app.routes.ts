import { Routes } from '@angular/router';
import {User} from './component/user/user';
import {Login} from './component/login/login';

export const routes: Routes = [
  {
    path:'users',
    component: User
  },
  {
    path:'login',
    component: Login

  },
];
