import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './model/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/clientes');
  }

  saveCliente(category: Cliente): Observable<Cliente> {
    let url = 'http://localhost:8080/clientes';
        if (category.id != null) url += '/'+category.id;

        return this.http.put<Cliente>(url, category);
  }

  deleteCliente(idCliente : number): Observable<any> {
    return this.http.delete('http://localhost:8080/clientes/'+idCliente);
  }
}
