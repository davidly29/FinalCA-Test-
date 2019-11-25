import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';
import {UserModel} from '../user.model';
import {AlertController} from '@ionic/angular';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.page.html',
  styleUrls: ['./user-details.page.scss'],
})
export class UserDetailsPage implements OnInit {
  loadedUser: UserModel;
  constructor(private activatedRoute: ActivatedRoute, private  router: Router,
              private alertCrl: AlertController, private  userService: UserService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      if (!paramMap.has('userId')) {
        // redirect
        return;
      }
      const userId = paramMap.get('userId');
      this.loadedUser = this.userService.getUser(userId);
    });
  }

  onDeleteUser() {
    this.alertCrl.create({
      header: 'Are you sure you want to delete ?',
      message: 'This user will be deleted, Continue ?',
      buttons: [{
        text: 'Cancel',
        role: 'cancel'
      },
        {
          text: 'Delete',
          handler: () => {
            this.userService.deleteUser(this.loadedUser.id);
            this.router.navigate(['/user']);
          }
        }
      ]
    }).then(alertEl => {
      alertEl.present();
    });
  }

}
