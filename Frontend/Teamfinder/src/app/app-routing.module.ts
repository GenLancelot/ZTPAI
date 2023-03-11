import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameselectComponent } from './components/gameselect/gameselect.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  { path:'login', component:LoginComponent},
  { path:'register', component:RegisterComponent},
  { path:'gameselect', component:GameselectComponent},
  { path:'', redirectTo:'/login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
