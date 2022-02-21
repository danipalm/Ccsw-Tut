import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Cliente } from '../model/Cliente';
import { ClientesService } from '../clientes.service';
import { MatDialog } from '@angular/material/dialog';
import { ClientesEditComponent } from '../clientes-edit/clientes-edit.component';
import { DialogConfirmationComponent } from 'src/app/core/dialog-confirmation/dialog-confirmation.component';

@Component({
  selector: 'app-clientes-list',
  templateUrl: './clientes-list.component.html',
  styleUrls: ['./clientes-list.component.scss']
})
export class ClientesListComponent implements OnInit {

  dataSource = new MatTableDataSource<Cliente>();
  displayedColumns: string[] = ['id', 'name', 'action'];

  constructor(private clientesService: ClientesService, public dialog: MatDialog,) { }

  createCliente() {
    const dialogRef = this.dialog.open(ClientesEditComponent, {
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  editCliente(cliente: Cliente) {
    const dialogRef = this.dialog.open(ClientesEditComponent, {
      data: { cliente: cliente }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  deleteCliente(cliente: Cliente) {
    const dialogRef = this.dialog.open(DialogConfirmationComponent, {
      data: { title: "Eliminar cliente", description: "Atención si borra el cliente se perderán sus datos.<br> ¿Desea eliminarlo?" }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.clientesService.deleteCliente(cliente.id).subscribe(result => {
          this.ngOnInit();
        });
      }
    });
  }

  ngOnInit(): void {
    this.clientesService.getClientes().subscribe(
      clientes => this.dataSource.data = clientes
    );
  }

}
