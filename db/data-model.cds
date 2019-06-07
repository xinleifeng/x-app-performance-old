namespace sap.crun.performance;

entity SNGLRECIN {
  key ID : Integer;
  TRANSID: String;
  CONNID: String;
  CONNCOUNTER: String;
  CDATE: String;
  CTIME: String;
  SERVICEID: String;
}

entity SNGLRECOUT {
  key ID : Integer;
  SNGLREFTO: String;
  TRANSID: String;
  CONNID: String;
  CONNCOUNTER: String;
  CDATE: String;
  CTIME: String;
  SERVICEID: String;
}