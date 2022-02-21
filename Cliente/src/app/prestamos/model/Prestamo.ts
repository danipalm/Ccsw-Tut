import { Game } from "src/app/game/model/Game";
import { Cliente } from "src/app/clientes/model/Cliente";

export class Prestamo{
  id : number | any;
  game : Game | any;
  cliente : Cliente | any;
  fecha_prestamo : Date | any;
  fecha_devolucion : Date | any;
}
