import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {StatisticsAPI} from './statistic.routes';
import {Statistic} from '../../model/statistic.interface';

@Injectable({
  providedIn: 'root'
})
export class StatisticService {

  constructor(private http: HttpClient) {}

  public findAll() {
    return this.http.get<Statistic[]>(StatisticsAPI.get.findAll());
  }
}
