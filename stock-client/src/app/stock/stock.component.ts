import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Stock} from "./stock";
import {StockService} from "./stock.service";

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {


  stocks: Stock[];

  newStock = new Stock();
  constructor(private router: Router, private stockSerive: StockService) { }

  ngOnInit() {
    this.updateList();
  }

  updateList(){
    this.stockSerive.getStocks()
      .subscribe( data => {
        this.stocks = data;
      });
  }

  editStock(stock: Stock) {
    this.stockSerive.editStock(stock)
      .subscribe( data => {
        this.updateList();
        alert("Stock updated successfully.");
      });
  }

  createStock() {
    this.stockSerive.createStock(this.newStock)
      .subscribe( data => {
        this.updateList();
        this.newStock = new Stock();
        alert("Stock created successfully.");
      });
  }
}

