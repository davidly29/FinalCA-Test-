import { Injectable } from '@angular/core';
import {UserModel} from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: UserModel[] = [
  {
    id: 'one',
    firstname: 'Dave',
    lastname: 'Lynn',
    email: 'abc@123.com'
  },
    {
      id: 'two',
      firstname: 'Sam',
      lastname: 'Brian',
      email: 'test@123.com'
    }
  ];
  constructor() { }
  getAllUsers() {
    return [...this.users];
  }
  getUser(userId: string) {
    return {...this.users.find(user => {
      return user.id === userId;
    })};
  }

  deleteUser(userId: string) {
    this.users = this.users.filter(user => {
      return user.id !== userId;
    });
  }
}
