import { Injectable } from '@angular/core';
import{HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Foods, ResponseFoods } from './food.model';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private url = "http://localhost:8081/food/";

  constructor(private http: HttpClient) { }

  getFoods(): Observable<Foods[]>{
    return this.http.get<Foods[]>(this.url);
  }
}
