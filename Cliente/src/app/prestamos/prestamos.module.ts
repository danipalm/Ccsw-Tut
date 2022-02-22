import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrestamosListComponent } from './prestamos-list/prestamos-list.component';
import { PrestamosEditComponent } from './prestamos-edit/prestamos-edit.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatOptionModule } from '@angular/material/core';
import { MatDialogModule, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    PrestamosListComponent,
    PrestamosEditComponent,
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
    MatPaginatorModule,
    MatOptionModule,
    MatCardModule,
    MatSelectModule,
    HttpClientModule
  ],providers: [
    {
        provide: MAT_DIALOG_DATA,
        useValue: {},
    },
]
})
export class PrestamosModule { }
