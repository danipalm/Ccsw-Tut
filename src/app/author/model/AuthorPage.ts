import { Pageable } from "src/app/core/model/page/Pageable";
import { Author } from "./Author";

export class AuthorPage {
    content: Author[] | any;
    pageable: Pageable | any;
    totalElements: number | any;
}
