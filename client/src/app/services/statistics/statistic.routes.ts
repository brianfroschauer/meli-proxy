import {environment} from '../../../environments/environment';

const basePath = environment.apiUrl + '/statistics';

export const StatisticsAPI = {

  get: {
    findAll: () => basePath
  },
};
