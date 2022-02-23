import { Component, OnInit } from '@angular/core';
import { PrestamosService } from '../prestamos.service';
import { PrestamosEditComponent } from '../prestamos-edit/prestamos-edit.component';
import { GameService } from 'src/app/game/game.service';
import { Game } from 'src/app/game/model/Game';
import { PageEvent } from '@angular/material/paginator';
import { Pageable } from 'src/app/core/model/page/Pageable';
import { Prestamo } from '../model/Prestamo';
import { MatTableDataSource } from '@angular/material/table';
import { Cliente } from 'src/app/clientes/model/Cliente';
import { ClientesService } from 'src/app/clientes/clientes.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogConfirmationComponent } from 'src/app/core/dialog-confirmation/dialog-confirmation.component';
import { filter } from 'rxjs';
@Component({
  selector: 'app-prestamos-list',
  templateUrl: './prestamos-list.component.html',
  styleUrls: ['./prestamos-list.component.scss']
})
export class PrestamosListComponent implements OnInit {

  clientes : Cliente[] | any;
  games: Game[] | any;
  prestamos : Prestamo[] | any;
  filterCliente: Cliente | any;
  filterGame: Game | any;
  filterDate : Date | any;

  pageNumber: number = 0;
  pageSize: number = 5;
  totalElements: number = 0;

  dataSource = new MatTableDataSource<Prestamo>();
  displayedColumns: string[] = ['id', 'game', 'client', 'date_p', 'date_d','action'];

  constructor( private prestamosService: PrestamosService,
    private clientesService: ClientesService,
    private gameService : GameService,
    public dialog: MatDialog,) { }

  ngOnInit(): void {

    this.loadPage();

    this.gameService.getGames().subscribe(
      games => this.games = games
  );

  this.clientesService.getClientes().subscribe(
    clientes => this.clientes = clientes
  );


  }

  onCleanFilter(): void {
    this.filterGame = null;
    this.filterDate = null;
    this.filterCliente = null;


    this.onSearch();
}

onSearch(): void {

    let gameId = this.filterGame != null ? this.filterGame.id : null;
    let clienteId = this.filterCliente != null ? this.filterCliente.id : null;
    let fecha = this.filterDate != null ? this.filterDate : null;
    console.log("gameId = " + gameId + "| cliente: " + clienteId + "| fecha: " + fecha );

    this.prestamosService.getCustomPrestamos(gameId, clienteId, fecha).subscribe(
    prestamos => this.prestamos = prestamos

    );
    this.dataSource = this.prestamos;

}

createPrestamo() {
    const dialogRef = this.dialog.open(PrestamosEditComponent, {
        data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
    });
}

deletePrestamo(prestamo: Prestamo) {
  const dialogRef = this.dialog.open(DialogConfirmationComponent, {
      data: { title: "Eliminar Prestamo", description: "Atención si borra el prestamo se perderán sus datos.<br> ¿Desea eliminar el prestamo?" }
  });

  dialogRef.afterClosed().subscribe(result => {
      if (result) {
          this.prestamosService.deletePrestamo(prestamo.id).subscribe(result =>  {
              this.ngOnInit();
          });
      }
  });
}

loadPage(event?: PageEvent) {

  let pageable : Pageable =  {
      pageNumber: this.pageNumber,
      pageSize: this.pageSize,
      sort: [{
          property: 'id',
          direction: 'ASC'
      }]
  }

  if (event != null) {
      pageable.pageSize = event.pageSize
      pageable.pageNumber = event.pageIndex;
  }

  this.prestamosService.getPrestamos(pageable).subscribe(data => {
      this.dataSource.data = data.content;
      this.pageNumber = data.pageable.pageNumber;
      this.pageSize = data.pageable.pageSize;
      this.totalElements = data.totalElements;
  });

}



}
