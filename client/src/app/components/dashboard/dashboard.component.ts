import { Component, OnInit } from '@angular/core';
import {Statistic} from '../../model/statistic.interface';
import {StatisticService} from '../../services/statistics/statistic.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  statistics: Statistic[];

  constructor(private statisticService: StatisticService) { }

  ngOnInit() {
    this.statistics = [];
    this.getStatistics();
  }

  getStatistics() {
    this.statisticService.findAll().subscribe(statistics => {
      this.statistics = statistics;
    });
  }
}
