import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Stock} from "./stock";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class StockService {

  constructor(private http:HttpClient) {}


  //private stockUrl = 'http://localhost:8080/api/stocks';

  private stockUrl = '/api/stocks';

  public getStocks() {
    return this.http.get<Stock[]>(this.stockUrl);
  }


  public createStock(stock) {
    return this.http.post<Stock>(this.stockUrl, stock);
  }

  public editStock(stock) {
    return this.http.put<Stock>(this.stockUrl+'/'+stock.id, stock);
  }

}
