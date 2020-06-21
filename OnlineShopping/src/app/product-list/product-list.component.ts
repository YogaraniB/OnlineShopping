import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productList: any;
src;
  image;

  constructor(private productService:ProductService,private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.productService.getProductsList().subscribe(data => {
      if (data) {
        this.productList=data.list;
      }
    });
    
  }
}
