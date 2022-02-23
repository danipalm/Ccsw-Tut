import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ClientesService } from 'src/app/clientes/clientes.service';
import { Cliente } from 'src/app/clientes/model/Cliente';
import { DialogSimpleComponent } from 'src/app/core/dialog-simple/dialog-simple.component';
import { GameService } from 'src/app/game/game.service';
import { Game } from 'src/app/game/model/Game';
import { Prestamo } from '../model/Prestamo';
import { PrestamosService } from '../prestamos.service';

@Component({
  selector: 'app-prestamos-edit',
  templateUrl: './prestamos-edit.component.html',
  styleUrls: ['./prestamos-edit.component.scss']
})
export class PrestamosEditComponent implements OnInit {

    games: Game | any;
    prestamo: Prestamo[] | any;
    clientes: Cliente[] | any;

    constructor(
        public dialogRef: MatDialogRef<PrestamosEditComponent>,
        @Inject(MAT_DIALOG_DATA) public data: any,
        private gameService: GameService,
        private clienteService: ClientesService,
        private prestamoService: PrestamosService,
        public dialog: MatDialog
    ) { }

    ngOnInit(): void {
        if (this.data.prestamo != null) {
            this.prestamo = Object.assign({}, this.data.prestamo);
        }
        else {
            this.prestamo = new Prestamo();
        }

        this.clienteService.getClientes().subscribe(
            clientes => {
                this.clientes = clientes;

                if (this.data.prestamo.client != null) {
                    let clienteFilter: Cliente[] = clientes.filter(cliente => cliente.id == this.data.prestamo.cliente.id);
                    if (clienteFilter != null) {
                        this.prestamo.client = clienteFilter[0];
                    }
                }
            }
        );

        this.gameService.getGames().subscribe(
            games => {
                this.games = games

                if (this.data.prestamo.game != null) {
                    let gameFilter: Game[] = games.filter(game => game.id == this.data.prestamo.game.id);
                    if (gameFilter != null) {
                        this.prestamo.game = gameFilter[0];
                    }
                }
            }
        );
    }

    onSave() {


      let fecha_p = new Date(this.prestamo.date_p);
      let fecha_d = new Date(this.prestamo.date_d);
      if (this.prestamo.date_d < this.prestamo.date_p)
      {
        console.log("La fecha de devolucion < prestamo");
        const dialogRef = this.dialog.open(DialogSimpleComponent, {
          data: { title: "Error al crear prestamo", description: "La fecha de devolucion < prestamo" }

      });
      this.dialogRef.close();
        return;
      }
      else if (fecha_d.getDate() - fecha_p.getDate() > 14)
      {
        console.log("La fecha de prestamo máxima es de 14 días");
        const dialogRef = this.dialog.open(DialogSimpleComponent, {
          data: { title: "Error al crear prestamo", description: "La fecha de prestamo máxima es de 14 días" }
      });
      this.dialogRef.close();
        return;
      }
        this.prestamoService.savePrestamo(this.prestamo).subscribe(result => {
            this.dialogRef.close();
        });
    }

    onClose() {
        this.dialogRef.close();
    }

}
