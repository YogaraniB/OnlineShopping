import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../services/category.service';
import { CartService } from '../services/cart.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  productId: number;
  categoryList: any;

  constructor(private route:ActivatedRoute,private cartService:CartService,
    private categoryService:CategoryService,private toastr:ToastrService) { }

  ngOnInit(): void {
    this.productId=parseInt(this.route.snapshot.paramMap.get('productid'));
    this.findCategoriesByProduct();
  }
  findCategoriesByProduct(){
    this.categoryService.findCategoriesByProduct(this.productId).subscribe(data => {
      if (data) {
        this.categoryList=data;
      }
    });
  }
  addToCart(category){
    const userDetais=JSON.parse(sessionStorage.getItem('currentUserDetails'));
    const parameter={
      "category": [ ],
      "usersignupid": userDetais
    };
    parameter.category.push(category);
    console.log(parameter);
    this.cartService.createCart(parameter).subscribe(data => {
      if (data) {
        this.toastr.success('Added to your cart');
      }
    });
  }
}
