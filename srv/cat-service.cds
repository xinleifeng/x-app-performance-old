using sap.crun.performance as my from '../db/data-model';

service PerformanceDataService {
    @readonly entity SNGLRECIN as projection on my.SNGLRECIN;
    @readonly entity SNGLRECOUT as projection on my.SNGLRECOUT;
}
