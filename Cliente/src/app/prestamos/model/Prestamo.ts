import { Game } from "src/app/game/model/Game";
import { Cliente } from "src/app/clientes/model/Cliente";

export class Prestamo{
  id : number | any;
  game : Game | any;
  client : Cliente | any;
  date_p : Date | any;
  date_d : Date | any;
}
