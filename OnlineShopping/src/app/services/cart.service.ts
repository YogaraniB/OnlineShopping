import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService  {
 
  constructor(private http:HttpClient) { }

  baseUrl="http://localhost:8019/api/v1";

  

  getCart(id): Observable<any> {
    return this.http.get(`${this.baseUrl}/getCartById/${id}`);
  }

  createCart(Cart: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/Carts`, Cart);
  }

  updateCart(id, Cart: Object): Observable<Object> {
   
    return this.http.put(this.baseUrl+"/Cart/" +id,Cart);
    
  }

  deleteCart(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+"/Cart/" +id);
  }

  getCartsList(): Observable<any> {
    return this.http.get(this.baseUrl+"/Carts");
  }

  
}