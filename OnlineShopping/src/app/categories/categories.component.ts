import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  productId: number;
  categoryList: any;

  constructor(private route:ActivatedRoute,private categoryService:CategoryService) { }

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
}
