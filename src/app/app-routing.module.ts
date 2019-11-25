import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: 'user',
  children: [
      {
        path: '',
        loadChildren: './user/user.module#UserPageModule'
    },
    {
      path: ':userId',
      loadChildren: './user/user-details/user-details.module#UserDetailsPageModule'
    }
  ]

  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
