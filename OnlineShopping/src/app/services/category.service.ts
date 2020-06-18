import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private http:HttpClient) { }

  baseUrl="http://localhost:8019/api/v1";

  

  getCategory(id): Observable<any> {
    return this.http.get(`${this.baseUrl}/getCategoryById/${id}`);
  }

  getSingleCategoryImage(id): Observable<any> {
    return this.http.get(`${this.baseUrl}/getSingleCategory/${id}`);
  }
  updateCategory(id, Category: Object): Observable<Object> {
    return this.http.put(this.baseUrl+"/Category/" +id,Category);
  }

  createCategory(categoryName,categoryDescription,price,productd,quantity,uploadfile): Observable<Object> {
    return this.http.post(`${this.baseUrl}/SaveCategory`,categoryName,categoryDescription
    ,price,productd,quantity,uploadfile);
  }
  deleteCategory(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+"/Category/" +id);
  }

  getCategorysList(): Observable<any> {
    return this.http.get(this.baseUrl+"/Categorys");
  }

  
}