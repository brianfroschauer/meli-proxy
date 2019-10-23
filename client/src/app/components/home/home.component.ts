import { Component, OnInit } from '@angular/core';
import {Statistic} from '../../model/statistic.interface';
import {StatisticService} from '../../services/statistics/statistic.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  statistics: Statistic[] = [];

  constructor(private statisticService: StatisticService) {
  }

  ngOnInit() {
    this.getStatistics();
  }

  getStatistics() {
    this.statisticService.findAll().subscribe(statistics => {
      this.statistics = statistics;
    });
  }
}
