import { Injectable } from '@angular/core';
import { Pageable } from '../core/model/page/Pageable';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PrestamoPage } from './model/PrestamoPage';
import { Prestamo } from './model/Prestamo';

@Injectable({
  providedIn: 'root'
})
export class PrestamosService {



  constructor(private http : HttpClient) { }

  getPrestamos(pageable: Pageable): Observable<PrestamoPage> {
    return this.http.post<PrestamoPage>('http://localhost:8080/prestamos', {pageable:pageable});
  }

  getCustomPrestamos(gameId?: number, clienteId?: number): Observable<Prestamo[]> {
    return this.http.get<Prestamo[]>(this.composeFindUrl(gameId, clienteId));
}

  getAllPrestamos(): Observable<Prestamo[]> {
    return this.http.get<Prestamo[]>('http://localhost:8080/prestamos');
  }

  savePrestamo(prestamo: Prestamo) {
    let url = 'http://localhost:8080/prestamos';

    return this.http.put<void>(url, prestamo);
  }
  deletePrestamo(idPrestamo : number): Observable<void> {
    return this.http.delete<void>('http://localhost:8080/prestamos/'+idPrestamo);
}



  private composeFindUrl(gameId?: number, clienteId?: number) : string {
    let params = '';

    if (gameId != null) {
      if (params != '') params += "&";
      params += "idGame="+gameId;
  }

    if (clienteId != null) {
        if (params != '') params += "&";
        params += "idCliente="+clienteId;
    }

    let url = 'http://localhost:8080/prestamos'

    if (params == '') return url;
    else return url + '?'+params;
}
}
