import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule, MatInputModule, MatTableModule} from "@angular/material";
import {HttpClientModule} from "@angular/common/http";
import { StockComponent } from './stock/stock.component';
import {StockService} from "./stock/stock.service";
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    StockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule,
    MatTableModule,
    HttpClientModule
  ],
  providers: [StockService],
  bootstrap: [AppComponent]
})
export class AppModule { }
