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

  getAllPrestamos(): Observable<Prestamo[]> {
    return this.http.get<Prestamo[]>('http://localhost:8080/prestamos');
  }
}
