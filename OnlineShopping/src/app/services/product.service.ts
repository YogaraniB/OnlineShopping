import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  baseUrl="http://localhost:8019/api/v1";

  

  getProduct(id): Observable<any> {
    return this.http.get(`${this.baseUrl}/getProductById/${id}`);
  }

  getSingleProductImage(id): Observable<any> {
    return this.http.get(`${this.baseUrl}/getSingleProduct/${id}`);
  }
  updateProduct(id, Product: Object): Observable<Object> {
    return this.http.put(this.baseUrl+"/Product/" +id,Product);
  }

  createProduct(productName,uploadfile): Observable<Object> {
    return this.http.post(`${this.baseUrl}/SaveProduct`, productName,uploadfile);
  }
  deleteProduct(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+"/Product/" +id);
  }

  getProductsList(): Observable<any> {
    return this.http.get(this.baseUrl+"/Products");
  }

  
}