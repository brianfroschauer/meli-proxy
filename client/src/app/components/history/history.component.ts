import {Component, Input, OnInit} from '@angular/core';
import {Statistic} from '../../model/statistic.interface';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss']
})
export class HistoryComponent implements OnInit {

  @Input() statistics: Statistic[];

  constructor() {}

  ngOnInit() {
  }
}
