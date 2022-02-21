import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrestamosListComponent } from './prestamos-list/prestamos-list.component';

import { PrestamosEditComponent } from './prestamos-edit/prestamos-edit.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    PrestamosListComponent,
    PrestamosEditComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],providers: [
    {
        provide: MAT_DIALOG_DATA,
        useValue: {},
    },
]
})
export class PrestamosModule { }
