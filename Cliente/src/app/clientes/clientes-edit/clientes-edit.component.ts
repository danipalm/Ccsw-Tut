import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ClientesService } from '../clientes.service';
import { Cliente } from '../model/Cliente';

@Component({
  selector: 'app-clientes-edit',
  templateUrl: './clientes-edit.component.html',
  styleUrls: ['./clientes-edit.component.scss']
})
export class ClientesEditComponent implements OnInit {

  cliente : Cliente | any;

  constructor(
    public dialogRef: MatDialogRef<ClientesEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private clientesService: ClientesService
  ) { }

  ngOnInit(): void {
    if (this.data.cliente != null) {
      this.cliente = Object.assign({}, this.data.cliente);
    }
    else {
      this.cliente = new Cliente();
    }
  }

  onSave() {
    this.clientesService.saveCliente(this.cliente).subscribe(result => {
      this.dialogRef.close();
    });
  }

  onClose() {
    this.dialogRef.close();
  }

}
