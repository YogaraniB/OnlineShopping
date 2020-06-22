import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriesComponent } from './categories/categories.component';
import { LoginComponent } from './login/login.component';
import { ProductListComponent } from './product-list/product-list.component';


const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'login'},
  {path:'category/:productid',component:CategoriesComponent},
  {path:'login',component:LoginComponent},
  {path:'productlist',component:ProductListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
