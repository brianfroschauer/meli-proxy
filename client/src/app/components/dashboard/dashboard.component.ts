import {Component, OnInit} from '@angular/core';
import {StatisticService} from '../../services/statistics/statistic.service';
import {Statistic} from '../../model/statistic.interface';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public statistics: Statistic[] = [];
  public data: any[] = [];

  constructor(private statisticService: StatisticService) {
  }

  ngOnInit() {
    this.getStatistics();
  }

  setChartData() {
    this.getTotal();
    this.getSuccess();
    this.getError();
    this.getRateLimit();
  }

  getTotal() {
    const total = { 'name': 'Total', 'series': []};
    this.statistics.forEach(statistic => {
      total.series.push({
        name: new Date(statistic.date),
        value: statistic.total
      });
    });
    this.data.push(total);
  }

  getSuccess() {
    const success = { 'name': 'Success', 'series': []};
    this.statistics.forEach(statistic => {
      success.series.push({
        name: new Date(statistic.date),
        value: statistic.success
      });
    });
    this.data.push(success);
  }

  getError() {
    const error = { 'name': 'Error', 'series': []};
    this.statistics.forEach(statistic => {
      error.series.push({
        name: new Date(statistic.date),
        value: statistic.error
      });
    });
    this.data.push(error);
  }

  getRateLimit() {
    const rateLimit = { 'name': 'Rate Limit', 'series': []};
    this.statistics.forEach(statistic => {
      rateLimit.series.push({
        name: new Date(statistic.date),
        value: statistic.rateLimit
      });
    });
    this.data.push(rateLimit);
  }

  getStatistics() {
    this.statisticService.findAll().subscribe(statistics => {
      this.statistics = statistics;
      this.setChartData();
    });
  }
}
