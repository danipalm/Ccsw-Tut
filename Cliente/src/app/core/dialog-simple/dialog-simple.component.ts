import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-dialog-simple',
  templateUrl: './dialog-simple.component.html',
  styleUrls: ['./dialog-simple.component.scss']
})
export class DialogSimpleComponent implements OnInit {

  title : string | undefined;
  description : string | undefined;

  constructor(
    public dialogRef: MatDialogRef<DialogSimpleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    this.title = this.data.title;
    this.description = this.data.description;
  }

  onClose() {
    this.dialogRef.close(true);
  }

}
