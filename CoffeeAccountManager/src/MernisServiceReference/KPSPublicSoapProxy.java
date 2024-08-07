package MernisServiceReference;

public class KPSPublicSoapProxy implements KPSPublicSoap {
  private String _endpoint = null;
  private KPSPublicSoap kPSPublicSoap = null;
  
  public KPSPublicSoapProxy() {
    _initKPSPublicSoapProxy();
  }
  
  public KPSPublicSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initKPSPublicSoapProxy();
  }
  
  private void _initKPSPublicSoapProxy() {
    try {
      kPSPublicSoap = (new KPSPublicLocator()).getKPSPublicSoap();
      if (kPSPublicSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)kPSPublicSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)kPSPublicSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (kPSPublicSoap != null)
      ((javax.xml.rpc.Stub)kPSPublicSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public KPSPublicSoap getKPSPublicSoap() {
    if (kPSPublicSoap == null)
      _initKPSPublicSoapProxy();
    return kPSPublicSoap;
  }
  
  public boolean TCKimlikNoDogrula(long TCKimlikNo, String string, String string2, int dogumYili) throws java.rmi.RemoteException{
    if (kPSPublicSoap == null)
      _initKPSPublicSoapProxy();
    return kPSPublicSoap.TCKimlikNoDogrula(TCKimlikNo, string, string2, dogumYili);
  }
  
  
}