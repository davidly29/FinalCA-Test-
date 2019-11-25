import { Component, OnInit } from '@angular/core';
import {UserModel} from './user.model';
import {UserService} from './user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.page.html',
  styleUrls: ['./user.page.scss'],
})
export class UserPage implements OnInit {
  users: UserModel[];
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.users = this.userService.getAllUsers();
  }

}
