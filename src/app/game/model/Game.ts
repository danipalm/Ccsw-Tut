import { Category } from "src/app/category/model/Category";
import { Author } from "src/app/author/model/Author";


export class Game{
  id : number | any;
  title : string | undefined;
  age : number | any;
  category : Category | any;
  author : Author | any;
}
