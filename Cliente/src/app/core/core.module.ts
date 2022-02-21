import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';

import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';
import { DialogConfirmationComponent } from './dialog-confirmation/dialog-confirmation.component';


@NgModule({
  declarations: [
    HeaderComponent,
    DialogConfirmationComponent
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatToolbarModule,
    RouterModule
  ],
  exports: [
    HeaderComponent
  ]
})
export class CoreModule { }
