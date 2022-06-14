import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Foods, ResponseFoods } from './food.model';
import { FoodService } from './food.service';

@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})
export class FoodsComponent implements OnInit {

  foods: Foods[];

  constructor(private foodService: FoodService) {
    //this.responseFoods = [];
  }

  ngOnInit() {
    this.foodService.getFoods().subscribe(res => this.foods = res)
  }

}
