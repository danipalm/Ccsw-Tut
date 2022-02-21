import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrestamosListComponent } from './prestamos-list/prestamos-list.component';

import { PrestamosEditComponent } from './prestamos-edit/prestamos-edit.component';
import { MatTableModule } from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
@NgModule({
  declarations: [
    PrestamosListComponent,
    PrestamosEditComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule
  ]
})
export class PrestamosModule { }
