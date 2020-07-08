import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageServiceService {

  constructor() { }

  getLocalStorageItem(key){
  return localStorage.getItem(key);
  }

  setLocalStorage(key,value){
    localStorage.setItem(key,value);
  }

  clearStorage(){
    localStorage.clear();
  }
}
